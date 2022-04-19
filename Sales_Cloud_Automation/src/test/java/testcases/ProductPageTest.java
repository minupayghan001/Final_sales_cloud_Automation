package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.LoginPage;
import locator.ProductPage;

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
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		 productPage.clickOnProducts();
	}
	
	@DataProvider
	public Object getproductdata() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getproductdata")
	public void createNewProduct(String ProductName,String ProductCode) throws InterruptedException {
		productPage.createProduct(ProductName,ProductCode);
		Assert.assertEquals(productPage.verify(),ProductName);
	}
	
	@Test
	public void PriceBookAddedProduct() throws InterruptedException {
		productPage.addPriceBook();
	}
	
	@Test
	public void productClone() throws InterruptedException {
		productPage.cloneProduct();
	}
}
