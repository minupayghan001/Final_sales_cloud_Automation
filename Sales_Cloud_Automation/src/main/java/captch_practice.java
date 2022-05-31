import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sca.commosActions.TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.extensions.TestSetup;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class captch_practice extends TestBase{
	

	
	public static WebDriver driver1;
	TestBase t=new TestBase();
	
	public static void takeSS(String SS)  throws InterruptedException, IOException, TesseractException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver1=new ChromeDriver(opt);
		driver1.get("https://www.irctc.co.in/nget/train-search");
		
		driver1.manage().window().maximize();
		
		Thread.sleep(9000);
		//Alert alert=driver1.switchTo().alert();
		
		//alert.accept();
		driver1.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		Thread.sleep(3000);
		
		//driver1.findElement(By.linkText(" LOGIN ")).click();
		driver1.findElement(By.xpath("//a[@class=\"search_btn loginText ng-star-inserted\"]")).click();
		Thread.sleep(15000);
		String ID="(//div[@class=\"modal-body\"]/form/div/input)[1]";
		String PW="(//div[@class=\"modal-body\"]/form/div/input)[2]";
		driver1.findElement(By.xpath("(//div[@class=\"modal-body\"]/form/div/input)[1]")).click();
		driver1.findElement(By.xpath("(//div[@class=\"modal-body\"]/form/div/input)[1]")).sendKeys("AvantiSJoshi");
		driver1.findElement(By.xpath("(//div[@class=\"modal-body\"]/form/div/input)[2]")).click();
		driver1.findElement(By.xpath("(//div[@class=\"modal-body\"]/form/div/input)[2]")).sendKeys("Test@123");
		
		
		File f=driver1.findElement(By.xpath("//div[contains(@class,'header captcha_mainDeiv ')]/div/div/div/span/img")).getScreenshotAs(OutputType.FILE);
		
		String path=System.getProperty("user.dir")+"./screenshots/"+SS+".png";
		FileHandler.copy(f,new File(path));
		
		//String TDPath="C:\\Users\\avanti.joshi\\Desktop\\Final_sales_cloud_Automation\\Sales_Cloud_Automation\\tessdata-main"+"./screenshots/"+SS+".png";
		//FileHandler.copy(f,new File(TDPath));
		Tesseract instance = new Tesseract(); 
	    String imgtext=instance.doOCR(new File(path));	    
	    driver1.findElement(By.xpath("//input[@id=\"captcha\"]")).sendKeys(imgtext);
	    driver1.findElement(By.xpath("(//button[@class=\"search_btn train_Search\"])[2]")).click();
	    
	    Thread.sleep(5000);
	    System.out.println("actual captch is : "+imgtext);
	    
	   
		
	}
	public static void main(String[] args) throws InterruptedException, IOException, TesseractException {
		
		takeSS("Avanti2");
	}

}
