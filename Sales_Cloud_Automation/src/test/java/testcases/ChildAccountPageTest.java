package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.AccountPage;
import locator.LoginPage;

public class ChildAccountPageTest extends TestBase {
	
	LoginPage loginpage;
	AccountPage createnewaccount;
	String wbSheet="ChildAccount";
	
	public ChildAccountPageTest()
	{
		super();
	}

	@BeforeMethod
	public void login() {
		launch();
		loginpage=new LoginPage();
		createnewaccount=new AccountPage();
		loginpage.login(p.getProperty("userN"),p.getProperty("PassW"));
		Assert.assertTrue(loginpage.verifyPage(), "Home page is not displayed");
		createnewaccount.clickonAccounts();		
	}
	
	@DataProvider
	public Object getAccountDetails() {
		Object [][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}

	@Test(dataProvider="getAccountDetails")
	public void craetechildacc(String accName, String parentAccName) throws InterruptedException {
		createnewaccount.createChildAccount(accName, parentAccName);
		//Assert.assertEquals(createnewaccount.verifyaccountname(),accName,"Account name not match");
	
		
	}
	
	
}
