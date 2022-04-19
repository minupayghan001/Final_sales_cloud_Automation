package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.ContractPage;
import locator.LoginPage;
import locator.PriceBookPage;

public class ContractPageTest extends TestBase {
	LoginPage loginPage;
	PriceBookPage priceBookPage;
	ContractPage contractPage;
	String wbSheet="Contract";
	
	public ContractPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 priceBookPage=new PriceBookPage();
		 contractPage=new ContractPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));

		priceBookPage.clickOnMore();

		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		//priceBookPage.clickOnMore();
	}
	
	@DataProvider
	public Object getContractData() {
		Object [][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getContractData")
	public void createNewContract(String accName,String contraMonth) throws InterruptedException {
		contractPage.createContract( accName, contraMonth);
		Assert.assertEquals(contractPage.verify(),accName);
	}
}
