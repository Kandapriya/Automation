package libararyclassic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.github.javafaker.Faker;

public class Baseclassclassic {

	
		//globally declare driver	
		public RemoteWebDriver driver;
		public WebDriverWait wait;
		public Faker faker;
		public static String name;
		public static String cname;
		
		    @Parameters({"url","username","password","browser"})
		    @BeforeMethod
			public void perconditionslead(String url,String uname,String pw,String browser){
				// To disable the notifications
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
							
				//lanch chrome 
				 faker = new Faker();			
				 if(browser.equalsIgnoreCase("chrome")) {
						driver  = new ChromeDriver();
					}else if (browser.equalsIgnoreCase("edge")) {
						driver  = new EdgeDriver();
					}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get(url);
							
				//Login to salesforce
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pw);
				driver.findElement(By.xpath("//input[@id='Login']")).click();
				wait=new WebDriverWait(driver, Duration.ofSeconds(10));
							
		    }
//			     @AfterMethod
//		       public void postconditionlead() {
//				//driver.close();
//			  }

	}

