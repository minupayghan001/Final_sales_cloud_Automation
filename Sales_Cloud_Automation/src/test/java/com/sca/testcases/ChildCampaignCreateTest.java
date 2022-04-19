package com.sca.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.CampaignPage;
import com.sca.pages.HomePage;
import com.sca.pages.LoginPage;
import com.sca.utilities.ExcelUtilities;

import junit.framework.Assert;

public class ChildCampaignCreateTest extends TestBase{

	LoginPage loginPage;
	CampaignPage campaignPage;
	HomePage homePage;
	String wbSheet="ChildCampaign";
	
	public ChildCampaignCreateTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 campaignPage= new CampaignPage();
		 homePage=new HomePage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
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
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
