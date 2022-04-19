package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonsAction.ExcelUtilities;
import commonsAction.TestBase;
import locator.ContactPage;
import locator.LoginPage;


public class ContactPageTest extends TestBase{

	LoginPage loginPage;
	ContactPage contactPage;
	String wbSheet="Contact";
	public ContactPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		launch();
		 loginPage=new LoginPage();
		 contactPage=new ContactPage();
		 loginPage.login(p.getProperty("userN"), p.getProperty("PassW"));
		 Assert.assertTrue(loginPage.verifyPage(), "Home page is not displayed");
		 contactPage.clickOnContact();
	}
	
	@DataProvider
	public Object getContactData() {
		Object[][] obj1=ExcelUtilities.getExcel(wbSheet);
		return obj1;
	}
	
	@Test(dataProvider="getContactData")
	public void createNewContact(String fName,String lName) throws InterruptedException {
		contactPage.createContact( fName, lName);
		String fullname="Mr. "+fName+" "+lName;
	Assert.assertEquals(contactPage.verify(),fullname);
	}
}
