package com.sca.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sca.commosActions.TestBase;
import com.sca.pages.LoginPage;
import com.sca.pages.ProductPage;
import com.sca.utilities.ExcelUtilities;

public class ProductPageTest extends TestBase {
	LoginPage loginPage;
	ProductPage productPage;
	String wbSheet="Product";
	public ProductPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		launch();
		 loginPage=new LoginPage();
		 productPage=new ProductPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Thread.sleep(5000);
		 //Assert.assertEquals(loginPage.loginverify(),"Home","Login fail");
		 productPage.clickOnProducts();
	}
	
	@DataProvider
	public Object getproductdata() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getproductdata", priority = 1)
	public void createNewProduct(String ProductName,String ProductCode) throws InterruptedException {
		productPage.createProduct(ProductName,ProductCode);
		Assert.assertEquals(productPage.verify(),ProductName);
	}
	
	@Test(priority = 2)
	public void PriceBookAddedProduct() throws InterruptedException {
		productPage.addPriceBook();
	}
	
	@Test(priority = 3)
	public void ProductClone() throws InterruptedException {
		productPage.cloneProduct();
	}
	
	@AfterMethod
    public void tearDown() 
	{
		driver.close();
	}
}
