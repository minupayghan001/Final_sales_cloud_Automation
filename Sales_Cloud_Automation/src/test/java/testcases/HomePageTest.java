package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonsAction.TestBase;
import locator.CampaignPage;
import locator.HomePage;
import locator.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	CampaignPage campaignPage;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 campaignPage= new CampaignPage();
		 homePage=new HomePage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		
	}
	@Test(priority=1)
	public void verify() {
		String title=homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Home | Salesforce", "Home Page tile not matched");
	}
	@Test(priority=2)
	public void clickOnCampaignObj() {
		campaignPage=homePage.clickOnCampaign();
	}
}
