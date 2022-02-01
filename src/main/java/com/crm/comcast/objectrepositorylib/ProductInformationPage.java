package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	
	public ProductInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement confMsg;

	public WebElement getConfMsg() {
		return confMsg;
	}
	

}
