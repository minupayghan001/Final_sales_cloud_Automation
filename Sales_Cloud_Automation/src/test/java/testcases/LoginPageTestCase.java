package testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commonsAction.TestBase;
import locator.HomePage;
import locator.LoginPage;

public class LoginPageTestCase extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTestCase() {
		super();
	}
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
	}
	
	@Test(priority=1)
	public void verifyLoginPage() {
	String page=loginPage.verifyLogin();
	Assert.assertEquals(page, "Login | Salesforce", "Login page does not matched");
	}

	@Test(priority=2)
	public void loginT() {
		homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
	
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
	
}



