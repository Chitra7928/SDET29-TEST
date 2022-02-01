package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateNewVendor extends WebDriverUtility{
	
	public CreateNewVendor(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	 @FindBy(name="vendorname")
	 private WebElement vendorNameEdt;
	 
	public WebElement getVendorNameEdt() {
		return vendorNameEdt;
		
	}
	
	@FindBy(xpath="//select[@name='glacct']")
	private WebElement accountdropdown;
	
	
	public WebElement getAccountdropdown() {
		return accountdropdown;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	/**
	 * @author NEW
	 * Used to create new vendor with mandate info
	 * @param accType 
	 * @param orgName
	 * 
	 */
		
	public void createVendor(String vendorName) {
		vendorNameEdt.sendKeys(vendorName);
		saveBtn.click();
		
	}
	/**
	 * @author NEW
	 * Used to create new vendor with account type mandate info
	 * @param accType 
	 * @param orgName
	 * 
	 */
		
	public void createVendorwithAcctype(String vendorName, String accType) {
		vendorNameEdt.sendKeys(vendorName);
		selectbyvisibletext(accountdropdown, accType);
		saveBtn.click();
		
	
	 
	 

}
}