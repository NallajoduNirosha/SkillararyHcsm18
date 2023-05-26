package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;
/**
 * This class containd=s element and respective business libraries of selenium training page
 * @author Jayanth
 *
 */
public class SeleniumTrainingPage 
{
    //Declaration//inspect selenium traing element 
	
	
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	
	////inspect plusbutton
	@FindBy(id="add")
   private WebElement plusButton;
	
	@FindBy(id="quantity")
	private WebElement quantity;
	
	@FindBy(xpath="//button[.=' Add to Cart']")
	private WebElement addTOCartButton;

	@FindBy(xpath="//span[@class='message']")
	private WebElement message;
	
	//initialization
	public SeleniumTrainingPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}

	//utilization 
	/**
	 * this method is return page header of selenium training page
	 * @return
	 */
	
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	/**
	 * this method is used to double click on plus button
	 * @param web
	 */
	public void doubleClickPlusButton(WebDriverUtility web)
	{
	
	web.doubleClickOnElement(plusButton);
   }
	
	/**
	 * this methosdis used to get the quantity of added iteam
	 * @return
	 */
	public String getQuantity()
	{
		return quantity.getAttribute("value");
	}
	/**
	 * this method is used to click on add cart button
	 */
	public void clickToAddCart()
	{
		addTOCartButton.click();
	}
	/**
	 * this method is used to get the text on the iteam added message
	 * @return
	 */
	
	public String getMessage()
	{
		return message.getText();
	}
	
	
	
}