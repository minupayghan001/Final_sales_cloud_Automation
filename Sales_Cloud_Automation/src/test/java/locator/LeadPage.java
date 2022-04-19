package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonsAction.TestBase;

public class LeadPage extends TestBase {
	
	//public static By leadobj=By.xpath("//div/one-app-nav-bar-item-root[3]/a/span[contains(text(),'Leads')]");
	//public static By leadobj=By.xpath("//span[contains(text(),'Leads')]/parent::a/parent::one-app-nav-bar-item-root");
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div[1]/div/div/lst-breadcrumbs/div/div/span")
	WebElement leadName;
	
	@FindBy(xpath="//ul/li/a/div[contains(text(),'New')]")
	WebElement Newbtn;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[5]/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[1]/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[1]/button")
	WebElement Salutation;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[5]/div[2]/div/div[2]/div/div/div/records-modal-lwc-detail-panel-wrapper/records-record-layout-event-broker/slot/records-lwc-detail-panel/records-base-record-form/div/div/div/div/records-lwc-record-layout/forcegenerated-detailpanel_lead___012000000000000aaa___full___create___recordlayout2/records-record-layout-block/slot/records-record-layout-section[1]/div/div/div/slot/records-record-layout-row[2]/slot/records-record-layout-item[1]/div/span/slot/records-record-layout-input-name/lightning-input-name/fieldset/div/div/div[1]/lightning-picklist/lightning-combobox/div/lightning-base-combobox/div/div[2]/lightning-base-combobox-item[2]/span[2]/span")
	WebElement salMr;
	
	@FindBy(xpath="//input[@name=\"firstName\"]")
	WebElement Firstname;
	
