package locator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonsAction.TestBase;

public class ContractPage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="(//p[@class=\"slds-truncate\"])[1]")
	WebElement Contract;

	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/div[1]/one-app-nav-bar-menu-button/div/slot/one-app-nav-bar-menu-item[6]/a/span/span")
	WebElement contractObj;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[2]/ul/li/a/div")
	WebElement newBtn;
	
	@FindBy(xpath="(//input[@class=' input'])[1]")
	WebElement contractStartDate;
	
	@FindBy(xpath="//div[@class=\"autocompleteWrapper slds-grow\"]/input[@placeholder='Search Accounts...']")
	WebElement accountName;
	
	@FindBy(xpath="//input[@class='input uiInputSmartNumber']")
	WebElement contractMonth;
	
	@FindBy(xpath="(//span[@class=' label bBody'])[5]")
	WebElement sveBtn;
	
	@FindBy(xpath="(//div[@class=\"outputLookupContainer forceOutputLookupWithPreview\"]/a)[22]")
	WebElement crreatedContract;
	
	public ContractPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String verify() {
		 return crreatedContract.getText();
		}
	
	public void createContract(String accName,String contraMonth) throws InterruptedException {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", contractObj);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", appLauncher);
		search.sendKeys("Contract");
		Thread.sleep(3000);
		Contract.click();
		Thread.sleep(3000);
		
		newBtn.click();
		Thread.sleep(4000);
		accountName.sendKeys(accName);
		Thread.sleep(2000);
		accountName.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		accountName.sendKeys(Keys.ENTER);
		contractStartDate.sendKeys("1/15/2022");
		contractMonth.sendKeys(contraMonth);
		sveBtn.click();
		
	}
}
