package Leadtestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

public class BaseclassLead {
	
//globally declare driver	
public ChromeDriver driver;
public WebDriverWait wait;
public Faker faker;
public static String name;
public static String cname;


	
	@BeforeMethod
	public void perconditionslead(){
		// To disable the notifications
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
					
		//lanch chrome 
		 faker = new Faker();			
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
					
		//Login to salesforce
					
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kpriya@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("March2016.");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
					
		//click to sales
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']"))).click();
		} catch (Exception e) {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		}
		try {
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
		} catch (ElementClickInterceptedException e) {
		WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.executeScript("arguments[0].click();", sale);
		}
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click()", lead);	
        }
	    
	   
	
	   @AfterMethod
       public void postconditionlead() {
		driver.close();
	  }
}
