package com.sca.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sca.commosActions.TestBase;

public class CampaignPage extends TestBase {
	
	
	
	@FindBy(xpath="//a/div[@title='New']")
	WebElement newcampaign;
	
	@FindBy(xpath="//div[@class=\"uiInput uiInputText uiInput--default uiInput--input\"]/input")
	WebElement campaignname;
	
	@FindBy(xpath="//div[@class=\"uiInput uiInputCheckbox uiInput--default uiInput--checkbox\"]/input")
	WebElement activebtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/button[3]")
	WebElement savebtn;
	
	@FindBy(xpath="//div[@class=\"autocompleteWrapper slds-grow\"]/input")
	public WebElement parentcampaign;
	
	@FindBy(xpath="//input[@id=\\\"input-156\\\"]")
	WebElement searchbar;
	
	@FindBy(xpath="//table[@class=\\\"slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable\\\"]/tbody/tr/th/span/a")
	WebElement selectcampaignaftersearch;
	
	@FindBy(linkText="Add Leads")
	WebElement addlead;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[13]/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a/div[2]/div[1]")
	WebElement parent;
	
	 @FindBy(xpath="(//th[@class=\"slds-cell-edit cellContainer\"])[2]/span/a")
	 public WebElement createdCampaign;
	
	//Add contact in campaign
//	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")
//	WebElement createdCampaign;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div/section/div/div/div/div[4]/article/div[1]/div/div/ul/li[1]/a/div")
	WebElement addLeadBtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span/label/span[1]")
	WebElement plusBtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]")
	WebElement nextBtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]")
	WebElement submitBtn;
	
	public CampaignPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCampaignPage() {
	return createdCampaign.getText();	
	}
	
	
	public void clickOnNewBtn() {
		newcampaign.click();
	}
	
	public void createNewCampaign(String campaignName) {
		campaignname.sendKeys(campaignName);
		activebtn.click();
		savebtn.click();
		
	}
	
	public void createChildCampaign(String childcampaignname) {
		campaignname.sendKeys(childcampaignname);
		activebtn.click();
		parentcampaign.click();
		parent.click();
		savebtn.click();
	}
	
	public void addLead() throws InterruptedException {
		Thread.sleep(3000);
		createdCampaign.click();
		Thread.sleep(5000);
		addLeadBtn.click();
		Thread.sleep(5000);
		plusBtn.click();
		nextBtn.click();
		Thread.sleep(2000);
		submitBtn.click();
	}
	
	//public static By Campaignobj = By.xpath("//span[contains(text(),'Campaigns')]/parent::a/parent::one-app-nav-bar-item-root");
	//public static By Campaignobj = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/one-app-nav-bar-item-root[8]/a/span");
	//public static By newcampaign = By.xpath("//a/div[@title='New']");
	//public static By campaignname = By.xpath("//div[@class=\"uiInput uiInputText uiInput--default uiInput--input\"]/input");
	//public static By activebtn=By.xpath("//div[@class=\"uiInput uiInputCheckbox uiInput--default uiInput--checkbox\"]/input");
	//public static By savebtn=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div/div[2]/button[3]");
	//public static By parentcampaign=By.xpath("//div[@class=\"autocompleteWrapper slds-grow\"]/input");
	//public static By searchbar=By.xpath("//input[@id=\"input-156\"]");
	//public static By selectcampaignaftersearch=By.xpath("//table[@class=\"slds-table forceRecordLayout slds-table--header-fixed slds-table--edit slds-table--bordered resizable-cols slds-table--resizable-cols uiVirtualDataTable\"]/tbody/tr/th/span/a");
	//public static By addlead=By.linkText("Add Leads");
	/*public static By searchlead=By.xpath("//div[@class=\"autocompleteWrapper slds-grow\"]/input");
	public static By addsearchedlead=By.xpath("/html/body/div[4]/div[2]/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span/label/span[1]");
	public static By addleadnext=By.linkText("Next");
	public static By submit=By.xpath("Submit");
	public static By createdCampaignname=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[1]/div/header/div[2]/div/div[1]/div[2]/h1/div[2]/div/span[1]");
	public static By createdChildCampaignname=By.xpath("//span[@class=\"custom-truncate uiOutputText\"]");
	//public static By parent=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/article/div[3]/div/div[1]/div/div/div[13]/div[1]/div/div/div/div/div/div[1]/div/div/div[2]/ul/li[3]/a/div[2]/div[1]");
	
	public static By campaigname1=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[2]/th/span/a");
	public static By Addlead=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/div/div[3]/div[1]/div/div/section/div/div/div/div[4]/article/div[1]/div/div/ul/li[1]/a/div");
	public static By plusbtn=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[2]/span/span/label/span[1]");
	public static By Nextbtn=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");
	public static By submit1=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");*/

}