package com.sca.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.CampaignPage;
import com.sca.pages.HomePage;
import com.sca.pages.LoginPage;
import com.sca.utilities.ExcelUtilities;

public class CampaignCreateTest extends TestBase {
	LoginPage loginPage;
	CampaignPage campaignPage;
	HomePage homePage;
	
	static String wbsheet="CampaignData";
	
	public CampaignCreateTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 campaignPage= new CampaignPage();
		 homePage=new HomePage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		 campaignPage= homePage.clickOnCampaign();
	}
	
	@DataProvider
	public Object[][] getcampaigndata() throws IOException {
		Object Obj1[][]=ExcelUtilities.getExcel(wbsheet);
		 return Obj1;
	}
	

	
	@Test(priority = 1, dataProvider = "getcampaigndata")
	public void createCampaign(String campaignName) throws InterruptedException {
		campaignPage.clickOnNewBtn();
		campaignPage.createNewCampaign(campaignName);
		String name=campaignPage.verifyCampaignPage();
		System.out.println(name);
		Assert.assertEquals(name,campaignName ,"Campaign name does not matched");
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
	}
		
		
	
	


