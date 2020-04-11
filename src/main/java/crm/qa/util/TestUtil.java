package crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.Utils;

public class TestUtil {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public static long PageLoadTimeout = 30;
    public static long implictlywait = 60;
	
	public static void capturescreenshot(WebDriver driver , String screenshotname)
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
        Utils.copyFile(source, new File("./screenshots/"+screenshotname+".png"));
    	
    }
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\LENOVO\\eclipse-workspace\\TestingAssignments\\src\\main\\java\\crm\\qa\\TestData\\Product_Submodule.xlsx";
	
	static Workbook wb;
	static Sheet sheet;
	
	public static Object[][] getTestData(String SheetName)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(TESTDATA_SHEET_PATH);
			try {
				wb = WorkbookFactory.create(fis);
				sheet = wb.getSheet(SheetName);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0 ; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}
	
	



}
