package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonsAction.TestBase;
import locator.CasePage;
import locator.LoginPage;
import locator.PriceBookPage;

public class CasePageTest extends TestBase {
	LoginPage loginPage;
	PriceBookPage priceBookPage;
	CasePage casePage;
	
	public CasePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 priceBookPage=new PriceBookPage();
		 casePage=new CasePage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		//priceBookPage.clickOnMore();
	}
	
	@Test
	public void createNewCase() throws InterruptedException {
		casePage.createCase();
	}
}
