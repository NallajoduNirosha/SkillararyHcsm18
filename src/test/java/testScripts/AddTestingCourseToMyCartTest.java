package testScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

 
  public class AddTestingCourseToMyCartTest extends BaseClass
  {
	  @Test
    
     
   public  void addPytonToMyCart()
   {
	   SoftAssert soft = new SoftAssert();
	   
	   home.clickGearsTab();
	   home.clickSkillaryDemoApp();
	   web.handleChildBrowser();
	   
	   soft.assertTrue(demoApp.getLogotext().contains("ECommerce"));
	   demoApp.selectcategory(web, 1);
	   
	   soft.assertEquals(testing.getPageHeader(), "Testing");
	   
	   web.scrollToElement(testing.getPythonImage());
	   web.dragAndDropElement(testing.getPythonImage(),testing.getMyCart());
	   
	   web.scrollToElement(testing.getFacebookIcon());
	   testing.clickFacebook();
	   
     soft.assertAll();	   
   }
	
}
