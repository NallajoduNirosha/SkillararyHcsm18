package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class SkillraryDemoAppPage
{
  @FindBy(xpath="//a[@class='navbar-brand']")//skillarye-commerace inspect
  private WebElement logo;
  
  @FindBy(id="course")//inspect couse tab
  private WebElement courseTab;
  
  @FindBy(xpath="//span/a[text()='Selenium Training']")
  private WebElement seleniumTrainingLink;
  
  @FindBy(name="addresstype")
  private WebElement categoryDD;
  
  @FindBy(xpath="//a[text()='Contact Us']")
  private WebElement contactUsLink;
  
  
  
  //initialization 
  public SkillraryDemoAppPage(WebDriver driver)
  {
	  PageFactory.initElements(driver,this);
  }
  
  //utilization
  /**
   * this method is used to return text on the logo
   * @return
   */
  public String getLogotext()
  {
	  return logo.getText();
  }
  /**
   * this method is used to mouse hover on course tab
   * @param web
   */
  public void mouseHoverToCourse(WebDriverUtility web)
  {
	  web.mouseover(courseTab);
  }
  /**
   * this method is used to click on selenium training
   */
  public void clickSeleniumTraining()
  {
	  seleniumTrainingLink.click();
  }
  /**
   * this method is used to select category from drop down based on index
   * @param web
   * @param index
   */
  public void selectcategory(WebDriverUtility web,int index)
  {
	  web.dropdown(categoryDD,index);
  }
  /**
   * this method is used to return contact us link
   * @return
   */
  public WebElement getContactUs()
  {
	  return contactUsLink;
  }

public void clickContactUs()

{
	contactUsLink.click();
}
}