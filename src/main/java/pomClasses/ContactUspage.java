package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUspage
{
//declaration
	//seleniun course tab in side go to contact us click that validate the page
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement pageLogo;
	
	@FindBy(name="name")
	private WebElement fullNameTF;
	
	@FindBy(name="sender")
	private WebElement emailTF;
	
	@FindBy(name="subject")
	private WebElement subjectTF;
	
	@FindBy(name="message")
	private WebElement messageTextArea;
	
	
	
	@FindBy(xpath="//button[text()='Send us mail']")
	private WebElement sendUsMailButton;
	
	//initioalization
	public ContactUspage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	//utilization
	/**
	 * this method return contact us page logo
	 * @return
	 */
	public WebElement getPageLogo()
	{
		return pageLogo;
	}
	/**
	 * this method is used send contact details
	 * @param fullname
	 * @param email
	 * @param subject
	 * @param message
	 */
	public void sendDetails(String fullname,String username,String subject,String message)
	{
		fullNameTF.sendKeys(fullname);
		emailTF.sendKeys(username);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(message);
		sendUsMailButton.click();
		
	}
}

