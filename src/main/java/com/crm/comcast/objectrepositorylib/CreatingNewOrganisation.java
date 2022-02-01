package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewOrganisation extends WebDriverUtility {
	
	public CreatingNewOrganisation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='detailedViewTextBox' and @name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industriesLst;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	/**
	 * @author NEW
	 * Used to create new org with mandate info
	 * @param orgName
	 * 
	 */
		
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
		
		/**
		 * @author NEW
		 * used to create new org with orgName and industries
		 * @param orgName
		 */
		
		public void createOrg(String orgName, String industries) {
			orgNameEdt.sendKeys(orgName);
			selectbyvisibletext(industriesLst,industries);
			saveBtn.click();
			
	
		
		
	}
	
	

}

