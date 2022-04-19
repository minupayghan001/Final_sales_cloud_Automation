package com.sca.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sca.commosActions.TestBase;

public class CasePage extends TestBase{

	@FindBy(xpath="(//div[@class=\"slds-dropdown slds-dropdown--length-with-icon-10 slds-dropdown--right\"]/slot/one-app-nav-bar-menu-item)[3]/a/span")
	WebElement caseObj;
	
	@FindBy(xpath="//div[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement searchBar;
	
	@FindBy(xpath="(//p[@class='slds-truncate'])")
	WebElement sear;
	
	@FindBy(xpath="//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value']")
	WebElement status;
	
	@FindBy(xpath="/lightning-base-combobox[@class='slds-combobox_container']/div[1]/div[2]/lightning-base-combobox-item[3]")
	WebElement st;
	
	@FindBy(xpath="(//a[@class='select'])[2]")
	WebElement caseOrigin;
	
	@FindBy(xpath="(//a[contains(text(),'Phone')])[1]")
	WebElement caseOr;
	
	@FindBy(xpath="(//span[@class=' label bBody'])[5]")
	WebElement sve;
	
	public CasePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createCase() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", appLauncher);
		searchBar.sendKeys("Cases");
		Thread.sleep(3000);
		sear.click();
		Thread.sleep(3000);
		newBtn.click();
		//status.click();
		Thread.sleep(3000);
		/*JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click();", st);*/
		//st.click();
		caseOrigin.click();
		Thread.sleep(3000);
		caseOr.click();
		sve.click();
	}
}
