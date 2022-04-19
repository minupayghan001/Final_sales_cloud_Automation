package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonsAction.TestBase;
import locator.HomePage;
import locator.LeadPage;
import locator.LoginPage;

public class LeadConversionTest extends TestBase {
	
	LoginPage loginPage;	
	HomePage homePage;
	LeadPage leadPage;
	
	public LeadConversionTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 leadPage=new LeadPage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		homePage.clickOnLead();
	}
	
	@Test
	public void convertLead() throws InterruptedException {
		leadPage.leadConvert();
	}
}
