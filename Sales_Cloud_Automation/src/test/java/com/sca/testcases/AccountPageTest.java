/*
* author avanti
*
*/

package com.sca.testcases;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.sca.commosActions.TestBase;
import com.sca.pages.AccountPage;
import com.sca.pages.LoginPage;
import com.sca.reports.ExtentReportNG;
import com.sca.utilities.EmailNotification;
import com.sca.utilities.ExcelUtilities;
public class AccountPageTest extends TestBase {

	LoginPage loginpage;
	AccountPage createnewaccount;
	String wbSheet="Account";
	TestBase t=new TestBase();
	EmailNotification send=new EmailNotification();
	ExtentReportNG ex=new ExtentReportNG();
	//Logger log=Logger.
	public AccountPageTest()
	{
		super();
	}
	@BeforeMethod
	public void login() throws InterruptedException {
		t.launch();
		//log.info("launched");
		System.out.println(p.getProperty("userN"));
		loginpage=new LoginPage();
		createnewaccount=new AccountPage();
		loginpage.login(p.getProperty("userN"),p.getProperty("PassW"));
		Thread.sleep(5000);
		//Assert.assertEquals(loginpage.loginverify(),"Home","Login fail");
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
		//log.info("Assertion passed");
	}
	@AfterMethod
    public void tearDown(ITestResult result) throws EmailException 
	{	
		if(result.getStatus()==ITestResult.FAILURE) {
			send.sendEmail(result);
		System.out.println("TEST FAILED -- After Method statement : "+ result);
		
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			send.sendEmail(result);
			System.out.println("TEST PASSED -- After Method statement : "+ result);
			
			}		
				driver.close();
	}
}
