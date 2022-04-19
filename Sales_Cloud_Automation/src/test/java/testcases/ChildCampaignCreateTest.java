package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.CampaignPage;
import locator.HomePage;
import locator.LoginPage;

public class ChildCampaignCreateTest extends TestBase{

	LoginPage loginPage;
	CampaignPage campaignPage;
	HomePage homePage;
	String wbSheet="ChildCampaign";
	
	public ChildCampaignCreateTest() {
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
		 campaignPage= homePage.clickOnCampaign();
	}
	
	@DataProvider
	public Object getchildCampaignName() throws IOException  {
	Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	
	
	@Test(dataProvider="getchildCampaignName")
	public void createChildCampaign(String childCampName) throws InterruptedException {
		campaignPage.clickOnNewBtn();
		campaignPage.createChildCampaign(childCampName);
		String child=campaignPage.createdCampaign.getText();
		Assert.assertEquals(child, childCampName);
	}
	
	
}
