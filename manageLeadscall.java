package Leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class manageLeadscall {

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
				
				driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				
				//java scrpit to click lead
				WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
				driver.executeScript("arguments[0].click();", lead);
				Thread.sleep(5000);
				Actions search=new Actions(driver);
				search.click(driver.findElement(By.xpath("//button[text()='Search...']"))).perform();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("kandhapriya"+Keys.ENTER);
				
				//Log a Call To-Do
				driver.findElement(By.xpath("(//a[text()='kandhapriya'])[2]")).click();
				driver.findElement(By.xpath("(//button[@title='More Actions'])[1]")).click();
				driver.findElement(By.xpath("//span[text()='Add Call to To Do List']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subjectcall = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Call']"));
				driver.executeScript("arguments[0].click();", subjectcall);
				driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).click();
				driver.findElement(By.xpath("(//td[@class='slds-is-today']/following-sibling::td)[1]")).click();
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
				
				//View Logged Call
				driver.findElement(By.xpath("(//span[text()='Log a Call'])[2]")).click();
				driver.findElement(By.xpath("//textarea[@aria-describedby='quickTextKeyboardTip']")).sendKeys("'Can we discuss working together?'");
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
				
				
				//Check Call Status
			    WebElement callstatus = driver.findElement(By.xpath("(//span[text()='Show more actions'])[2]/../.."));
				driver.executeScript("arguments[0].click();", callstatus);
				Thread.sleep(3000);
				WebElement click = driver.findElement(By.xpath("//a[@title='Change Status']"));
		        driver.executeScript("arguments[0].click();",click);
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//a[text()='Not Started']")).click();
				driver.findElement(By.xpath("//a[text()='Completed']")).click();
				driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	}

}
