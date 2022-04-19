package com.sca.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sca.commosActions.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Campaigns')]/parent::a/parent::one-app-nav-bar-item-root")
	WebElement Campaignobj;
	
	@FindBy(xpath="//span[contains(text(),'Leads')]/parent::a/parent::one-app-nav-bar-item-root")
	WebElement leadobj;
	
	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="(//div[@class=\"al-menu-dropdown-list\"])[2]/one-app-launcher-menu-item/a")
	WebElement cam;
	@FindBy(xpath="//p[@class=\"slds-truncate\"]/b")
	WebElement lead;
	
public HomePage() {
	PageFactory.initElements(driver, this);

}

public String verifyHomePageTitle() {
	return driver.getTitle();
}

public CampaignPage clickOnCampaign() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", appLauncher);
	search.sendKeys("Campaign");
	Thread.sleep(2000);
	cam.click();
	return new CampaignPage();
}

public LeadPage clickOnLead() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", appLauncher);
	search.sendKeys("Leads");
	Thread.sleep(3000);
	lead.click();
	Thread.sleep(3000);
	return new LeadPage();
}

}
