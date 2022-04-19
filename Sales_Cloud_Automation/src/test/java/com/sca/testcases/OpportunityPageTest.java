package com.sca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.LoginPage;
import com.sca.pages.OpportunityPage;
import com.sca.utilities.ExcelUtilities;

public class OpportunityPageTest extends TestBase {
	LoginPage loginPage;
	OpportunityPage oppPage;
	String wbSheet="Opportunity";
	
	public OpportunityPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 oppPage=new OpportunityPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
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
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
