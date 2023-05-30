package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddToCartTest extends BaseClass

{

	@Test
	 public void addToCartTest()
	   {
		   
		SoftAssert  soft = new SoftAssert();
		 home.clickGearsTab();
		 home.clickSkillaryDemoApp();
		 web.handleChildBrowser();
		
	   soft.assertTrue(demoApp.getLogotext().contains("ECommerce"));
	   
	   demoApp.mouseHoverToCourse(web);
	   demoApp.clickSeleniumTraining();
	   
	   soft.assertEquals(selenium.getPageHeader(), "Selenium Training");
	   int initialQuantity=Integer.parseInt(selenium.getQuantity());
	   selenium.doubleClickPlusButton(web);
	   int finalQuantity=Integer.parseInt(selenium.getQuantity());
	   
	   soft.assertEquals(finalQuantity,initialQuantity+1);
	   selenium.clickToAddCart();
	   web.handleAlert("ok");
	   soft.assertEquals(selenium.getMessage(),"Item added to cart");
	   soft.assertAll();
	   
	   }
	
	
	
	
	
	
	
	
	
	
	
}
