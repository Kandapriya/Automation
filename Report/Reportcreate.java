package Report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Reportcreate {

	public static void main(String[] args) throws InterruptedException {
		//Login: Log in to the Salesforce account 
		// To disable the notifications 
		
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
						
		//lanch chrome 
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
						
		//Login to salesforce
						
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kpriya@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("March2016.");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
						
		//click to sales
						
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
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
		
		//Open Reports:
		WebElement report = driver.findElement(By.xpath("//a[@title='Reports']"));
		driver.executeScript("arguments[0].click();", report);
		driver.findElement(By.xpath("//button[@title='New Folder']")).click();
		
		
		//Create New Folder:
		WebElement newfolder = driver.findElement(By.xpath("(//span[text()='Folder Label']/following::input)[1]"));
		wait.until(ExpectedConditions.visibilityOf(newfolder));
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		newfolder.sendKeys(firstName);
		driver.findElement(By.xpath("(//span[text()='Folder Label']/following::input)[2]")).sendKeys(firstName);
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		
        //Navigate to All Folders:
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@title='All Folders'])[2]"))));
		driver.findElement(By.xpath("(//a[@title='All Folders'])[2]")).click();
		//Open Created Folder:
		
		driver.findElement(By.xpath("//input[@placeholder='Search all folders...']")).sendKeys(firstName);
		
		String foldname = driver.findElement(By.xpath("//table[@aria-label='All Folders']//tbody/tr/th[1]")).getText();
		System.out.println("Folder Name is :"+foldname);
		WebElement openfolder = driver.findElement(By.xpath("//table[@aria-label='All Folders']//tbody/tr/th[1]"));
		openfolder.click();
		openfolder.sendKeys(Keys.ENTER);
		
		//Create New Report: 
		driver.findElement(By.xpath("(//a[@title='New Report'])[2]")).click();
		
		//Select Report Type
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		
		driver.findElement(By.xpath("//p[text()='Opportunities with Products']/ancestor::td")).click();
		driver.findElement(By.xpath("//button[text()='Start Report']")).click();
		driver.switchTo().defaultContent();
		
		//Save Report: 
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		driver.switchTo().defaultContent();
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		driver.findElement(By.xpath("//input[@id='reportName']")).sendKeys("New opportunity for priya");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand report-save']")).click();
		driver.switchTo().defaultContent();
		
		//Run Report:
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		try {
			driver.findElement(By.xpath("//button[text()='Run']")).click();
		}
		 catch (NoSuchElementException e) {
			driver.findElement(By.xpath("//button[text()='Run']")).click();
		}catch (ElementNotInteractableException e) {
			WebElement run = driver.findElement(By.xpath("//button[text()='Run']"));
			driver.executeScript("arguments[0].click()", run);
		}

		driver.switchTo().defaultContent();
		
		//Verify Report Creation:
		WebElement reportFrame = driver.findElement(By.xpath("//iframe[@title='Report Viewer']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@title='Report Viewer']")));
		driver.switchTo().frame(reportFrame);
		System.out.println("Moved1");
	
		String reportcreat = driver.findElement(By.xpath("//div[@class='slds-page-header__name-title']/parent::div")).getText();
		if (reportcreat.contains("New opportunity for priya")) {
			System.out.println("The report is successfully created."+reportcreat);
			
		} else {
			System.out.println("The report is successfully not created.");
		}
		
		}

}
