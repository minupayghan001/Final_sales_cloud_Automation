package locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonsAction.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath="//input[@id=\"username\"]")
	WebElement uname;
	
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@id=\"Login\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="//span[@title=\"Sales\"]")
	WebElement salesverify;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public HomePage login(String un, String pass) {
		uname.sendKeys(un);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
	}
	
	public boolean verifyPage() {
		return salesverify.isDisplayed();
	}
	
	public String verifyLogin() {
		return driver.getTitle();
	}
	
	//public static By uname = By.xpath("//input[@id=\"username\"]");
	//public static By pword = By.xpath("//input[@id=\"password\"]");
	//public static By Loginbtn = By.xpath("//input[@id=\"Login\"]");
	//public static By Loginverify = By.xpath("//h2[@id=\"header\"]");
	//public static By verifybutton=By.xpath("//input[@id=\"save\"]");
	
}
