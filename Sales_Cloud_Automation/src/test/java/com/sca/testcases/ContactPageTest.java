package com.sca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.ContactPage;
import com.sca.pages.LoginPage;
import com.sca.utilities.ExcelUtilities;


public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	ContactPage contactPage;
	String wbSheet="Contact";
	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 contactPage=new ContactPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		 contactPage.clickOnContact();
	}
	
	@DataProvider
	public Object getContactData() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getContactData")
	public void createNewContact(String fName,String lName) throws InterruptedException {
		contactPage.createContact( fName, lName);
		String fullname="Mr. "+fName+" "+lName;
	Assert.assertEquals(contactPage.verify(),fullname);
	}
	
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
