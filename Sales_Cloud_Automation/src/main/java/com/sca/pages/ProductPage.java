package com.sca.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sca.commosActions.TestBase;

public class ProductPage extends TestBase {
	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="(//p[@class=\"slds-truncate\"])[1]")
	WebElement products;
	
	@FindBy(xpath="//div[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(xpath="(//input[@class=\" input\"])[1]")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='uiInput uiInputCheckbox uiInput--default uiInput--checkbox']/input")
	WebElement activeCheck;
	
	@FindBy(xpath="(//input[@class=' input'])[2]")
	WebElement productCode;
	
	
	@FindBy(xpath="(//span[@class=' label bBody'])[5]")
	WebElement sve;
	
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")
	WebElement createdProduct;
	
	@FindBy(xpath="(//div[@title=\"Add Standard Price\"])[1]")
	WebElement standardPriceBtn;
	
	@FindBy(xpath="(//span[@class=\"deleteIcon\"])[2]")
	WebElement deleteIcon;
	
	@FindBy(xpath="(//div[@class=\"autocompleteWrapper slds-grow\"])[2]/input")
	WebElement priceBookName;
	
	@FindBy(xpath="(//div[@class=\"primaryLabel slds-truncate slds-lookup__result-text\"])[4]/mark")
	WebElement selectDrop;
	
	@FindBy(xpath="//input[@data-aura-class=\"uiInputSmartNumber\"]")
	WebElement listPrice;
	
	@FindBy(xpath="(//span[@class=\"title\"])[1]")
	WebElement related;
	
	@FindBy(xpath="(//button[@class=\"slds-button slds-button--neutral uiButton--brand uiButton forceActionButton\"])")
	WebElement sve2;
	
	
	//Add to price Book
	
	@FindBy(xpath="//div[@title=\"Add to Price Book\"]")
	WebElement addtoPriceBookBtn;
	
	@FindBy(xpath="(//select[@class=\"alignCenter select uiInput uiInputSelect uiInput--default uiInput--select\"])[1]")
	WebElement priceBook;
	
	@FindBy(xpath="(//select[@class=\"alignCenter select uiInput uiInputSelect uiInput--default uiInput--select\"])[3]")
	WebElement currency;
	
	@FindBy(xpath="//button[@class=\"slds-button slds-button--neutral uiButton--default uiButton--brand uiButton\"]")
	WebElement nextBtn;
	
	@FindBy(xpath="//input[@class=\"label uiInput uiInputCheckbox uiInput--default uiInput--checkbox\"]")
	WebElement useStandardPrice;
	
	@FindBy(xpath="(//button[@class=\"slds-button slds-button--neutral uiButton--brand uiButton forceActionButton\"])/span")
	WebElement sv;
	
	//clone the product
	@FindBy(xpath="(//lightning-icon[@class='slds-icon-utility-down slds-button__icon slds-icon_container forceIcon'])[2]")
	WebElement drop;
	
	@FindBy(xpath="(//a[@title='Clone'])")
	WebElement clone;
	
	@FindBy(xpath="(//input[@class=' input'])[2]")
	WebElement productCode1;
	
	@FindBy(xpath="(//input[@class=\" input\"])[1]")
	WebElement productName1;
	
	@FindBy(xpath="//button[@class=\"slds-button slds-button--neutral uiButton--brand uiButton forceActionButton\"]")
	WebElement sve1;
	
	
	@FindBy(xpath="(//div/span/span[@class=\"uiOutputText\"])[1]")
	WebElement newcreatedproduct;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProducts() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", appLauncher);
		search.sendKeys("Products");
		Thread.sleep(3000);
		products.click();
		Thread.sleep(3000);
	}
	
	public String verify() {
		return newcreatedproduct.getText();
		
	}
	
	public void createProduct(String ProductName,String ProductCode) throws InterruptedException {
		newBtn.click();
		productName.sendKeys(ProductName);
		activeCheck.click();
		productCode.sendKeys(ProductCode);
		Thread.sleep(2000);
		sve.click();
	}
	
	public void addPriceBook() throws InterruptedException {
		createdProduct.click();
		Thread.sleep(2000);
		related.click();
		standardPriceBtn.click();
		//deleteIcon.click();
		Thread.sleep(2000);
		listPrice.sendKeys("200");
		Thread.sleep(2000);
		sve2.click();
		Thread.sleep(2000);
		addtoPriceBookBtn.click();
		Thread.sleep(2000);
		Select priceBookSelect=new Select(priceBook);
		priceBookSelect.selectByVisibleText("Burger");
		
		Thread.sleep(2000);
		Select currencySelect=new Select(currency);
		currencySelect.selectByVisibleText("USD");
		Thread.sleep(2000);
		nextBtn.click();
		Thread.sleep(2000);
		useStandardPrice.click();
		sv.click();
	}
	
	public void cloneProduct() throws InterruptedException {
		createdProduct.click();
		Thread.sleep(2000);
		drop.click();
		Thread.sleep(2000);
		clone.click();
		Thread.sleep(2000);
		productCode1.click();
		productCode1.clear();
		productCode1.sendKeys("ADE");
		Thread.sleep(2000);
		productName1.click();
		productName1.clear();
		productName1.sendKeys("Sumo");
		Thread.sleep(2000);
		sve1.click();
	}
}