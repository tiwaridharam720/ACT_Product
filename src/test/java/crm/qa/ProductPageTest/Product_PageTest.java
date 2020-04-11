package crm.qa.ProductPageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.qa.Pages.AmulButterSearchPage;
import crm.qa.Pages.ProductPage;
import crm.qa.TestBase.TestBase;
import crm.qa.util.TestUtil;

public class Product_PageTest extends TestBase{
	


	public static ProductPage Productpage;
	public static TestUtil util;
	public static AmulButterSearchPage homePage;
	
	
	// Inherit from parent class   

	
	private String SheetName="ProductSearch";
	private String SheetName1 ="SubModule";
	private String SheetName2="ProductVerification";
	
	public Product_PageTest()
	{
		super();
	}
	
	
	

	@BeforeMethod
	public void setup() throws InterruptedException {
		
		
		initailization();
		
		Productpage = new ProductPage();
   }
	
	@DataProvider
	public Object[][] get_Product_SearchTestData() throws Exception
	{
		Object[] [] data= util.getTestData(SheetName);
		return data;
	}
	
	
	
	@Test(priority =1, dataProvider="get_Product_SearchTestData", enabled=true)
	public void ProductQtyAdd(String Scenario, String StepDesc,String PrdSearch,String NoofclickPrdQty,String ActualQty,String TotalPrice) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Productpage.searchNewProduct(Scenario, StepDesc, PrdSearch,NoofclickPrdQty,ActualQty,TotalPrice);
		
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
     
	
	@DataProvider
	public Object[][] get_SubModuleTestData() throws Exception
	{
		Object[] [] data= util.getTestData(SheetName1);
		return data;
	}
	
	
	@Test(priority =3, dataProvider="get_SubModuleTestData", dependsOnMethods = "ProductAndVerifyDescription" , enabled=true)
	public void selectSubMenu(String Scenario, String StepDesc,String Category_Name, String sub_Category_Name) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Productpage.ClickCategoryLink(Scenario, StepDesc, Category_Name,sub_Category_Name);
		
			Thread.sleep(1000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	@DataProvider
	public Object[][] get_ProductVerification_TestData() throws Exception
	{
		Object[] [] data= util.getTestData(SheetName2);
		return data;
	}
	
	
	@Test(priority =2, dataProvider="get_ProductVerification_TestData", enabled=true)
	public void ProductAndVerifyDescription(String Scenario, String StepDesc, String PrdSearch, String Categoryname,String ProductDescription) throws InterruptedException
	{
		try {
			Thread.sleep(1000);
			Productpage.SearchProductAndVerifyDescription(Scenario, StepDesc, PrdSearch,Categoryname,ProductDescription);
		
			Thread.sleep(1000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}




}
