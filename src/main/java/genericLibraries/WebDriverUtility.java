package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class contains all reusable methodsto perform operation on webDriver
 * @author Jayanth
 *
 */
public class WebDriverUtility 
{
	  private WebDriver driver;
	  /**
	   * This method is used launching specified browser
	   * @param browser
	   * @return
	   */

   public WebDriver launchBrowser(String browser)
   {
	   switch(browser) 
	   {
	   case "chrome":
		     WebDriverManager.chromedriver().setup();//**WebDrivermanager xml store in temparary in resource after execution completed it will not there
		     driver=new ChromeDriver();
		     break;
		     
	   case "firefox":
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   break;
	   case "edge":
		   WebDriverManager.edgedriver().setup();
		   driver=new EdgeDriver();
		   break;
		  default :
			  System.out.println("invalid browser info");
   }
	   return driver;
   }
   /**
    * This method is used to maximize the window
    * 
    */
   
   public void maximizeBrowser()
   {
	  driver.manage().window().maximize(); 
   }
   /**
    * this method is used navigate to specified application
    * @param url
    */
   public void navigateToApp(String url)
   {
	    driver.get(url);
   }
   /**
    * this method is used to wait until element or list of element is found
    * @param time
    */
   
	  public  void waitUntilElementFound(long time)
	  {
		  driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	  }
	  /**
	   * this method is used to wait element is visible
	   * @param time
	   * @param element
	   * @return
	   */
	  public WebElement explicityWait(long time,WebElement element)
	  {
		  WebDriverWait wait = new WebDriverWait(driver,time);
		return  wait.until(ExpectedConditions.visibilityOf(element));
		  
	  }
	  /**
	   * this methos is used to wait until element is enabled
	   * @param element
	   * @param time
	   * @return
	   */
	  public WebElement explicityWait(WebElement element,long time)
	  {
		  WebDriverWait wait = new WebDriverWait(driver,time);
		return  wait.until(ExpectedConditions.elementToBeClickable(element));
		  
	  }
	  /**
	   * this method is used to wait until title of web page is found
	   * @param time
	   * @param title
	   * @return
	   */
	  public Boolean explicityWait(long time,String title)
	  {
		  WebDriverWait wait = new WebDriverWait(driver,time);
		 return wait.until(ExpectedConditions.titleContains(title));
		  
	  }
	  /**
	   * this method is used to mouseover on element
	   * @param element
	   */
	  
	  public void mouseover(WebElement element)
	  {
		  Actions actions = new Actions (driver);
		  actions.moveToElement(element).perform();
		  
	  }
	  /**
	   * this method is used to doubleclick on element
	   * @param element
	   */
	  public void doubleClickOnElement(WebElement element)
	  {
		  Actions actions = new Actions(driver);
		  actions.doubleClick(element).perform();
	  }
	  /**
	   * This method is used to rightclick on element
	   * @param element
	   */
	  public void rightClick(WebElement element)
	  {
		  Actions actions = new Actions(driver);
		  actions.contextClick(element).perform();
	  }
	  /**
	   * this method is used to dragandDrop  an element to dest
	   * @param element
	   * @param dest
	   */
	  public void dragAndDropElement(WebElement element, WebElement dest)
	  {
		  Actions actions = new Actions(driver);
		  actions.dragAndDrop(element,dest).perform();
	  }
	  
	  
	  //frames
	  /**
	   * this method is used to switch to frame based on index
	   * @param index
	   */
	  public void switchToFrame(int index)
	  {
		  driver.switchTo().frame(index);
	  }
	  /**
	   * this method is used to switch to frame based on idOrName  attribute
	   * @param idOrName
	   */
	  public void switchToFrame(String idOrName)
	  {
		  driver.switchTo().frame(idOrName);
	  }
	  /**
	   * this method is used to switch to frame based on frame element
	   * @param frameElement
	   */
	  public void switchToFrame(WebElement frameElement)
	  {
		  driver.switchTo().frame(frameElement);
	  }
	  /**
	   * this method is used to switch back from the frame
	   */
	  public void switchBackFromFrame()
	  {
		  driver.switchTo().defaultContent();
	  }
	  
	  //screenshot
	  /**
	   * this method is used to takeScreenshot of webpage
	   */
	  public void takeScreenshot()
	  {
		  TakesScreenshot ts =(TakesScreenshot)driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File dest = new File("./Screenshots/screenshot.png");
		  try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	  }
	  //scrollpage
	 /**
	  * this method is used to scroll till the end
	  * @param element
	  */
	   public void scrollToElement(WebElement element)
	   {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		   js.executeScript("arguments[0].scrollIntoView(true)", element);
	   }
	  //**DropDown
	   /**
	    * this method is used to select on element from the dropdown using index
	    * @param element
	    * @param index
	    */
	   public void dropdown(WebElement element, int index) 
	   {
		   Select s=new Select(element);
		   s.selectByIndex(index);
	   }
	   /**
	    * this method is used to select on element from the dropdown using value
	    * @param element
	    * @param index
	    */
	   public void dropdown(WebElement element, String value)
	   {
		   Select s = new Select(element);
		   s.selectByValue(value);
	   }
	   /**
	    * this method select an element from dropdown using text
	    * @param text
	    * @param element
	    */
	   public void dropdown( String text,WebElement element)
	   {
		  Select s = new Select(element);
		  s.selectByVisibleText(text);
	   }
	   //popup
	   /**
	    */
	   public void handleAlert(String status)
	   {
		   Alert a1 = driver.switchTo().alert();
		   if(status.equalsIgnoreCase("ok"))
			   a1.accept();
		   else
			   a1.dismiss();
	   }
	   /**
	    * this method is used to switch to parent window
	    */
	   public void switchToParentWindow()
	   {
		   String parentID=driver.getWindowHandle();
		   driver.switchTo().window(parentID);
	   }
	   /**
	    * this method is used to switch to child browser
	    */
	   public void handleChildBrowser()
	   {
		   Set<String>set =driver.getWindowHandles();
		   for(String id:set)
		   {
			   driver.switchTo().window(id);
		   }
	   }
	   /**
	    * this method is used to close the current tab or window
	    */
	   public void closeCurrentTab()
	   {
		   driver.close();
	   }
	   /**
	    * this method is used to close all tabs or windows
	    */
	   public void quitAllWindows()
	   {
		   driver.quit();
	   }
  }






