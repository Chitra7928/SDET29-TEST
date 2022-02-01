package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInformationPage {

	public VendorInformationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//span[@class='lvtHeaderText']")
	private WebElement vendorConfmsg;

	public WebElement getVendorConfmsg() {
		return vendorConfmsg;
	}
	
	
}


