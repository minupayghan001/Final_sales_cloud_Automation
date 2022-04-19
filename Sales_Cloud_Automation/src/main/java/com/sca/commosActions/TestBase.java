package com.sca.commosActions;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.eventusermodel.XSSFBReader;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import com.sca.pages.CampaignPage;
import com.sca.utilities.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

	static XSSFReader reader;

	public static WebDriver driver;
	public static Logger log;
	public static Properties p;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	String convrtMonth="";
	String convrtMonth1="";
	public static int monthGap=0;
	public TestBase(){
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\sca\\properties\\config.properties" );
			//"C:\\Users\\avanti.joshi\\eclipse\\jee-2021-09\\eclipse\\Sales_Cloud_Automation\\src\\test\\java\\properties\\config.properties");
			p.load(f);
			;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* String readpropfile(String key) {
			String value=null;
			try {
				Properties p=new Properties();
				FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\config.properties" );
						//"C:\\Users\\avanti.joshi\\eclipse\\jee-2021-09\\eclipse\\Sales_Cloud_Automation\\src\\test\\java\\properties\\config.properties");
				p.load(f);
				value=p.getProperty(key)
	;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return value;
		}*/

	public void launch() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

	}

	public  boolean verify(By webEle) {
		boolean check=driver.findElement(webEle).isDisplayed();
		System.out.println(check);
		return check;

	}

	public  void clickOnElement(By webEle)
	{
		driver.findElement((webEle)).click();
	}

	public  void sendKey(By webEle,String text) {
		driver.findElement(webEle).sendKeys(text);
	}

	public  void clickoncheckbox(By webEle) {

		boolean check=driver.findElement(webEle).isSelected();
		if(!check)
		{
			driver.findElement(webEle).click();

		}
	}
	public String titleTest() {
		return driver.getTitle();
	}

	public  void pressEnter() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}

	public  void scrollupto(By webEle) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",webEle);

	}

	public  void clickonElementbyjs(WebElement webEle) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webEle);
	}

	public  String getText(By webEle) {
		String gettext=driver.findElement(webEle).getText();
		return gettext;
	}

	public  boolean elementvisibletest(By webEle) {
		boolean gettext=driver.findElement(webEle).isEnabled();
		return gettext;
	}

	public  void explicitWait(By ele) {
		WebDriverWait wait=new WebDriverWait(driver,2);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	//		public static ArrayList<Object[]> readdatafromExcel() {
	//			
	//			ArrayList<Object[]> arr=new ArrayList<Object[]>();
	//			try {
	//				reader=new XSSFReader("C:\\Salescloud Repository\\Sales_Cloud_Automation\\src\\test\\java\\utilities\\CampaignData.xlsx");	
	//			}catch(Exception e) {
	//				e.printStackTrace();
	//			}
	//			
	//			for(int rowcnt=2;rowcnt<reader.getRowCount("CampaignData");rowcnt++) {
	//				String newcampaignname=reader.getCellData("CampaignData","campaignname",rowcnt);
	//				
	//				Object obj[]= {newcampaignname};
	//				arr.add(obj);
	//			}
	//			return arr;
	//		}
	//	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public int monthSelect(String month) {
		
		//String m=changemonth(month);//January
		int key=0;
		Map<Integer, String> mon=new HashMap<Integer, String>();
		mon.put(1, "JANUARY");
		mon.put(2, "FEBRUARY");
		mon.put(3, "MARCH");
		mon.put(4, "APRIL");
		mon.put(5, "MAY");
		mon.put(6, "JUNE");
		mon.put(7, "JULY");
		mon.put(8, "AUGUST");
		mon.put(9, "SEPTEMBER");
		mon.put(10, "OCTOBER");
		mon.put(11, "NOVEMBER");
		mon.put(12, "DECEMBER");
		
		for(Entry<Integer, String> entry : mon.entrySet())
		{
			if(entry.getValue()==month)
			{
				key=entry.getKey();
				break;
				//System.out.println(key);
			}
		}
		return key;
		
	}
	
	public String changemonth(String month)
	{
		String changeMonth="";
		if(month.equalsIgnoreCase("Jan") || month.equalsIgnoreCase("JANUARY"))
		{
			changeMonth="JANUARY";
		}
		else if(month.equalsIgnoreCase("Feb")|| month.equalsIgnoreCase("FEBRUARY"))
		{
			changeMonth="FEBRUARY";
		}
		else if(month.equalsIgnoreCase("Mar")|| month.equalsIgnoreCase("MARCH"))
		{
			changeMonth="MARCH";
		}
		else if(month.equalsIgnoreCase("Apr")|| month.equalsIgnoreCase("APRIL"))
		{
			changeMonth="APRIL";
		}
		else if(month.equalsIgnoreCase("May")|| month.equalsIgnoreCase("MAY"))
		{
			changeMonth="MAY";
		}
		else if(month.equalsIgnoreCase("Jun")|| month.equalsIgnoreCase("JUNE"))
		{
			changeMonth="JUNE";
		}
		else if(month.equalsIgnoreCase("Jul")|| month.equalsIgnoreCase("JULY"))
		{
			changeMonth="JULY";
		}
		else if(month.equalsIgnoreCase("Aug")|| month.equalsIgnoreCase("AUGUST"))
		{
			changeMonth="AUGUST";
		}
		else if(month.equalsIgnoreCase("Sept")|| month.equalsIgnoreCase("SEPTEMBER"))
		{
			changeMonth="SEPTEMBER";
		}
		else if(month.equalsIgnoreCase("Oct")|| month.equalsIgnoreCase("OCTOBER"))
		{
			changeMonth="OCTOBER";
		}
		else if(month.equalsIgnoreCase("Nov")|| month.equalsIgnoreCase("NOVEMBER"))
		{
			changeMonth="NOVEMBER";
		}
		else if(month.equalsIgnoreCase("Dec")|| month.equalsIgnoreCase("DECEMBER"))
		{
			changeMonth="DECEMBER";
		}
		else
		{
			System.out.println("Invalis month");
		}
		
		return changeMonth;
	}

	public int actualMonthSelect(String currentMonth, String actMonth) {
		convrtMonth=changemonth(actMonth);//JANUARY
		convrtMonth1=changemonth(currentMonth);
		//MARCH
		int tdMonthID=monthSelect(convrtMonth);
		int UIMonthID=monthSelect(convrtMonth1);
		
		monthGap=UIMonthID - tdMonthID;
		return tdMonthID - UIMonthID;
		
		//3
	}
}


