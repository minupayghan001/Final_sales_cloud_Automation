package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.LoginPage;
import locator.OpportunityPage;

public class OpportunityPageTest extends TestBase {
	LoginPage loginPage;
	OpportunityPage oppPage;
	String wbSheet="Opportunity";
	
	public OpportunityPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 oppPage=new OpportunityPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		oppPage.clickOnOpportunityObj();
	}
	
	@DataProvider
	public Object getOpprtunityData() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(priority = 1,dataProvider="getOpprtunityData")
	public void createNewOpportunity(String OpportunityName) throws InterruptedException {
		oppPage.createOpp(OpportunityName);
	}
	
	@Test(priority = 2)
	public void changeStageOpp() throws InterruptedException {
		oppPage.changeStageOfOpp();
	}
	
	@Test(priority = 3)
	public void addProductToOpp() throws InterruptedException {
		oppPage.addProduct();
	}
}
