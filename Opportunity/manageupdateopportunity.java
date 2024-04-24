package Opportunity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class manageupdateopportunity {

	public static void main(String[] args) throws InterruptedException, IOException {
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
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				try {
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']"))).click();
				} catch (NoSuchElementException e) {
					driver.findElement(By.xpath("//button[text()='View All']")).click();
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
				
			     wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]"))));
				//WebElement comtest = driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]"));
					//driver.executeScript("arguments[0].click();", test);
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
					}
				
				
				}
				//Verify Details
				String companyname = driver.findElement(By.xpath("//P[@title='Account Name']/../..")).getText();
				if(companyname.contains("Testleaf")) {
					System.out.println("The account name is valid :"+companyname);
				}else {
					System.out.println("The account name is invalid");
				}
			    Actions contname=new Actions(driver);
			    try {
					contname.scrollToElement(driver.findElement(By.xpath("//*[text()='Contact Roles']"))).perform();
				} catch (NoSuchElementException e) {
					contname.scrollToElement(driver.findElement(By.xpath("//*[text()='Contact Roles']"))).perform();
				}
				String contactName = driver.findElement(By.xpath("//h3[@class='primaryField slds-tile__title slds-truncate']//a")).getText();
				System.out.println("The contact name is: "+contactName);
				if(contactName.contains("kandhapriya")) {
					System.out.println("The contact name is valid");
				}else {
					System.out.println("The contact name is invalid");
				}

               
				//Create New Task:
				contname.scrollToElement(driver.findElement(By.xpath("//button[@title='New Task']"))).perform();
				driver.findElement(By.xpath("//button[@title='New Task']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
				driver.executeScript("arguments[0].click();", subject);
				try {
					driver.findElement(By.xpath("//button[@title='Select a date for Due Date']")).click();
				} catch (Exception e1) {
					WebElement dateclick = driver.findElement(By.xpath("//button[@title='Select a date for Due Date']"));
					driver.executeScript("arguments[0].click();", dateclick);
				}
				driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
				driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
				driver.findElement(By.xpath("//div[@title='kandhapriya']")).click();
				driver.findElement(By.xpath("//a[@class='select']")).click();
				String assigned = driver.findElement(By.xpath("(//li[@class='pillContainerListItem'])[5]")).getText();
				if (assigned.contains("Kandhapriya vadivelan")) {
					System.out.println("verify it assigned to related opportunity :"+assigned);
					
				} else {
                   System.out.println("not assigned to related opportunity");
				}
				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				
				//Send Email
				WebElement sendemail = driver.findElement(By.xpath("//button[@title='Email']"));
				driver.executeScript("arguments[0].click();", sendemail);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]"))));
				driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("kpriya@testleaf.com");
				driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("Manageopportunity");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			    driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")).sendKeys("opportunity is completed");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("//span[text()='Send']")).click();
				
				
               //Check Email Status:
				
				WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/../.."));
				driver.executeScript("arguments[0].click();", emailstatus);
				
				WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']/.."));
		        driver.executeScript("arguments[0].click();",click);
		        
		        driver.findElement(By.xpath("//a[text()='Not Started']")).click();
				driver.findElement(By.xpath("//a[text()='Completed']")).click();
				driver.findElement(By.xpath("(//span[text()='Save'])[3]"));
				
				//Edit Opportunity Stage
			
				WebElement submitdropdown = driver.findElement(By.xpath("(//span[text()='Show more actions']/..)[1]"));
				wait.until(ExpectedConditions.visibilityOf(submitdropdown));
				driver.executeScript("arguments[0].click();", submitdropdown);
				WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']/.."));
				driver.executeScript("arguments[0].click()", edit);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[text()='Stage']"))));
				driver.findElement(By.xpath("//label[text()='Stage']")).click();
				driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Qualification']")).click();
				driver.findElement(By.xpath("//button[text()='Save']")).click();
				
				//Take Snapshot:
				
				File scr=driver.getScreenshotAs(OutputType.FILE);
				File des=new File("./snapshot/opportunity.png");
				FileUtils.copyFile(scr, des);
	}
	
}

//Login: Log in to the Salesforce account at https://login.salesforce.com.
//
//Navigate: Click on the toggle menu button located in the left corner.
//
//Access Sales App: Select 'View All' and click on 'Sales' from the App Launcher.
//
//Open Opportunities: Navigate to the 'Opportunities' tab.
//
//Search and Open Opportunity: Search for the opportunity associated with the converted lead by company name.
//
//Verify Details: Confirm the account name (company name from the lead) at the top left of the webpage and verify the contact (your name) at the right bottom.
//
//Create New Task: Click on the new task icon under 'Activity', choose subject as 'email', set due date as today's date, and verify correct assignment of contact and related opportunity.
//
//Update Task Status: Change the task status to 'In Progress' and click 'Save'.
//
//Send Email: Click on the email icon under 'Activity', compose an email to the opportunity, and click 'Send'.
//
//Check Email Status: Click on the widget icon for the email under 'Upcoming & Overdue', change status to 'Completed', and save.
//
//Edit Opportunity Stage: Click on the widget icon for the opportunity at the top right, click 'Edit', change the stage to 'Qualification', and click 'Save'.
//
//Take Snapshot: Capture a screenshot of the webpage.
