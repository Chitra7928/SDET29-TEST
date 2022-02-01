package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreatingNewProducts extends WebDriverUtility {

	public CreatingNewProducts(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="productname")
	private WebElement productNameEdt;

	public WebElement getProductName() {
		return productNameEdt;
	}
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='productcategory']")
	private WebElement selectcategory;
	
	
	
	
	public WebElement getSelectcategory() {
		return selectcategory;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createProduct(String prdName) {
		productNameEdt.sendKeys(prdName);
		saveBtn.click();
	}
	

	public void createProductwithCategory(String prdName, String categoryType) {
		productNameEdt.sendKeys(prdName);
		selectbyvisibletext(selectcategory, categoryType);
		saveBtn.click();
	

	}
		 
	 }
	

	
	
