package com.crm.comcast.producttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.CreatingNewProducts;
import com.crm.comcast.objectrepositorylib.Homepage;
import com.crm.comcast.objectrepositorylib.ProductInformationPage;
import com.crm.comcast.objectrepositorylib.Productspage;

public class CreateNewProductTest extends BaseAnnotationClass {
	
	@Test//(groups="smoketesting")
	public void createNewProductTest() throws IOException {
		
		String prdName = eLib.getDataFromExcel("Products", 1, 2)+ jLib.getRandomNumber();
		String categoryType= eLib.getDataFromExcel("Products", 1, 3)+jLib.getRandomNumber();
		Homepage hp = new Homepage(driver);
		hp.getProductsLink().click();
		
		Productspage pg = new Productspage(driver);
		pg.getCreateNewProduct().click();
		
		CreatingNewProducts  cp= new CreatingNewProducts(driver);
		cp.createProduct(prdName);
		
		ProductInformationPage pi = new ProductInformationPage(driver);
		Assert.assertTrue(pi.getConfMsg().getText().contains(prdName));
		
	}
	
		@Test()//(groups="regressiontest")
		public void createNewProductwithCategoryTest() throws IOException, InterruptedException {
	
			String prdName = eLib.getDataFromExcel("Products", 1, 2)+ jLib.getRandomNumber();
			String categoryType= eLib.getDataFromExcel("Products", 1, 3);
			Homepage hp = new Homepage(driver);
			hp.getProductsLink().click();
			
			Productspage pg = new Productspage(driver);
			pg.getCreateNewProduct().click();
			Thread.sleep(5000);
			
			CreatingNewProducts  cp= new CreatingNewProducts(driver);
			cp.createProductwithCategory(prdName, categoryType);
			
			ProductInformationPage pi = new ProductInformationPage(driver);
			Assert.assertTrue(pi.getConfMsg().getText().contains(prdName));
		}	
		}