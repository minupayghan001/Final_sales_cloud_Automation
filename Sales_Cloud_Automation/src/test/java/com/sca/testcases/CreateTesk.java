package com.sca.testcases;

import org.openqa.selenium.By;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.HomePage;
import com.sca.pages.LeadPage;
import com.sca.pages.LoginPage;
import com.sca.utilities.ExcelUtilities;

import junit.framework.Assert;

public class CreateTesk extends TestBase {
	LoginPage loginPage;	
	HomePage homePage;
	LeadPage leadPage;
	String wbSheet="Task";
	
	public CreateTesk() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 homePage=new HomePage();
		 leadPage=new LeadPage();
		 homePage=loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
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
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
