package Leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
				WebElement searchlead = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
				wait.until(ExpectedConditions.visibilityOf(searchlead));
				searchlead.sendKeys("kandhapriya"+Keys.ENTER);
				WebElement leadsname = driver.findElement(By.xpath("//a[@title='kandhapriya']"));
				wait.until(ExpectedConditions.visibilityOf(leadsname));
				driver.executeScript("arguments[0].click()",leadsname );
				
				//Log a Call To-Do
				driver.findElement(By.xpath("(//button[@title='More Actions'])[1]")).click();
				driver.findElement(By.xpath("//span[text()='Add Call to To Do List']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subjectcall = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Call']"));
				driver.executeScript("arguments[0].click();", subjectcall);
				WebElement callclick = driver.findElement(By.xpath("(//input[@class='slds-input'])[5]"));
				wait.until(ExpectedConditions.visibilityOf( callclick));
				callclick.click();
				driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				
				//View Logged Call
				driver.findElement(By.xpath("(//span[text()='Log a Call'])[2]")).click();
				driver.findElement(By.xpath("//textarea[@aria-describedby='quickTextKeyboardTip']")).sendKeys("'Can we discuss working together?'");
				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				
				
				//Check Call Status
			    WebElement callstatus = driver.findElement(By.xpath("(//span[text()='Show more actions']//ancestor::a)[2]"));
				driver.executeScript("arguments[0].click();", callstatus);
				
				WebElement clicklead = driver.findElement(By.xpath("(//div[@title='Change Status']/parent::a)[2]"));
				//wait.until(ExpectedConditions.visibilityOf( clicklead));
		        driver.executeScript("arguments[0].click();",clicklead);
		        
		        WebElement comlead = driver.findElement(By.xpath("//a[text()='Not Started']"));
		        //wait.until(ExpectedConditions.visibilityOf( comlead));
		        comlead.click();
				driver.findElement(By.xpath("//a[text()='Completed']")).click();
				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
	}

}