	@FindBy(xpath="//input[@name=\"lastName\"]")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@name=\"Company\"]")
	WebElement Comapnyname;
	
	@FindBy(xpath="//input[@id=\"input-388\"]")
	WebElement LeadStatus;
	
	@FindBy(xpath="//button[@class=\"slds-button slds-button_brand\" and contains(text(),'Save')]")
	WebElement Savebtn;
	
	@FindBy(xpath="//slot/lightning-formatted-name")
	WebElement createdLeadname;
	
	//Create Task
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a")
	WebElement createdLead;
	
	@FindBy(xpath="//*[@id=\"23161:0\"]/div/div[1]/button[1]/span")
	WebElement addBtn;
	///html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[5]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[1]/button[2]/span
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[1]/div/div/div/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div[1]/input")
	WebElement subject;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[2]/div/div/div/div/lightning-input/lightning-datepicker/div/div/input")
	WebElement dueDate;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[6]/div/div/div/div/div/div[1]/div/div/a")
	WebElement status;
	
	@FindBy(linkText="In Progress")
	WebElement progress;
	
	@FindBy(xpath="//button[@class=\"slds-button slds-button--brand cuf-publisherShareButton MEDIUM uiButton\"]/span")
	WebElement sveBtn;
	
	
	//Lead Convert
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button")
	WebElement dropdown;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/records-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/div/div/slot/runtime_platform_actions-action-renderer[7]/runtime_platform_actions-executor-aura-legacy/slot/slot/runtime_platform_actions-ribbon-menu-item/a/span")
	WebElement convert;
	
	@FindBy(xpath="/html/body/div[4]/div[2]/div[4]/div[2]/div/div[3]/button[2]")
	WebElement convertBtn;
	
	@FindBy(xpath="//div[@class=\"slds-col slds-truncate timelineGridItemLeft\"]/a")
	WebElement createdTask;
	
	@FindBy(xpath="(//p[@class=\"fieldComponent slds-text-body--regular slds-show_inline-block slds-truncate\"]/slot/lightning-formatted-text)[2]")
	WebElement createdLeadName;
	
	public LeadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyLeadPage() {
		return leadName.getText();	
		}
	
	public void createNewLead(String fName,String lName,String cmp) throws InterruptedException {
		Newbtn.click();
		Thread.sleep(5000);
		/*clickonElementbyjs(Salutation);
		//Salutation.click();
		Thread.sleep(2000);
		salMr.click();*/
		Firstname.sendKeys(fName);
		Lastname.sendKeys(lName);
		Comapnyname.sendKeys(cmp);
		Savebtn.click();
	}
	
	
	public String verify() {
	 return createdLeadName.getText();
	}
	
	public void createTask(String sub,String dDate) throws InterruptedException {
		createdLead.click();
		System.out.println("Clicked");
		WebElement webEle=TestBase.driver.findElement(By.xpath("//div/div/button[@ class =\"slds-button slds-button--brand testid__dummy-button-submit-action slds-col slds-no-space dummyButtonSubmitAction uiButton\" ]"));
		JavascriptExecutor js=(JavascriptExecutor)TestBase.driver;
		js.executeScript("arguments[0].click();", webEle);
		Thread.sleep(5000);
		subject.sendKeys(sub);
	//	dueDate.sendKeys(p.getProperty("dueDate"));
		dueDate.sendKeys(dDate);
		Thread.sleep(5000);
		//status.click();
		WebElement sta=TestBase.driver.findElement(By.xpath( "/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[6]/div/div/div/div/div/div[1]/div/div/a"));
		JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
		js1.executeScript("arguments[0].click();", sta);
		Thread.sleep(9000);
		/*WebElement prog=TestBase.driver.findElement(By.xpath("//*[@id=\"1948:0\"]/div/ul/li[3]/a"));
		JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
		js2.executeScript("arguments[0].click();", prog);*/
		progress.click();
		Thread.sleep(9000);
		WebElement sve=driver.findElement(By.xpath("//button[@class=\"slds-button slds-button--brand cuf-publisherShareButton MEDIUM uiButton\"]/span"));
		JavascriptExecutor js2=(JavascriptExecutor)TestBase.driver;
		js2.executeScript("arguments[0].click();",sve);
		//sveBtn.click();
	}
	
	public String verifyTask() {
		 return createdTask.getText();
		}
	
	public void leadConvert() throws InterruptedException {
		createdLead.click();
		Thread.sleep(5000);
		dropdown.click();
		convert.click();
		Thread.sleep(5000);
		WebElement convertBt=TestBase.driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span"));
		JavascriptExecutor js1=(JavascriptExecutor)TestBase.driver;
		js1.executeScript("arguments[0].click();", convertBt);
		//convertBtn.click();
	}
	
	
	
	
	
	
	/*public static By Newbtn=By.xpath("//ul/li/a/div[contains(text(),'New')]");
	public static By Salutation=By.xpath("//input[@name=\"salutation\"]");
	public static By Firstname=By.xpath("//input[@name=\"firstName\"]");
	public static By Lastname=By.xpath("//input[@name=\"lastName\"]");
	public static By Comapnyname=By.xpath("//input[@name=\"Company\"]");
	public static By LeadStatus=By.xpath("//input[@id=\"input-388\"]");	
	public static By Savebtn=By.xpath("//button[@class=\"slds-button slds-button_brand\" and contains(text(),'Save')]");
	public static By createdLeadname=By.xpath("//slot/lightning-formatted-name");*/
	
	
	//Lead Convert
	//public static By leadobj=By.xpath("//span[contains(text(),'Leads')]/parent::a/parent::one-app-nav-bar-item-root");
	//public static By Leadname=By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a");
	//public static By dropbtn=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[4]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/button");
	//public static By convert=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[1]/slot/slot/flexipage-component2/slot/records-lwc-highlights-panel/records-lwc-record-layout/forcegenerated-highlightspanel_lead___012000000000000aaa___compact___view___recordlayout2/force-highlights2/div[1]/div[1]/div[3]/div/runtime_platform_actions-actions-ribbon/ul/li[4]/lightning-button-menu/div/div/slot/runtime_platform_actions-action-renderer[7]/runtime_platform_actions-executor-aura-legacy/slot/slot/runtime_platform_actions-ribbon-menu-item/a/span");
	//public static By convertbtn=By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[3]/button[2]/span");
	
	/*New task create
	public static By createdLeadObj=By.xpath("html/body/div[4]/div[1]/section/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/th/span/a");
	public static By task=By.xpath("//button[@class='slds-button slds-button--brand testid__dummy-button-submit-action slds-col slds-no-space dummyButtonSubmitAction uiButton']/span");
	public static By subject=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div[4]/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[1]/div/div/div/lightning-grouped-combobox/div/div/lightning-base-combobox/div/div[1]/input");
	public static By dueDate=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[1]/section/div/section/div/div/div/div/div/div[2]/div/div/div/div/lightning-input/lightning-datepicker/div/div/input");
	public static By savebtn=By.xpath("/html/body/div[4]/div[1]/section/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/one-record-home-flexipage2/forcegenerated-adg-rollup_component___force-generated__flexipage_-record-page___runtime_sales_lead__-lead_rec_-l___-lead___-v-i-e-w/forcegenerated-flexipage_lead_rec_l_lead__view_js/record_flexipage-record-page-decorator/div[1]/records-record-layout-event-broker/slot/slot/flexipage-record-home-with-subheader-template-desktop2/div/div[3]/div[1]/slot/slot/flexipage-component2/slot/flexipage-tabset2/div/lightning-tabset/div/slot/slot/slot/flexipage-tab2[1]/slot/flexipage-component2/slot/flexipage-aura-wrapper/div/div/div[1]/section/div/div[3]/div/div/div[2]/div[2]/button/span");
*/
}
 



//div/div[@class="slds-combobox__form-element slds-input-has-icon slds-input-has-icon_right"]/input[@class="slds-input slds-combobox__input"]