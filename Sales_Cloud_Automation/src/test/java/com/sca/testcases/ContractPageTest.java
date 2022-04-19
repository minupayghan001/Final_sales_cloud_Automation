package com.sca.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.ContractPage;
import com.sca.pages.LoginPage;
import com.sca.pages.PriceBookPage;
import com.sca.utilities.ExcelUtilities;

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
		 Thread.sleep(5000);
		// Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		//priceBookPage.clickOnMore();
	}
	
	@DataProvider
	public Object getContractData() {
		Object [][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getContractData")
	public void createNewContract(String accName,String contraMonth, String date) throws InterruptedException {
		contractPage.createContract( accName, contraMonth, date);
		//Assert.assertEquals(contractPage.verify(),accName);
		
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
