package crm.qa.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import crm.qa.util.TestUtil;



public class TestBase {
	
	
    public static WebDriver driver;
	public static Properties prop;
	public static TestUtil util;
	
	
	public TestBase() {
		
		
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\LENOVO\\eclipse-workspace\\TestingAssignments\\src\\main\\java\\crm\\qa\\config\\config.properties");
			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch(IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	// Browser Setup
	
	
	public static void initailization() throws InterruptedException {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) { 
			
			
			System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
			  
			  //WebDriver Driver = new FirefoxDriver();
			  
			  driver = new ChromeDriver();
       	
			
			
		}else if(browserName.equals("ff")) { 
			
			
		    FirefoxOptions firefoxOptions = new FirefoxOptions();
		    firefoxOptions.setCapability("marionette", true);
		    driver = new FirefoxDriver(firefoxOptions);
         	
			
            
			

			
			
			}else {
				
				System.out.println("Broser not found");
			}
		     
		
		    driver.manage().window().maximize();

		    
		    driver.manage().deleteAllCookies();
		
		    driver.manage().timeouts().pageLoadTimeout(util.PageLoadTimeout, TimeUnit.SECONDS);
		   

		    driver.manage().timeouts().implicitlyWait(util.implictlywait, TimeUnit.SECONDS);
		    
//		     //   driver.get("atcost.in");
		    
		    Thread.sleep(10000);
		    driver.get(prop.getProperty("url"));
		    Thread.sleep(10000);
		    System.out.println("Welcome home");
		    
	}
	


}
