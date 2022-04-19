package com.sca.testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.ContactPage;
import com.sca.pages.LoginPage;
import com.sca.pages.PriceBookPage;
import com.sca.utilities.ExcelUtilities;

public class PriceBookTest extends TestBase{
	LoginPage loginPage;
	PriceBookPage priceBookPage;
	String wbSheet="PriceBook";
	
	public PriceBookTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 priceBookPage=new PriceBookPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		priceBookPage.clickOnMore();
	}
	
	@DataProvider
	public Object getPriceBookData() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getPriceBookData")
	public void createPriceBook(String pricebookName) throws InterruptedException {
		priceBookPage.createNewPriceBook(pricebookName);
		Assert.assertEquals(priceBookPage.verifypriceBook(), pricebookName);
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
