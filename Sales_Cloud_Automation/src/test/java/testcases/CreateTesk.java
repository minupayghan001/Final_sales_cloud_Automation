package testcases;

import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;

import locator.HomePage;
import locator.LeadPage;
import locator.LoginPage;

public class CreateTesk extends TestBase {
	LoginPage loginPage;	
	HomePage homePage;
	LeadPage leadPage;
	String wbSheet="Task";
	
	public CreateTesk() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 leadPage=new LeadPage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		homePage.clickOnLead();
	}
	
	@DataProvider
	public Object getTaskdata() {
		Object[][]obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	
	
	@Test(dataProvider="getTaskdata")
	public void createTaskForLead(String sub,String dDate) throws InterruptedException {
		leadPage.createTask(sub,dDate);
		Assert.assertEquals(leadPage.verifyTask(),sub);
	}
}
