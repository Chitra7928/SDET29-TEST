package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactspage {
	
public Contactspage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

 @FindBy(xpath="//span[@class='dvHeaderText']")
 private WebElement confMsg;

public WebElement getConfMsg() {
	return confMsg;
}
 
 
}
