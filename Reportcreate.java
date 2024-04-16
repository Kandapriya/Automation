package Report;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
						
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		Thread.sleep(3000);
		
		//Open Reports:
		WebElement report = driver.findElement(By.xpath("//a[@title='Reports']"));
		driver.executeScript("arguments[0].click();", report);
		driver.findElement(By.xpath("//button[@title='New Folder']")).click();
		Thread.sleep(5000);
		
		//Create New Folder:
		WebElement newfolder = driver.findElement(By.xpath("(//span[text()='Folder Label']/following::input)[1]"));
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		newfolder.sendKeys(firstName);
		driver.findElement(By.xpath("(//span[text()='Folder Label']/following::input)[2]")).sendKeys(firstName);
		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		
        //Navigate to All Folders:
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@title='All Folders'])[2]")).click();
		//Open Created Folder:
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Search all folders...']")).sendKeys(firstName);
		Thread.sleep(5000);
		String foldername = driver.findElement(By.xpath("//table[@aria-label='All Folders']//tbody/tr/th[1]")).getText();
		System.out.println("Folder Name is :"+foldername);
		WebElement openfolder = driver.findElement(By.xpath("//table[@aria-label='All Folders']//tbody/tr/th[1]"));
		openfolder.click();
		openfolder.sendKeys(Keys.ENTER);
		
		//Create New Report: 
		driver.findElement(By.xpath("(//a[@title='New Report'])[2]")).click();
		
		//Select Report Type
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Opportunities with Products']/ancestor::td")).click();
		driver.findElement(By.xpath("//button[text()='Start Report']")).click();
		driver.switchTo().defaultContent();
		
		//Save Report: 
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Save']/parent::div")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='reportName']")).sendKeys("New opportunity for priya");
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand report-save']")).click();
		driver.switchTo().defaultContent();
		
		//Run Report:
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//button[text()='Run']")).click();
		driver.switchTo().defaultContent();
		
		//Verify Report Creation:
		Thread.sleep(5000);
		driver.switchTo().frame(0);
		String reportcreat = driver.findElement(By.xpath("//div[@class='slds-page-header__name-title']")).getText();
		if (reportcreat.contains("New opportunity for priya")) {
			System.out.println("The report is successfully created.");
			
		} else {
			System.out.println("The report is successfully not created.");

		}
	}

}
