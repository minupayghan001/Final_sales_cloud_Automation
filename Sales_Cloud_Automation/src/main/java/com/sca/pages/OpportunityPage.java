package com.sca.pages;

import org.apache.maven.wagon.events.WagonEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sca.commosActions.TestBase;

public class OpportunityPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="//p[@class=\"slds-truncate\"]/b")
	WebElement opp;

	@FindBy(xpath="(//a[@class=\"slds-context-bar__label-action dndItem\"])[2]/span")
	WebElement opporunityObj;
	
	@FindBy(xpath="//a[@class=\"forceActionLink\"]")
	WebElement newbt;
	
	@FindBy(xpath="(//div[@class=\"slds-form-element__control slds-grow\"])[3]/input")
	WebElement oppName;
	
	@FindBy(xpath="(//div[@class=\"slds-form-element__control slds-input-has-icon slds-input-has-icon_right\"])/input")
	WebElement closeDate;
	
	@FindBy(xpath="(//div[@class=\"slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right\"])[3]")
	WebElement stage;
	
	@FindBy(xpath="(//lightning-base-combobox-item[@id=\"combobox-button-251-1-251\"]/span)[2]")
	WebElement stage2;
	
	@FindBy(xpath="//button[@class=\"slds-button slds-button_brand\"]")
	WebElement sveBtn;
	
	
	//Change stage
	
	@FindBy(xpath="(//th[@class=\"slds-cell-edit cellContainer\"])[1]/span/a")
	WebElement createOppoObj;
	
	@FindBy(xpath="//a[contains(text(),'Details')]")
	WebElement details;
	
	@FindBy(xpath="(//button[@class=\"test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon-bare\"])[8]")
	WebElement editStage;
	
	
	@FindBy(xpath="(//button[@class=\"slds-combobox__input slds-input_faux slds-combobox__input-value\"])[2]")
	WebElement stage1;
	
	
	
	@FindBy(xpath="//lightning-base-combobox[@class='slds-combobox_container']/div[1]/div[2]/lightning-base-combobox-item[4]")
	WebElement needAna;
	
	@FindBy(xpath="(//button[@class='slds-button slds-button_brand'])")
	WebElement svrBtnStage;
	
	//Add product to opportunity
	@FindBy(xpath="(//*[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']/lightning-icon/lightning-primitive-icon)[1]")
	WebElement productDropDown;
	
	@FindBy(xpath="//a[@title='Choose Price Book']")
	WebElement priceBook1;
	
	
	@FindBy(xpath="//a[@class='select']")
	WebElement selectPrice;
	
	@FindBy(xpath="//a[@title=\"Burger\"]")
	WebElement priceBookList;
	
	@FindBy(xpath="(//span[@class=' label bBody'])[6]")
	WebElement sve;
	
	@FindBy(xpath="(//span[@class=' label bBody'])[8]")
	WebElement confirmSave;
	
	@FindBy(xpath="//a[@title='Add Products']")
	WebElement addProduct1;
	
	@FindBy(xpath="(//span[@class='slds-checkbox--faux'])[21]")
	WebElement activeCheckbox;
	
	@FindBy(xpath="(//span[contains(text(),'Next')])[1]")
	WebElement nextBtn;
	
	@FindBy(xpath="(//h2[@class=\"title slds-text-heading--medium slds-hyphenate\"])[2]")
	WebElement confirmPopup;
	
	@FindBy(xpath="(//button[@class='slds-button trigger slds-button_icon-border']//ancestor::button)[65]")
	WebElement quantity;
	
	@FindBy(xpath="//div[@class=\"uiInput uiInputNumber uiInput--default uiInput--input has-error\"]/input")
	WebElement quantity2;
	
	@FindBy(xpath="//button[@class=\"slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton\"]")
	WebElement saveBtn;
	
	public OpportunityPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOpportunityObj() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", appLauncher);
		search.sendKeys("Opportunities");
		Thread.sleep(3000);
		opp.click();
		Thread.sleep(3000);
	}
	
	public void createOpp(String OpportunityName) throws InterruptedException {
		newbt.click();
		oppName.sendKeys(OpportunityName);
		closeDate.sendKeys("15/20/2022");
		stage.click();
		Thread.sleep(3000);
		stage.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		stage.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//Thread.sleep(3000);
		sveBtn.click();
	}
	
	public void changeStageOfOpp() throws InterruptedException {
		clickOnOpportunityObj();
		Thread.sleep(3000);
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", createOppoObj);
		createOppoObj.click();
		Thread.sleep(3000);
		details.click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(2000);
		editStage.click();
		stage1.click();
		Thread.sleep(3000);
		needAna.click();
		svrBtnStage.click();
	}
	
	public void addProduct() throws InterruptedException {
		clickOnOpportunityObj();
		Thread.sleep(2000);
		createOppoObj.click();
		Thread.sleep(2000);
		JavascriptExecutor echo = (JavascriptExecutor)driver;
		echo.executeScript("arguments[0].click();", productDropDown);
		Thread.sleep(2000);
		JavascriptExecutor exec = (JavascriptExecutor)driver;
		exec.executeScript("arguments[0].click();", priceBook1);
		Thread.sleep(2000);
		selectPrice.click();
		Thread.sleep(5000);
		priceBookList.click();
		Thread.sleep(2000);
		sve.click();
		Thread.sleep(2000);
		if(confirmPopup.isDisplayed()) {
		confirmSave.click();
		}
		Thread.sleep(5000);
		JavascriptExecutor echo1 = (JavascriptExecutor)driver;
		echo1.executeScript("arguments[0].click();", productDropDown);
		addProduct1.click();
		Thread.sleep(2000);
		activeCheckbox.click();
		Actions actions= new Actions(driver);
		actions.moveToElement(activeCheckbox);
		actions.perform();
		nextBtn.click();
		Thread.sleep(8000);
		boolean che=driver.findElement(By.xpath("//h2[contains(text(),\"Edit Selected Products\")]")).isDisplayed();
		System.out.println(che);
		WebElement wall=driver.findElement(By.xpath("//th[@class=\"slds-cell-edit lockTrigger cellContainer slds-has-focus\"]/span"));
		/*JavascriptExecutor echo2 = (JavascriptExecutor)driver;
		echo2.executeScript("arguments[0].click();", quantity);*/
		Thread.sleep(5000);
		/*WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(quantity));
		//wall.sendKeys(Keys.ARROW_RIGHT);
		quantity.click();*/
		Thread.sleep(2000);
		//quantity2.sendKeys("10");
		Thread.sleep(2000);
		saveBtn.click();
		}
}
