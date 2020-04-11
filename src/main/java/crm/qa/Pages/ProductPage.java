package crm.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import crm.qa.TestBase.TestBase;

public class ProductPage extends TestBase

{
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	public AmulButterSearchPage searchNewProduct(String Scenario, String StepDesc, String PrdSearch, String NoofclickPrdQty,String ActualQty,
			String totalPrice) {

		String SearchTextboxxpath = "//input[@placeholder='Search']";
		String ProductLinkXpath = "//span[contains(text(),'Amul Butter 100 gm (pc)')]";
		
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath(SearchTextboxxpath)).clear();
			driver.findElement(By.xpath(SearchTextboxxpath)).sendKeys(PrdSearch);
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

			try {
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(ProductLinkXpath)).click();
			 Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

//		if (driver.findElement(By.xpath(Product_NameXapth)).getText().equals("Amul Butter 100 gm (pc)")) {
//			Assert.assertTrue(true);
//		} else {
//
//			Assert.assertTrue(false);
//		}
       
			
		// convert string to integer 	
		 System.out.println(NoofclickPrdQty);
		 String Str = NoofclickPrdQty;
	     Integer i=Integer.valueOf(Str); 
	     
      	if(driver.findElement(By.xpath("//h1[contains(text(),'Amul Butter 100 gm (pc)')]")).getText().equals("Amul Butter 100 gm (pc)")) {
      	Assert.assertTrue(true);	
		for(int j =0; j<i; j++)
		{
			try {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a[@class='quantity_button plus arrow_icon']")).click();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}			
		}
		// Actual value of Product
		 String ActualQuantity=driver.findElement(By.xpath("//input[@id='input-quantity']")).getAttribute("value");
	     System.out.println(ActualQuantity);
	     
		if(ActualQuantity.equalsIgnoreCase(ActualQty))
		{
			Assert.assertTrue(true);
		
		
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("quantity is not matching------");
		
		
		}
		System.out.println("........click on the Add car button.......");
		try {
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@id='button-cart']")).click();
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	}else {
			
			Assert.assertTrue(false);
			System.out.println(driver.findElement(By.xpath("Maximum order amount for Amul Butter 100 gm (pc) is 2!")).getText());
		}
		
		
		System.out.println("Help karo" );

		try {
			Thread.sleep(3000);
			WebElement MouseoverCartXpath = driver.findElement(By.xpath("//div[@class='cart_holder']"));

			Actions action = new Actions(driver);
			Thread.sleep(1000);
			action.moveToElement(MouseoverCartXpath).build().perform();
			
			String Price=driver.findElement(By.xpath("//*[@class='content']/div[2]/table/tbody/tr[4]/td[2]")).getText();
			System.out.println(Price);
			
			if(Price.equalsIgnoreCase(totalPrice))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false, "After Adding item inside the cart amount is not matching====");
			}
			
			
			
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		return new AmulButterSearchPage();

	}

	public AmulButterSearchPage ClickCategoryLink(String Scenario, String StepDesc, String Category_Name,String sub_Category_Name) {

		
		List<WebElement> MenuLinkList = driver.findElements(By.xpath("//div[@class='box category_module']/ul/li/a"));
		int MenuLinkList_Count = MenuLinkList.size();
		System.out.println("Total Number of Product list count are " + MenuLinkList_Count);

		for (int i = 0; i < MenuLinkList_Count; i++) {

			try {
				
				String MenuListText = MenuLinkList.get(i).getText();

				System.out.println(MenuListText);

			
				if (MenuListText.equals(Category_Name)) {
					try {

						try {
							Thread.sleep(2000);
							String ElementExpath = "//a[@class='sub_trigger'][contains(text(),'BREAD, EGGS & DAIRY')]";
							Actions action = new Actions(driver);
							WebElement ManinMenuXpath = driver.findElement(By.xpath(ElementExpath));

							action.moveToElement(ManinMenuXpath).build().perform();
							Thread.sleep(2000);
							break;
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}

						List<WebElement> SubMenuListXpath = driver.findElements(By.xpath("//*[@id='column-left']/div/ul/li[5]/div/ul/li/a"));


						int SubmenuListCount = SubMenuListXpath.size();
					
						for (int n = 0; n < SubmenuListCount; n++) {

							try {
								
								String SubMenuListText = SubMenuListXpath.get(n).getText();

								System.out.println(SubMenuListText + "...");

								if (SubMenuListText.equals(sub_Category_Name)) {

									try {
										Thread.sleep(1000);
										
										SubMenuListXpath.get(n).click();
										Thread.sleep(2000);
										break;
									} catch (Exception e) {
										e.printStackTrace();
									}
									

								}
								
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					} catch (Exception e) {

						e.printStackTrace();
					}

				} else {

				}
				Thread.sleep(3000);
			} catch (Exception e1) {

				e1.printStackTrace();
			}

		}

		return new AmulButterSearchPage();

	}
	
	
       public AmulButterSearchPage SearchProductAndVerifyDescription(String Scenario, String StepDesc, String PrdSearch, String Categoryname,String ProductDescription) {

		
		
		String SearchNewTextXPath ="//input[@placeholder='Search']";
		
		String SearchBtnXpath ="//i[@class='icon-search button-search hover_icon']";
        String productNameXpathLinkString ="//a[contains(text(),'Aashirvaad Sudh Chakki atta 10 kg (pc)')]";
        String ProductNameTextXpath ="//h1[contains(text(),'Aashirvaad Sudh Chakki atta 10 kg (pc)')]";
        String ProductDescriptionXpath ="//div[@id='tab-description']";
        
        
		System.out.println("Welcome to new Text case");
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(SearchNewTextXPath)).clear();
			driver.findElement(By.xpath(SearchNewTextXPath)).sendKeys(PrdSearch);
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("NOt able to enter the data in search field"+e);
		}	
		

		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(SearchBtnXpath)).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("NOt able to click on the Search button"+e);	
			
		}
		
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath(productNameXpathLinkString)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("NOt able to click on product link"+e);		
			}
		
		
		try {
			Thread.sleep(2000);
			String ProductNameText =driver.findElement(By.xpath(ProductNameTextXpath)).getText();
			System.out.println("Product Name:" + ProductNameText);
			if(ProductNameText.equalsIgnoreCase(PrdSearch)) {
				
				Assert.assertTrue(true);
				System.out.println("Product Name matched....");
			}else {
				Assert.assertTrue(false);
				System.out.println("Priduct Name is not matching");
				
			}
			Thread.sleep(2000);
		} catch (Exception e1) {
			System.out.println(e1);
		}
		

		try {
			Thread.sleep(2000);
			String ProductDescripText =driver.findElement(By.xpath(ProductDescriptionXpath)).getText();
			System.out.println("Product Name:" + ProductDescripText);
			if(ProductDescripText.equalsIgnoreCase(ProductDescription)) {
				
				Assert.assertTrue(true);
				System.out.println("Product Description matched");
			}else {
				Assert.assertTrue(false);
				System.out.println("Priduct Description is not matching");
				
			}
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}


		return new AmulButterSearchPage();

	}


}
