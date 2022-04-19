package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.AccountPage;
import locator.LoginPage;

public class AccountPageTest extends TestBase {
	
	LoginPage loginpage;
	AccountPage createnewaccount;
	String wbSheet="Account";
	
	public AccountPageTest()
	{
		super();
	}

	@BeforeMethod
	public void login() {
		launch();
		loginpage=new LoginPage();
		createnewaccount=new AccountPage();
		loginpage.login(p.getProperty("userN"),p.getProperty("PassW"));
		createnewaccount.clickonAccounts();		
	}
	
	@DataProvider
	public Object getAccountDetails() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getAccountDetails")
	public void craetenewacc(String accName) throws InterruptedException {
		createnewaccount.createNewAccount(accName);
		Assert.assertEquals(createnewaccount.verifyaccountname(),accName,"Account name not match");
		System.out.println("Assertion pass");
	}
	

}
