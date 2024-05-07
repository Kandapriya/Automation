package Lead2Opportunity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import com.github.javafaker.Faker;

public class Baseclasslead2opp {
	
	//globally declare driver	
		public RemoteWebDriver driver;
		public WebDriverWait wait;
		public Faker faker;
		public static String comname;
		public static String lastName;
		public static Properties prop;

		 @BeforeMethod
	public  void percondition() throws IOException {
			// To disable the notifications
				//lanch chrome 
				 faker = new Faker();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
								
				//lanch chrome 
				driver=new ChromeDriver(options);
                driver.manage().window().maximize();
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				 driver.get("https://login.salesforce.com");
				 
				 FileInputStream file=new FileInputStream("./src/main/resources/leadtoopportunity.properties");
				 prop = new Properties();
				 prop.load(file);
				 
				//Login to salesforce
				 
				 String usna = new String( Base64.getDecoder().decode(prop.getProperty("username")));
				 String pw= new String( Base64.getDecoder().decode(prop.getProperty("password")));
				 
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(usna);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
				driver.findElement(By.xpath("//input[@id='Login']")).click();
				//click to sales
					 wait=new WebDriverWait(driver, Duration.ofSeconds(30));
				     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
				     driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				     try {
				     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")))).click();
				          } catch (NoSuchElementException e) {
					 driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
				              }
				     try {
							driver.findElement(By.xpath("//p[text()='Sales']")).click();
						} catch (ElementClickInterceptedException e) {
							WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
							driver.executeScript("arguments[0].click();", sale);
						}
		}
//	     @AfterMethod
//       public void postconditionlead() {
//		//driver.close();
//	  }

}
