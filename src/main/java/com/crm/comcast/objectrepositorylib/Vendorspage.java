package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vendorspage {

	public Vendorspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createNewVendor;

	public WebElement getCreateNewVendor() {
		return createNewVendor;
	}
	
		
	
}
