package com.crm.comcast.contacttest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseAnnotationClass;
import com.crm.comcast.objectrepositorylib.ContactInformationpage;
import com.crm.comcast.objectrepositorylib.Contactpage;
import com.crm.comcast.objectrepositorylib.Contactspage;
import com.crm.comcast.objectrepositorylib.CreatingNewOrganisation;
import com.crm.comcast.objectrepositorylib.Homepage;
import com.crm.comcast.objectrepositorylib.OrganizationInformation;
import com.crm.comcast.objectrepositorylib.Organizations;

//@Listeners(com.crm.GenericLibrary.ListImp.class)
public class ContactTest extends BaseAnnotationClass{

	
		
		@Test//(groups="smoketesting")
		public void createContactTest() throws IOException{
			
		String lastName= eLib.getDataFromExcel("Contact", 4, 2);				
		//2.Navigate to contact
		Homepage hp= new Homepage(driver);
		hp.createContact();

			
		//3.Navigate to create new contact
		Contactpage cp =new Contactpage(driver);
		cp.getCreatenewContact().click();
		
		//4. Enter mandate details click save to create new contact
		ContactInformationpage cip= new ContactInformationpage(driver);
		cip.createContact(lastName);
		
		//5.verifiaction
		
		Contactspage cpi= new Contactspage(driver);
		wLib.waitUntilElementisClickable(driver, cpi.getConfMsg());
		String actCongMsg =cpi.getConfMsg().getText();
		System.out.println(actCongMsg);
		Assert.assertTrue(actCongMsg.contains(lastName));
				
	}
		
	@Test//(groups="regressiontest")
	public void createContactwithOrgTest() throws IOException, InterruptedException {
		
		String orgName = eLib.getDataFromExcel("contact", 10, 2)+ jLib.getRandomNumber();
		String lastName=eLib.getDataFromExcel("contact", 4, 2)+jLib.getRandomNumber();
		
		Homepage hp= new Homepage(driver);
		hp.getOrganizationsLink().click();
		
				
		//3.Navigate to create new org
		Organizations op = new Organizations(driver);
		op.getCreateOrgimg().click();
		 
		//4.create new organisation
		CreatingNewOrganisation cno = new CreatingNewOrganisation(driver);
		cno.createOrg(orgName);
		
		
		OrganizationInformation oi = new OrganizationInformation(driver);
		wLib.waitUntilElementisClickable(driver,oi.getOrgConfmsg());
		String actualmsg = oi.getOrgConfmsg().getText();
		System.out.println(actualmsg);
		Assert.assertTrue(actualmsg.contains(orgName));
				
		//5. Navigate to contact page
			
		hp.getContactLink().click();
		
		//6. navigate to create new contact page
		Contactpage cp = new Contactpage(driver);
		cp.getCreatenewContact().click();
		
		
		//7. create new contact with orgName
		ContactInformationpage cip= new ContactInformationpage(driver);
		cip.createContact(lastName, driver, orgName);
		
						
		//8.Verify 
		
		String Confmsg=cip.getContactConfMsg().getText();
		System.out.println(Confmsg);
		
		Assert.assertTrue(Confmsg.contains(lastName));
	}
}