package com.sca.testcases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.CampaignPage;
import com.sca.pages.HomePage;
import com.sca.pages.LeadPage;
import com.sca.pages.LoginPage;

public class ContactCreateCampaign extends TestBase {
	
	LoginPage loginPage;	
	HomePage homePage;
	CampaignPage campaignPage;
	
	public ContactCreateCampaign() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 campaignPage=new CampaignPage();
		loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		homePage.clickOnCampaign();
	}

	@Test
	public void addleadInCampaign() throws InterruptedException {
		campaignPage.addLead();
	}
	
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
