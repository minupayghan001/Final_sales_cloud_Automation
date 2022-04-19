package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.ContactPage;
import locator.LoginPage;
import locator.PriceBookPage;

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
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
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
	}
}
