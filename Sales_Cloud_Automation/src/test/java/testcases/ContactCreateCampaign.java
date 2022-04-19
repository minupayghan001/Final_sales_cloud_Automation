package testcases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonsAction.TestBase;
import locator.CampaignPage;
import locator.HomePage;
import locator.LeadPage;
import locator.LoginPage;

public class ContactCreateCampaign extends TestBase {
	
	LoginPage loginPage;	
	HomePage homePage;
	CampaignPage campaignPage;
	
	public ContactCreateCampaign() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 campaignPage=new CampaignPage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		homePage.clickOnCampaign();
	}

	@Test
	public void addleadInCampaign() throws InterruptedException {
		campaignPage.addLead();
		
	}
}
