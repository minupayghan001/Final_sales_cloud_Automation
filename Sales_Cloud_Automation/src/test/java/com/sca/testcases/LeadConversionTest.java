package com.sca.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.HomePage;
import com.sca.pages.LeadPage;
import com.sca.pages.LoginPage;

public class LeadConversionTest extends TestBase {
	
	LoginPage loginPage;	
	HomePage homePage;
	LeadPage leadPage;
	
	public LeadConversionTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 leadPage=new LeadPage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		homePage.clickOnLead();
	}
	
	@Test
	public void convertLead() throws InterruptedException {
		leadPage.leadConvert();
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
