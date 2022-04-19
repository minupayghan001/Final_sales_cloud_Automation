package com.sca.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.CampaignPage;
import com.sca.pages.HomePage;
import com.sca.pages.LeadPage;
import com.sca.pages.LoginPage;
import com.sca.utilities.ExcelUtilities;

public class LeadCreateTest extends TestBase {

	LoginPage loginPage;	
	HomePage homePage;
	LeadPage leadPage;
	String wbSheet="Lead";
	public LeadCreateTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 leadPage=new LeadPage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		homePage.clickOnLead();
	}
	
	@DataProvider
	public Object getLeadData() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(priority = 2)
	public void verifyLead() throws InterruptedException {
		Thread.sleep(5000);
		String name=leadPage.verifyLeadPage();
		System.out.println(name);
		Assert.assertEquals(name, "Leads","Lead name does not matched");
	}
	
	@Test(priority = 1,dataProvider="getLeadData")
	public void createLead(String fName,String lName,String cmp) throws InterruptedException {
		Thread.sleep(5000);;
		leadPage.createNewLead(fName,lName,cmp);
		
		Assert.assertEquals(leadPage.verify(), cmp);
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}