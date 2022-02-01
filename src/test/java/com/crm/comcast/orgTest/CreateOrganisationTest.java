package com.crm.comcast.orgTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.CreatingNewOrganisation;
import com.crm.comcast.objectrepositorylib.Homepage;
import com.crm.comcast.objectrepositorylib.OrganizationInformation;
import com.crm.comcast.objectrepositorylib.Organizations;

public class CreateOrganisationTest extends BaseAnnotationClass {
	
	@Test//(groups="smoketesting")
	public void createOrgTest() throws IOException
	{
		String orgName = eLib.getDataFromExcel("contact", 10, 2)+ jLib.getRandomNumber();
		
		 Homepage hp= new Homepage(driver);
		hp.createOrg();
		
		//3.Navigate to create new org
			
		 Organizations op = new Organizations(driver);
		op.getCreateOrgimg().click();
		
		//4.Create new organization
		
		CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
		cno.createOrg(orgName);
		
		//5.verification
		
		OrganizationInformation oi = new OrganizationInformation(driver);
		Assert.assertTrue(oi.getOrgConfmsg().getText().contains(orgName));
	}
		


	@Test // (groups="regressiontest")
	public void createOrgWithIndustryTypeTest() throws IOException, InterruptedException
	{
		String orgName = eLib.getDataFromExcel("contact", 10, 2)+ jLib.getRandomNumber();
		String industries=eLib.getDataFromExcel("Contact", 10, 3);
		Homepage hp= new Homepage(driver);
		hp.getOrganizationsLink().click();
		
		Thread.sleep(5000);
		
		//3.Navigate to create new org
		
		Organizations op = new Organizations(driver);
		op.getCreateOrgimg().click();
		
		//4.Create new organization
		
		CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
		cno.createOrg(orgName,industries);
		
		//5.verification
		
		OrganizationInformation oi = new OrganizationInformation(driver);
		Assert.assertTrue(oi.getOrgConfmsg().getText().contains(orgName));
	}
}