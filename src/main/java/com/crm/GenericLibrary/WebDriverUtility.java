package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author NEW
 *
 */
public class WebDriverUtility {
	
	/**
	 * will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * Will wait for 20 secs until the page is loaded
	 * @param driver
	 * @param Element
	 */
	
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
	}
	
	/**
	 * This method will explicitly wait until the element is click able
	 * @param driver
	 * @param Element
	 */

	public void waitUntilElementisClickable(WebDriver driver,WebElement Element)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * this method will wait for the element and perform the action
	 * @param Element
	 * @throws InterruptedException
	 */

	public void waitAndClick(WebElement Element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
		try{ 
			
		Element.click();
		break;
		}
		catch(Exception e) {
			Thread.sleep(1000);
			count++;
			}
	}
}
	
	/**
	 * this method will select from dropdown using value
	 * @param Element
	 * @param value
	 */
	public void selectbyvalue(WebElement Element,String value) {
		Select s = new Select(Element);
		s.selectByValue(value);
	}
	
	/**
	 * this method will select from drop down using visible text
	 * @param Element
	 * @param text
	 */
	public void selectbyvisibletext(WebElement Element,String text) {
		Select s = new Select(Element);
		s.selectByVisibleText(text);
	
}
	
	/**
	 * Double click
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	/**
	 * mouse hover
	 * @param driver
	 * @param Element
	 */
	
	public void mouseHover(WebDriver driver,WebElement Element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(Element).perform();
		
	}
	/**
	 * rightclick
	 * @param driver
	 * @param Element
	 */
	public void rightClick(WebDriver driver, WebElement Element)
	{
		Actions act= new Actions(driver);
		act.contextClick(Element).perform();
	}
	
	/**
	 * Drag and drop
	 * @param driver
	 * @param src
	 * @param dst
	 */
		public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)

		{
			Actions act= new Actions(driver);
			act.dragAndDrop(src,dst).perform();
		}
		
		/**
		 * Accept alert popup
		 * @param driver
		 */
		
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * Cancel the alert popup
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * Takes screen shot and save it in destination
		 * @param driver
		 * @param screenshotName
		 * @throws IOException
		 */
		
		public void takeScreenshot(WebDriver driver,String screenshotName) throws IOException
		{
			TakesScreenshot ts= (TakesScreenshot) driver;
			File src=ts.getScreenshotAs((OutputType.FILE));
		File dst=new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src,dst);
		}
		
		/**
		 * switch to window depending on partial title
		 * @param driver
		 * @param partialWinTitle
		 */
		
		public void switchToWindow(WebDriver driver, String partialWinTitle)
		{
			Set<String> set = driver.getWindowHandles();
			Iterator<String> itr = set.iterator();
			while(itr.hasNext())
			{
				String winId=itr.next();
				driver.switchTo().window(winId);
				String currentWinTitle = driver.getTitle();
				if(currentWinTitle.contains(partialWinTitle))
				{
					break;
				}
			}
		}
		
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}

		/**
		 * switch wrt element
		 * @param driver
		 * @param Element
		 */
		public void switchToFrame(WebDriver driver,WebElement Element)
		{
			driver.switchTo().frame(Element);
		}
		
		/**wrt to id or name
		 * 
		 * @param driver
		 * @param idOrName
		 */
		public void switchToFrame(WebDriver driver,String idOrName)
		{
			driver.switchTo().frame(idOrName);
		}
		
		/**
		 * switch to default frame
		 * @param driver
		 */
		public void switchToDefaultFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		/**
		 * switch to immd parent
		 * @param driver
		 */
		public void switchToFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		public void scrollToElement(WebDriver driver)
		{
			JavascriptExecutor js= (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)", "");
		}
		
		/**
		 * scroll until the element
		 * @param driver
		 * @param Element
		 */
		public void scrollToElement(WebDriver driver,WebElement Element)
		{
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("argument[0].scrollIntoView()",Element);
		}
		
		/**
		 * press the enterkey
		 * @throws AWTException
		 */
			public void enterKey() throws AWTException
			{
				Robot rb=new Robot();
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
		}
		}