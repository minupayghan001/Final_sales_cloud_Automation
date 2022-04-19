package com.sca.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sca.commosActions.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="//p[@class=\"slds-truncate\"]/b")
	WebElement cont;
	
	@FindBy(xpath="//a[@title=\"Contacts\"]/span")
	WebElement contactObj;
	
	@FindBy(xpath="//a[@title=\"New\"]")
	WebElement newBtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[1]/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/button")
	WebElement salu;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[1]/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span")
	WebElement mr;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[2]/lightning-input/div/input")
	WebElement firstName;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_contact___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[3]/lightning-input/div[1]/input")
	WebElement lastName;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/records-form-footer/div/div/div/runtime_platform_actions-actions-ribbon/ul/li[3]/runtime_platform_actions-action-renderer/runtime_platform_actions-executor-lwc-headless/slot[1]/slot/lightning-button/button")
	WebElement sveBtn;
	
	@FindBy(xpath="(//div[@class=\"testonly-outputNameWithHierarchyIcon slds-grid sfaOutputNameWithHierarchyIcon\"]/span)[1]")
	WebElement createdContact;
	
	
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContact() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", appLauncher);
		search.sendKeys("Contacts");
		Thread.sleep(3000);
		cont.click();
		Thread.sleep(3000);
	}
	
	public String verify() {
		return createdContact.getText();
	}

	public void createContact(String fName,String lName) throws InterruptedException {
		newBtn.click();
		Thread.sleep(5000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", salu);
		//salu.click();
		
		mr.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		sveBtn.click();
	}
}
