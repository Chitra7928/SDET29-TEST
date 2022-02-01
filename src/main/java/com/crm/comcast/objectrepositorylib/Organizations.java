package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgimg;

	@FindBy(name="search_text")
	private WebElement srchTextEdt;
	
	@FindBy(name="search")
	private WebElement srchBtn;
	
	public WebElement getSrchTextEdt() {
		return srchTextEdt;
	}

	public WebElement getSrchBtn() {
		return srchBtn;
	}


	public WebElement getCreateOrgimg() {
		return createOrgimg;
	}
	
	public void searchtext(String orgName) {
	srchTextEdt.sendKeys(orgName);
	srchBtn.click();
	}
}
	
	
	
	