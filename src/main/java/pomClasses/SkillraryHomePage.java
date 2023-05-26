package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomePage 
{
   //Declaration
	@FindBy(xpath="//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath="//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu ')]/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillaryDemoAppLink;
	
	@FindBy(xpath="//ul[contains(@class,'home_menu ')]/li[1]")
	private WebElement language;
	@FindBy(xpath="//ul[contains(@class,'home_menu ')]/descendant::a[text()=' English ']")
	private WebElement english;
	
	//initialization
	public SkillraryHomePage(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}
	//utilization
	public WebElement getLogo()
	{
		return logo;
	}
	/**
	 * click on gears tab
	 */
	public void clickGearsTab()
	{
		gearsTab.click();
	}
	/**
	 * this method is used to click on Skillrsry demo app link
	 */
	public void clickSkillaryDemoApp()
	{
		skillaryDemoAppLink.click();
	}
	/**
	 * this methos is used select English as default langugage
	 */
	public void chooseEnglish()
	{
		language.click();
		english.click();
	}
	
}
