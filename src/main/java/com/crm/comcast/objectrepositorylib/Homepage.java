package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class Homepage extends WebDriverUtility {
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationsLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(xpath="//a[.='Contacts']")
	private WebElement contactLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreLink;
	
	@FindBy(name="Vendors")
	private WebElement innervendorsLink;
	
	public WebElement getInnerVendorsLink() {
		return innervendorsLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}

	@FindBy(linkText="Vendors")	
	private WebElement outervendorLink;
	
	
	public WebElement getOuterVendorLink() {
		return outervendorLink;
	}
	public WebElement getContactLink() {
		return contactLink;
		
	}
	public WebElement getProductsLink() {
		return productsLink;
	} 
	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	public WebElement getAdminstratorImg() {
		return adminstratorImg;
	}
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	 public void logout(WebDriver driver) {
		 Actions act = new Actions(driver);
		 act.moveToElement(adminstratorImg).perform();
		 signoutLink.click();
		 
	 }
	 
	 public void createOrg() {
		 organizationsLink.click();
		 
	 }
	 
	 public void createContact() {
		 contactLink.click();
		 
	 }
	 
	 public void clickOnVendorLink(WebDriver driver) {
		 Actions act = new Actions(driver);
		 act.moveToElement(moreLink).perform();
		 getInnerVendorsLink().click();
		 getOuterVendorLink().click();
		 
		 
		 
	 }
}
	
	
