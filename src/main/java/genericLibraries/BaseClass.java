package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomClasses.ContactUspage;
import pomClasses.SeleniumTrainingPage;


import pomClasses.SkillraryDemoAppPage;
import pomClasses.SkillraryHomePage;
import pomClasses.TestingPage;

public class BaseClass 
{
	protected PropertiesUtility property;
	protected Excelutility excel;
	protected WebDriverUtility web;
	protected WebDriver  driver;
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected ContactUspage contact;
	
	
    //@BeforeSuite
	
	//@BeforeTest
	
	@BeforeClass
	public void classConfig() 
	{
		property=new PropertiesUtility();
		excel=new Excelutility();
		web=new WebDriverUtility();
		
		property.propertiesInit(IConstantpath.PROPERTIES_PATH);
		excel.excelInit(IConstantpath.EXCEL_PATH);
	}
	@BeforeMethod
	public void methodConfig()
	{
	 driver = web.launchBrowser(property.readData("browser"));
	web.maximizeBrowser();
	web.navigateToApp(property.readData("url"));
	web.waitUntilElementFound(Long.parseLong(property.readData("time")));
	
	home =new SkillraryHomePage(driver);
	demoApp =new SkillraryDemoAppPage (driver);
	selenium = new SeleniumTrainingPage(driver);
	testing = new TestingPage(driver);
	contact = new ContactUspage(driver);
	home.chooseEnglish();
	}
	
	@AfterMethod
	public void methodTearDown() 
	{
		web.quitAllWindows();
	}
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//AfterSuite
}
