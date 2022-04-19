package com.sca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.CampaignPage;
import com.sca.pages.HomePage;
import com.sca.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	CampaignPage campaignPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 campaignPage= new CampaignPage();
		 homePage=new HomePage();
		 Thread.sleep(5000);
		 Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		
	}
	@Test(priority=1)
	public void verify() {
		String title=homePage.verifyHomePageTitle();
		//Assert.assertEquals(title, "Home | Salesforce", "Home Page tile not matched");
	}
	@Test(priority=2)
	public void clickOnCampaignObj() throws InterruptedException {
		campaignPage=homePage.clickOnCampaign();
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
