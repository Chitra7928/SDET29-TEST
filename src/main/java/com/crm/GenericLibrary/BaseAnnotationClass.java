package com.crm.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectrepositorylib.Homepage;
import com.crm.comcast.objectrepositorylib.Login;

public class BaseAnnotationClass{
	//create objects 
		public ExcelUtility eLib=new ExcelUtility();
		public FileUtility fLib=new FileUtility();
		public WebDriverUtility wLib=new WebDriverUtility();
		public JavaUtility jLib=new JavaUtility();
		public WebDriver driver=null;
		public static WebDriver sDriver= null;

		@BeforeSuite
		public void configBS() {
			System.out.println("==========connect to DB==============");
			}

	//@Parameters("browser")
	@BeforeClass
	//(groups= {"smoketesting","regressiontest"})
	public void configBC() throws IOException
	{
	
	//read common data
	String BROWSER=fLib.readDataFromPropertyFile("browser");
	String URL=fLib.readDataFromPropertyFile("url");
	
	//Launch the browser
	if(BROWSER.equals("firefox"))
	{
		driver = new FirefoxDriver();
	}else if(BROWSER.equals("chrome"))
	{
		driver= new ChromeDriver();
	}else if(BROWSER.equals("ie"))
	{
		driver= new InternetExplorerDriver();
	}
	
	driver.get(URL);
	sDriver=driver;
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	
}

 	@BeforeMethod
 	
 	//(groups= {"smoketesting","regressiontest"})
 
	public void configBM() throws IOException
	
	{
		//read common data
		String USERNAME=fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		
		//1. launch the application
	
		Login lp = new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);	
	}
 	
 	@AfterMethod(groups= {"smoketesting","regressiontest"})
	public void configAM() throws InterruptedException {
 		Thread.sleep(5000);
		Homepage hp= new Homepage(driver);
		hp.logout(driver);
		
	}

 	@AfterClass
	//(groups= {"smoketesting","regressiontest"})
	public void configAC() {
		driver.quit();
	}
 
	@AfterSuite
	public void configAS() {
		System.out.println("==========disconnect from DB==============");
		}
}


 	

 	
