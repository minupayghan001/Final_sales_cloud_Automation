package com.sca.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sca.commosActions.TestBase;

public class PriceBookPage extends TestBase {

	@FindBy(xpath="(//a[@class=\"slds-button slds-button_reset slds-context-bar__label-action\"]/span)[1]")
	WebElement moreBtn;
	
	@FindBy(xpath="(//a/span[@class=\"slds-truncate\"]/span)[1]")
	WebElement priceBook;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div")
	WebElement newBtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div/div/div/div[1]/div[1]/div/div/div/input")			
	WebElement priceBookName;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div/div/div/div[1]/div[2]/div/div/div/input")
	WebElement active;
	
	@FindBy(xpath="(//span[@class=\"uiImage uiOutputCheckbox\"])[9]")
	WebElement isStandard;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/button[3]/span")
	WebElement sveBtn;
	
	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement Launcher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement LauncherSearch;
	
	@FindBy(xpath="(//p[@class='slds-truncate'])")
	WebElement LauncherChoose;
	
	@FindBy(xpath="(//span[@class=\"uiOutputText\"])[1]")
	WebElement pb;
	
	public PriceBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMore()throws InterruptedException {
		moreBtn.click();
		Thread.sleep(10000);
	}
	
	public void createNewPriceBook(String pricebookName) throws InterruptedException {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", priceBook);
//		//priceBook.click();
//		Thread.sleep(5000);
		JavascriptExecutor execution = (JavascriptExecutor)driver;
		execution.executeScript("arguments[0].click();", Launcher);
		Thread.sleep(4000);
		LauncherSearch.sendKeys("Price Book");
		Thread.sleep(4000);
		LauncherChoose.click();
		Thread.sleep(4000);
		newBtn.click();
		Thread.sleep(5000);
		/*JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		jsExecutor.executeScript("arguments[0].value='Asian Paints'", priceBookName);*/
		priceBookName.sendKeys(pricebookName);
		active.click();
		Thread.sleep(2000);
		//isStandard.click();
		sveBtn.click();
	}
	
	public String verifypriceBook() {
		return pb.getText();
	}
}
