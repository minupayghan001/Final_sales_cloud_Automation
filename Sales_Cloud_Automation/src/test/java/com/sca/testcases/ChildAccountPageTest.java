package com.sca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.AccountPage;
import com.sca.pages.LoginPage;
import com.sca.utilities.ExcelUtilities;

public class ChildAccountPageTest extends TestBase {
	
	LoginPage loginpage;
	AccountPage createnewaccount;
	String wbSheet="ChildAccount";
	
	public ChildAccountPageTest()
	{
		super();
	}

	@BeforeMethod
	public void login() throws InterruptedException {
		launch();
		loginpage=new LoginPage();
		createnewaccount=new AccountPage();
		loginpage.login(p.getProperty("userN"),p.getProperty("PassW"));
		 Thread.sleep(5000);
		 //Assert.assertEquals(loginpage.loginverify(),"Home","Login fail");
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
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
	
}
