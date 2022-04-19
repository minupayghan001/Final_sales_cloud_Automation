package com.sca.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sca.commosActions.TestBase;

public class LoginPage extends TestBase{
	TestBase t=new TestBase();
	
	@FindBy(xpath="//input[@id=\"username\"]")
	WebElement uname;
	
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//input[@id=\"Login\"]")
	WebElement loginBtn;
	
	@FindBy(xpath="(//span[@class=\"slds-truncate\"])[2]")
	WebElement Homeverify;
	
	public LoginPage() {
		PageFactory.initElements(t.driver, this);
	}
	
	
	
	public HomePage login(String un, String pass) {
		uname.sendKeys(un);
		System.out.println(un);
		password.sendKeys(pass);
		loginBtn.click();
		return new HomePage();
	}
	
	public String loginverify() {
		return Homeverify.getText();
	}
	
	public String verifyLogin() {
		return t.driver.getTitle();
	}

	//public static By uname = By.xpath("//input[@id=\"username\"]");
	//public static By pword = By.xpath("//input[@id=\"password\"]");
	//public static By Loginbtn = By.xpath("//input[@id=\"Login\"]");
	//public static By Loginverify = By.xpath("//h2[@id=\"header\"]");
	//public static By verifybutton=By.xpath("//input[@id=\"save\"]");
	
}
