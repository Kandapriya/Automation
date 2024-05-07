package Lead2Opportunity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class EmailsendinLead {

	public static void main(String[] args) {
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

		
		//java scrpit to click lead
		
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click()", lead);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//creating new lead
		
		driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
		Faker faker=new Faker();
		String lastName = faker.name().lastName();
		String comname = faker.company().name();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(comname);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
//		//Verify Lead Details:
//		boolean leadpresent = driver.findElement(By.xpath("//lightning-formatted-name[@slot='primaryField']")).isDisplayed();
//		Assert.assertTrue(leadpresent );
//	    System.out.println("The lead name is present as kandhapriya is :"+leadpresent );
//	    boolean compresent = driver.findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).isDisplayed();
//	    Assert.assertTrue(leadpresent );
//	    System.out.println("The company name is present as TESTLEAF is :"+compresent );
	    
	  //Verify Lead Details:
        String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-name")).getText();
        System.out.println(leadt);
	    String actualname="Mrs. " + lastName;
	    Assert.assertEquals(leadt, actualname);
	    String comlead = driver.findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).getText();
	    System.out.println(comlead);
	    String actualcomlead=comname;
	    Assert.assertEquals(comlead , actualcomlead);
	    
	   //Add Email to To-Do List:
		driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
		driver.findElement(By.xpath("//span[text()='Add Email to To Do List']")).click();
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
		WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
		driver.executeScript("arguments[0].click();", subject);
		WebElement duedate = driver.findElement(By.xpath("(//input[@class='slds-input'])[5]"));
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date = currentDate.format(dateFormat);
		System.out.println(date);
		duedate.sendKeys(date);
		driver.findElement(By.xpath("//a[@class='select']")).click();
		driver.findElement(By.xpath("//a[@title='In Progress']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		//Send Email to Lead:

		WebElement sendemail = driver.findElement(By.xpath("//button[@title='Email']"));
		driver.executeScript("arguments[0].click();", sendemail);
		WebElement mailid = driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(mailid));
		mailid.sendKeys("kpriya@testleaf.com");
		WebElement sub = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
		wait.until(ExpectedConditions.visibilityOf(sub));
		sub.sendKeys("ManageLeads for END TO END");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); 
		WebElement compose = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(compose));
		compose.sendKeys("This story covers the steps to update the email status to 'Completed END TO END\r\n");
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[text()='Send']")).click();
		
		//Change Lead Status:
		WebElement emailstatus;
		emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions']//ancestor::a)[2]"));
		driver.executeScript("arguments[0].click();", emailstatus);
		WebElement click1 = driver.findElement(By.xpath("(//div[@title='Change Status']/parent::a)[2]"));
		driver.executeScript("arguments[0].click();",click1);
	    WebElement statuschange= driver.findElement(By.xpath("//a[@class='select']"));
		try {
			statuschange.click();
		} catch (StaleElementReferenceException e) {
			//driver.get(driver.getCurrentUrl());
			try {
				driver.findElement(By.xpath("//a[@class='select']")).click();
		}catch (StaleElementReferenceException e1) {
			driver.findElement(By.xpath("//a[@class='select']")).click();
		}
		}
		driver.findElement(By.xpath("//a[text()='Completed']")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
		
		//Navigate to the lead's details.
		try {
			driver.findElement(By.xpath("//li[@title='Details']")).click();
		} catch (ElementClickInterceptedException e) {
			WebElement detail = driver.findElement(By.xpath("//li[@title='Details']"));
			driver.executeScript("arguments[0].click();",detail);
		}
		WebElement editicon = driver.findElement(By.xpath("//button[@title='Edit Lead Status']"));
		driver.executeScript("arguments[0].click();", editicon);
		Actions toleadstatus=new Actions(driver);
		toleadstatus.scrollToElement(driver.findElement(By.xpath("//label[text()='No. of Employees']"))).perform();
		
		driver.findElement(By.xpath("//label[text()='Lead Status']")).click();
		
		try {
			driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
		} catch (NoSuchElementException e1) {
			driver.findElement(By.xpath("//label[text()='Lead Status']")).click();	
			driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
		}
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

	}

}
