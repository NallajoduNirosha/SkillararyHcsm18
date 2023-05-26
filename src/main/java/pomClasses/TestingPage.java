package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class contains element and respective business libraries of testing page
 * @author Jayanth
 *
 */
public class TestingPage   //go to the select cart  and go testing click scroll down python ,mycart ,facebookicon inspect
{

//Declaration
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	
	@FindBy(id="Python")
	private WebElement pythonImage;
	
	@FindBy(id="cartArea")
	private WebElement myCart;
	
	@FindBy(xpath="//ul/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	
	//initlialization
	public TestingPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utlization
	/**
	 * this method return the page header of selenium_training page
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	/**
	 * thi smethod is used t get python img
	 * @return
	 */
	

  public  WebElement getPythonImage() 
  {
	 return pythonImage; 
  }
  /**
   * this method is used to get my cart area
   * @return
   */
  public WebElement getMyCart()
  {
	  return myCart;
  
  }
  /**
   * this method is used to get facebook icon
   * @return
   */
  public WebElement getFacebookIcon()
  {
	  return facebookIcon;
  }
/**
 * this method is used to click on facebook icon
 */
   public void clickFacebook()
   {
	   facebookIcon.click();
   }
}
