package com.sca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.CasePage;
import com.sca.pages.LoginPage;
import com.sca.pages.PriceBookPage;

public class CasePageTest extends TestBase {
	LoginPage loginPage;
	PriceBookPage priceBookPage;
	CasePage casePage;
	
	public CasePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 priceBookPage=new PriceBookPage();
		 casePage=new CasePage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		//priceBookPage.clickOnMore();
	}
	
	@Test
	public void createNewCase() throws InterruptedException {
		casePage.createCase();
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
