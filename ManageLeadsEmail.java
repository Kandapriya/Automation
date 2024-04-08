package Leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ManageLeadsEmail {

	public static void main(String[] args) throws InterruptedException {
		//To disable the notifications
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
		
		//click to new lead
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//java scrpit to click lead
		
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click();", lead);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		
		//creating new lead
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Lakshmi");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("//input[@name='Title']")).sendKeys("QA");
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
		//Verify Lead Name: Confirm that the lead name is displayed as 'Salutation + Last Name' (e.g., 'Mr. Any Name').
		
		String leadt = driver.findElement(By.xpath("//lightning-formatted-name[text()='Mrs.  Lakshmi']")).getText();
		System.out.println(" verifying,the lead's name is displayed:"+leadt);
		
		//Verify Details: Confirm that the Title ('QA') and Company details are accurate.
		String title = driver.findElement(By.xpath("//lightning-formatted-text[text()='QA']")).getText();
		String company = driver.findElement(By.xpath("//lightning-formatted-text[text()='Testleaf']")).getText();
		Thread.sleep(3000);
		System.out.println("the Title ('QA') and Company details are: "+title+company);
		
		//Add Email to To-Do List:
		driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Add Email to To Do List']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
		driver.executeScript("arguments[0].click();", subject);
		WebElement date = driver.findElement(By.xpath("//button[@title='Select a date for Due Date']"));
		driver.executeScript("arguments[0].click();", date);
		driver.findElement(By.xpath("(//span[text()='8'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		
		//Send Email
		
		WebElement sendemail = driver.findElement(By.xpath("//button[@title='Email']"));
		driver.executeScript("arguments[0].click();", sendemail);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]")).sendKeys("kpriya@testleaf.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']")).sendKeys("ManageLeads");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']")).sendKeys("This story covers the steps to log in, create a new lead with specific details, verify lead information, add an email to the to-do list, send an email, and update the email status to 'Completed\r\n");
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		Thread.sleep(3000);
		
		//Check Email Status:
		
		
		Thread.sleep(3000);
		WebElement emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/../.."));
		driver.executeScript("arguments[0].click();", emailstatus);
		Thread.sleep(3000);
		WebElement click = driver.findElement(By.xpath("//div[@title='Change Status']"));
        driver.executeScript("arguments[0].click();",click);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text()='Not Started']")).click();
		driver.findElement(By.xpath("//a[text()='Completed']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

}
