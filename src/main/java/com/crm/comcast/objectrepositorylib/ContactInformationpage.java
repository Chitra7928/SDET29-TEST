package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class ContactInformationpage extends WebDriverUtility {
	
	public ContactInformationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookupImg;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactConfMsg;

	public WebElement getLastNameEdt() { 
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	
	public WebElement getContactConfMsg() {
		return contactConfMsg;
	}

	public void createContact(String contactlastName) {
		lastNameEdt.sendKeys(contactlastName);
		saveBtn.click();
	}
	
	/**
	 * used to create new contact with orgName information
	 * @param contactLastName
	 * @param driver
	 * @param orgName
	 */
	public void createContact(String contactLastName, WebDriver driver, String orgName)
	{
		lastNameEdt.sendKeys(contactLastName);
		orgLookupImg.click();
		switchToWindow(driver, "Accounts&action");
		Organizations op = new Organizations(driver);
		op.getSrchTextEdt().sendKeys(orgName);
		op.getSrchBtn().click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
		
	}

}
