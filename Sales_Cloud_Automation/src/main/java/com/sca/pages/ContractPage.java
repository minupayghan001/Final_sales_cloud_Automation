package com.sca.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sca.commosActions.TestBase;

public class ContractPage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'App Launcher')]")
	WebElement appLauncher;
	
	@FindBy(xpath="//input[@placeholder='Search apps and items...']")
	WebElement search;
	
	@FindBy(xpath="(//p[@class=\"slds-truncate\"])[1]")
	WebElement Contract;

	
	@FindBy(xpath="/html/body/div[4]/div[1]/section/div[1]/div[1]/one-appnav/div/one-app-nav-bar/nav/div/div[1]/one-app-nav-bar-menu-button/div/slot/one-app-nav-bar-menu-item[6]/a/span/span")
	WebElement contractObj;
	
	@FindBy(xpath="//a[@class=\"forceActionLink\"]/div")
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
	
	@FindBy(xpath="//h2[@class=\"monthYear\"]")
	WebElement monthtext;
	
	@FindBy(xpath="(//a[@class=\"datePicker-openIcon display\"])[1]")
	WebElement calender;
	
	@FindBy(xpath="//td[@class=\"uiDayInMonthCell\"]/span")
	WebElement dates;
	
	@FindBy(xpath="//a[@class=\"navLink prevMonth\"]")
	WebElement previousButton;
	
	@FindBy(xpath="//a[@class=\"navLink nextMonth\"]")
	WebElement nextButton;
	
	@FindBy(xpath="//select[@class=\"slds-select picklist__label\"]")
	WebElement SelectYear;
	
	
	public ContractPage() {
		PageFactory.initElements(driver, this);
	}

	
	public String verify() {
		 return crreatedContract.getText();
		}
	
	public void createContract(String accName,String contraMonth, String date) throws InterruptedException {
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
		Thread.sleep(2000);
		calender.click();
		Thread.sleep(2000);
		//previousButton.click();
		//Thread.sleep(2000);
		String monthText=monthtext.getText();
		System.out.println(monthText);
		String datearr[]=date.split("-");
		String day=datearr[0];
		String mnth=datearr[1];
		String year=datearr[2];
		String Expecteddate=day+"/"+mnth+"/"+year;//jan january
		//System.out.println(monthSelect(mnth));
		//String month1=changemonth(mnth);
		System.out.println(actualMonthSelect(monthText,mnth));
		System.out.println("Actual date : "+Expecteddate);
		//Select Year
		Select select=new Select(SelectYear);
		select.selectByVisibleText(year);
		Thread.sleep(2000);
		//Select month
		WebElement elementToClick=monthGap>0?previousButton:nextButton;
		monthGap=monthGap<0?monthGap*-1:monthGap;
		for(int i=1;i<=monthGap;i++)
		{
			elementToClick.click();
		}
		//Select Date
		List<WebElement> Alldate=driver.findElements(By.xpath("//td[@class=\"uiDayInMonthCell\"]/span"));
		for(WebElement ele : Alldate)
		{
			String dat=ele.getText();
			if(dat.equalsIgnoreCase(day))
			{
				ele.click();
				Thread.sleep(2000);
				break;
			}
		}
		//contractStartDate.sendKeys("1/15/2022");
		contractMonth.sendKeys(contraMonth);
		sveBtn.click();
		
	}
}