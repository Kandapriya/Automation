package Opportunity;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Uploadfileopportunity {

	public static void main(String[] args) throws InterruptedException {
		// Login: Log in to the Salesforce account 
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
		Thread.sleep(3000);				
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Open Opportunities
		WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		
		//Search and Open Opportunity:
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Testleaf"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]")).click();
		
		//Create New Task:Set Task Details
		driver.findElement(By.xpath("//button[@aria-label='New Task']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Other']"));
		driver.executeScript("arguments[0].click();", subject);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		//Upload Sample File:
		Thread.sleep(3000);
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		upload.sendKeys("D:\\2 INTERNSHIP TESTING\\AUTOMATION\\DAY7.txt");
		
		//Verify File Name:
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Done']/..")).click();
		Thread.sleep(3000);
		String fileupload = driver.findElement(By.xpath("(//div[@class='filerow']/ancestor::li)[1]")).getText();
		if (fileupload.contains("DAY7")) {
			System.out.println("the uploaded file name is displayed under 'Notes and Attachments'"+fileupload);
			
		} else {
			System.out.println("the uploaded file name is not displayed under 'Notes and Attachments'");

		}
		//Navigate to Details
		driver.findElement(By.xpath("//li[@title='Details']")).click();
		Thread.sleep(3000);
		WebElement status = driver.findElement(By.xpath("//span[text()='Edit Stage']/.."));
		driver.executeScript("arguments[0].click();", status);
		Actions tostatus=new Actions(driver);
		tostatus.scrollToElement(driver.findElement(By.xpath("//label[text()='Probability (%)']/parent::div"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Stage']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-item-id='combobox-button-555-3']")).click();
		Thread.sleep(3000);
		tostatus.scrollToElement(driver.findElement(By.xpath("//label[text()='Description']"))).perform();
		Thread.sleep(3000);
		WebElement descr = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']/textarea"));
		descr.sendKeys("Attachments uploaded successfully.\"");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//Check Stage Completion:
		Thread.sleep(3000);
		String verify= driver.findElement(By.xpath("//a[@title='Needs Analysis']")).getText();
		if (verify.contains("stage complete\"")) {
			System.out.println("Needs Analysis' stage is marked as completed");
		} else {
         System.out.println("Needs Analysis' stage is marked as not completed");
		}
		Thread.sleep(3000);
		WebElement stagecomplete = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']/.."));
		driver.executeScript("arguments[0].click();", stagecomplete);
		
	}

}
