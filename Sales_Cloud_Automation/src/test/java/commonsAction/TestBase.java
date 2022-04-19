package commonsAction;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

import io.github.bonigarcia.wdm.WebDriverManager;
import listners.WebEventListener;
import locator.CampaignPage;


public class TestBase {

	static XSSFReader reader;

	public static WebDriver driver;
	public static Properties p;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase(){
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\properties\\config.properties" );
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

	public static void launch() {
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

	public static boolean verify(By webEle) {
		boolean check=driver.findElement(webEle).isDisplayed();
		System.out.println(check);
		return check;

	}

	public static void clickOnElement(By webEle)
	{
		driver.findElement((webEle)).click();
	}

	public static void sendKey(By webEle,String text) {
		driver.findElement(webEle).sendKeys(text);
	}

	public static void clickoncheckbox(By webEle) {

		boolean check=driver.findElement(webEle).isSelected();
		if(!check)
		{
			driver.findElement(webEle).click();

		}
	}
	public String titleTest() {
		return driver.getTitle();
	}

	public static void pressEnter() {
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER);
	}

	public static void scrollupto(By webEle) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",webEle);

	}

	public static void clickonElementbyjs(WebElement webEle) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", webEle);
	}

	public static String getText(By webEle) {
		String gettext=driver.findElement(webEle).getText();
		return gettext;
	}

	public static boolean elementvisibletest(By webEle) {
		boolean gettext=driver.findElement(webEle).isEnabled();
		return gettext;
	}

	public static void explicitWait(By ele) {
		WebDriverWait wait=new WebDriverWait(TestBase.driver,2);
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
		
		

	}





