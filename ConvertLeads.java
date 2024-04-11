package Leads;

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

public class ConvertLeads {

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
						
		//java scrpit to click lead
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click();", lead);
		Thread.sleep(5000);
		Actions search=new Actions(driver);
		search.click(driver.findElement(By.xpath("//button[text()='Search...']"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search Leads and more...']")).sendKeys("kandhapriya"+Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("(//a[text()='kandhapriya'])[4]")).click();
		
		//Edit Lead Status
		driver.findElement(By.xpath("//li[@title='Details']")).click();
		WebElement editicon = driver.findElement(By.xpath("//button[@title='Edit Lead Status']"));
		driver.executeScript("arguments[0].click();", editicon);
		Actions toleadstatus=new Actions(driver);
		toleadstatus.scrollToElement(driver.findElement(By.xpath("//label[text()='No. of Employees']"))).perform();
		
		driver.findElement(By.xpath("//label[text()='Lead Status']")).click();
		
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		//Check Status Completion:
		toleadstatus.scrollToElement(driver.findElement(By.xpath("//a[@title='Working - Contacted']"))).perform();
		WebElement complete = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']/.."));
		driver.executeScript("arguments[0].click();", complete);
		
		//Convert Lead:
		Thread.sleep(30);
		WebElement submitdropdown = driver.findElement(By.xpath("(//span[text()='Show more actions']/..)[2]"));
		driver.executeScript("arguments[0].click();", submitdropdown);
		Thread.sleep(3000);
		WebElement convert = driver.findElement(By.xpath("//span[text()='Convert']/.."));
		driver.executeScript("arguments[0].click();", convert);
		Thread.sleep(3000);
		WebElement convertlead = driver.findElement(By.xpath("//button[text()='Convert']"));
		driver.executeScript("arguments[0].click();", convertlead);
		
		//Snapshot
		Thread.sleep(3000);
		WebElement snaplead = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
		File scr=snaplead.getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		File des=new File("./snapshot/leadconvert.png");
		FileUtils.copyFile(scr, des);
		
		//Close Pop-up:
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Close this window']")).click();
	}

}
