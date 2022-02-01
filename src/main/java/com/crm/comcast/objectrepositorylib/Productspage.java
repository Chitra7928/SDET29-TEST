package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspage {
	
	public Productspage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createNewProduct;


	public WebElement getCreateNewProduct() {
		return createNewProduct;
	}
	
	
}
