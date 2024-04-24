package Opportunity;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='slds-button'])[2]"))).click();
		} catch (NoSuchElementException e) {
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		}
		
		try {
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
		} catch (ElementClickInterceptedException e) {
			WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
			driver.executeScript("arguments[0].click();", sale);
		}
		
		//Open Opportunities
		WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		
		//Search and Open Opportunity:
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"))));
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Testleaf"+Keys.ENTER);

	     try {
	    	 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]")))).click();
		} catch (ElementClickInterceptedException e1) {
			WebElement comtest1 = driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]"));
			driver.executeScript("arguments[0].click();", comtest1);
		}catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
			try {
				 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]")))).click();
			} catch (ElementClickInterceptedException e2) {
				WebElement comtest1 = driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]"));
				driver.executeScript("arguments[0].click();", comtest1);
			}}
		
		//Create New Task:Set Task Details
		driver.findElement(By.xpath("//button[@aria-label='New Task']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Other']"));
		driver.executeScript("arguments[0].click();", subject);
		try {
			driver.findElement(By.xpath("//button[@title='Select a date for Due Date']")).click();
		} catch (Exception e1) {
			WebElement dateclick = driver.findElement(By.xpath("//button[@title='Select a date for Due Date']"));
			driver.executeScript("arguments[0].click();", dateclick);
		}
		driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		//Upload Sample File:
		
		WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(upload));
			upload.sendKeys("D:\\2 INTERNSHIP TESTING\\AUTOMATION\\DAY7.txt");
		} catch (Exception e) {
			upload.sendKeys("D:\\2 INTERNSHIP TESTING\\AUTOMATION\\DAY7.txt");
		}
		
		
		//Verify File Name:
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Done']/.."))));
		driver.findElement(By.xpath("//span[text()='Done']/..")).click();
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='filerow']/ancestor::li)[1]"))));
		String fileupload = driver.findElement(By.xpath("(//div[@class='filerow']/ancestor::li)[1]")).getText();
		if (fileupload.contains("DAY7")) {
			System.out.println("the uploaded file name is displayed under 'Notes and Attachments'"+fileupload);
			
		} else {
			System.out.println("the uploaded file name is not displayed under 'Notes and Attachments'");

		}
		//Navigate to Details
		WebElement details = driver.findElement(By.xpath("//li[@title='Details']"));
		driver.executeScript("arguments[0].click();", details);
		WebElement status = driver.findElement(By.xpath("//span[text()='Edit Stage']/.."));
		wait.until(ExpectedConditions.visibilityOf(status));
		driver.executeScript("arguments[0].click();", status);
		Actions tostatus=new Actions(driver);
		//tostatus.scrollToElement(driver.findElement(By.xpath("//span[text()='Probability (%)']/parent::div"))).perform();
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Stage']"))).click();
		} catch (ElementClickInterceptedException e3) {
			WebElement sta = driver.findElement(By.xpath("//label[text()='Stage']"));
			driver.executeScript("arguments[0].click();", sta);
		}
		
		
		WebElement need = driver.findElement(By.xpath("//span[text()='Needs Analysis']/ancestor::lightning-base-combobox-item"));
		driver.executeScript("arguments[0].click();", need);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Description']"))));
		tostatus.scrollToElement(driver.findElement(By.xpath("//label[text()='Description']"))).perform();
		
		WebElement descr = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow textarea-container']/textarea"));
		wait.until(ExpectedConditions.visibilityOf(descr));
		descr.sendKeys("Attachments uploaded successfully.\"");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//Check Stage Completion:
		wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//a[@title='Needs Analysis']"))));
		String verify= driver.findElement(By.xpath("//a[@title='Needs Analysis']")).getText();
		if (verify.contains("stage complete\"")) {
			System.out.println("Needs Analysis' stage is marked as completed");
		} else {
         System.out.println("Needs Analysis' stage is marked as not completed");
		}
		
		tostatus.scrollToElement(driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']/ancestor::button"))).perform();
		
		WebElement stagecomplete = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']/.."));
		wait.until(ExpectedConditions.visibilityOf(stagecomplete));
		driver.executeScript("arguments[0].click();", stagecomplete);
		
	}

}
