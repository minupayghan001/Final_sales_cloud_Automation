package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;

import locator.CampaignPage;
import locator.HomePage;
import locator.LeadPage;
import locator.LoginPage;

public class LeadCreateTest extends TestBase {

	LoginPage loginPage;	
	HomePage homePage;
	LeadPage leadPage;
	String wbSheet="Lead";
	public LeadCreateTest() {
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
	
	@DataProvider
	public Object getLeadData() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(priority = 1)
	public void verifyLead() throws InterruptedException {
		Thread.sleep(5000);
		String name=leadPage.verifyLeadPage();
		System.out.println(name);
		Assert.assertEquals(name, "Leads","Lead name does not matched");
	}
	
	@Test(priority = 2,dataProvider="getLeadData")
	public void createLead(String fName,String lName,String cmp) throws InterruptedException {
		Thread.sleep(5000);;
		leadPage.createNewLead(fName,lName,cmp);
		
		Assert.assertEquals(leadPage.verify(), cmp);
	}
}