package com.crm.comcast.producttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.CreateNewVendor;
import com.crm.comcast.objectrepositorylib.Homepage;
import com.crm.comcast.objectrepositorylib.VendorInformationPage;
import com.crm.comcast.objectrepositorylib.Vendorspage;

public class CreatenewVendorTest extends BaseAnnotationClass  {
	
	@Test//(groups="")
	
	public void createNewVendorTest() throws IOException, InterruptedException {
		// fetch data from excel
		String vendorName =eLib.getDataFromExcel("Products", 4, 3) + jLib.getRandomNumber();		
		
		//step 1.navigate to Vendor
		Homepage hp = new Homepage(driver);
		hp.clickOnVendorLink(driver);
		
		Thread.sleep(5000);
		//step 2 navigate to create new vendor
		Vendorspage vp= new Vendorspage(driver);
		vp.getCreateNewVendor().click();
		
		//step 3: create vendor with mandate fields
		CreateNewVendor cnv = new CreateNewVendor(driver);
		cnv.createVendor(vendorName);
		
		VendorInformationPage vip = new VendorInformationPage(driver);
		Assert.assertTrue(vip.getVendorConfmsg().getText().contains(vendorName));
	}
			
		@Test//(groups="regressiontest")

		public void createNewVendorWithAccountTypeTest() throws IOException, InterruptedException {
		// fetch data from excel
		String vendorName =eLib.getDataFromExcel("Products", 4, 3) + jLib.getRandomNumber();
		String accType=eLib.getDataFromExcel("Products", 1, 4);
		
		//step 1.navigate to Vendor
		Homepage hp = new Homepage(driver);
		hp.clickOnVendorLink(driver);
		
		Thread.sleep(5000);
		//step 2 navigate to create new vendor
		Vendorspage vp= new Vendorspage(driver);
		vp.getCreateNewVendor().click();
		
		//step 3: create vendor with mandate fields
		CreateNewVendor cnv = new CreateNewVendor(driver);
		cnv.createVendorwithAcctype(vendorName, accType);
		
		VendorInformationPage vip = new VendorInformationPage(driver);
		Assert.assertTrue(vip.getVendorConfmsg().getText().contains(vendorName));
		}
}



