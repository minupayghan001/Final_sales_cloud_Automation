package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.CampaignPage;
import locator.HomePage;
import locator.LoginPage;

public class CampaignCreateTest extends TestBase {
	LoginPage loginPage;
	CampaignPage campaignPage;
	HomePage homePage;
	
	static String wbsheet="CampaignData";
	
	public CampaignCreateTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 campaignPage= new CampaignPage();
		 homePage=new HomePage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		/* String page=loginPage.verifyPage();
		Assert.assertEquals(page, "Lightning Experience", "Home page does not matched");*/
		 campaignPage= homePage.clickOnCampaign();
	}
	
	@DataProvider
	public Object[][] getcampaigndata() throws IOException {
		Object Obj1[][]=ExcelUtilities.getExcel(wbsheet);
		 return Obj1;
	}
	
//	@AfterMethod(dependsOnGroups = "getcampaigndata")
//	public void verifyCampaignPageName(String campaignName) {
//		String name=campaignPage.verifyCampaignPage();
//		System.out.println(name);
//		Assert.assertEquals(name,campaignName ,"Campaign name does not matched");
//	}
	
	@Test(priority = 1, dataProvider = "getcampaigndata")
	public void createCampaign(String campaignName) throws InterruptedException {
		campaignPage.clickOnNewBtn();
		campaignPage.createNewCampaign(campaignName);
		String name=campaignPage.verifyCampaignPage();
		System.out.println(name);
		Assert.assertEquals(name,campaignName ,"Campaign name does not matched");
	}
	}
		
		
	
	


