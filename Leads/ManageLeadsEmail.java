package Leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		
		 WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
	        driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	        try {
	        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")))).click();
	             } catch (NoSuchElementException e) {
		    driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
	              }

	        driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//java scrpit to click lead
		
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click();", lead);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//creating new lead
		 //replacing Thread.sleep() with explicit waits
		WebElement newtext = driver.findElement(By.xpath("(//span[text()='--None--'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(newtext));
		newtext.click();
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
		System.out.println("the Title ('QA') and Company details are: "+title+company);
		
		//Add Email to To-Do List:
		driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Add Email to To Do List']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
		driver.executeScript("arguments[0].click();", subject);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[5]")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		//Send Email
		
		WebElement sendemail = driver.findElement(By.xpath("//button[@title='Email']"));
		driver.executeScript("arguments[0].click();", sendemail);
		 //replacing Thread.sleep() with explicit waits
		WebElement mailid = driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(mailid));
		mailid.sendKeys("kpriya@testleaf.com");
		WebElement sub = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
		wait.until(ExpectedConditions.visibilityOf(sub));
		sub.sendKeys("ManageLeads");
		
		 //replacing Thread.sleep() with explicit waits
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		//driver.switchTo().frame(0);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); 
		//driver.switchTo().frame(0);
		WebElement compose = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(compose));
		compose.sendKeys("This story covers the steps to update the email status to 'Completed\r\n");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		 
		
		//Check Email Status:
		WebElement emailstatus;
		
		emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions']//ancestor::a)[2]"));
		//wait.until(ExpectedConditions.visibilityOf(emailstatus));
		driver.executeScript("arguments[0].click();", emailstatus);
		WebElement click1 = driver.findElement(By.xpath("(//div[@title='Change Status']/parent::a)[2]"));
		//wait.until(ExpectedConditions.visibilityOf(click1));
		driver.executeScript("arguments[0].click();",click1);
	    //replacing Thread.sleep() with explicit waits
        WebElement changecom = driver.findElement(By.xpath("//a[text()='Not Started']"));
       // wait.until(ExpectedConditions.visibilityOf(changecom));
        changecom.click();
		driver.findElement(By.xpath("//a[text()='Completed']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	}

}
