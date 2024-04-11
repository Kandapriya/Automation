package Opportunity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

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
				
				//Verify Details
				String companyname = driver.findElement(By.xpath("//P[@title='Account Name']/../..")).getText();
				if(companyname.contains("Testleaf")) {
					System.out.println("The account name is valid :"+companyname);
				}else {
					System.out.println("The account name is invalid");
				}

               String contactname = driver.findElement(By.xpath("//div[@class='primaryRow sfaOcrRelatedListPrimaryField']")).getText();
               System.out.println(contactname);
				if (contactname.contains("kandhapriya")) {
					System.out.println("The contact name is valid :"+contactname);
				}else {
					System.out.println("The contact name is invalid");
					}
				//Create New Task:
				driver.findElement(By.xpath("//button[@title='New Task']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
				driver.executeScript("arguments[0].click();", subject);
				driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
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
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("kpriya@testleaf.com");
				driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("Manageopportunity");
				Thread.sleep(3000);
				driver.switchTo().frame(0);
				Thread.sleep(3000);
				driver.switchTo().frame(0);
				driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")).sendKeys("opportunity is completed");
				driver.switchTo().defaultContent();
				driver.findElement(By.xpath("//span[text()='Send']")).click();
				Thread.sleep(3000);
				
               //Check Email Status:
				Thread.sleep(3000);
				WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/../.."));
				driver.executeScript("arguments[0].click();", emailstatus);
				Thread.sleep(3000);
				WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']/.."));
		        driver.executeScript("arguments[0].click();",click);
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//a[text()='Not Started']")).click();
				driver.findElement(By.xpath("//a[text()='Completed']")).click();
				driver.findElement(By.xpath("(//span[text()='Save'])[3]"));
				
				//Edit Opportunity Stage
				Thread.sleep(3000);
				WebElement submitdropdown = driver.findElement(By.xpath("(//span[text()='Show more actions']/..)[1]"));
				driver.executeScript("arguments[0].click();", submitdropdown);
				WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']/.."));
				driver.executeScript("arguments[0].click()", edit);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//label[text()='Stage']")).click();
				driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Qualification']")).click();
				driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
				
				//Take Snapshot:
				Thread.sleep(5000);
				File scr=driver.getScreenshotAs(OutputType.FILE);
				Thread.sleep(3000);
				File des=new File("./snapshot/opportunity.png");
				FileUtils.copyFile(scr, des);
	}

}
