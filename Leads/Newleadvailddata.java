package Leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newleadvailddata {

	public static void main(String[] args) throws InterruptedException {
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
		driver.executeScript("arguments[0].click()", lead);
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
		//creating new lead
		
		driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("kandhapriya");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/..")).getText();
		if (leadt.contains("kandhapriya")) {
			System.out.println(" verifying,the lead's name is displayed:"+leadt);
		} else {
			System.out.println(" verifying,the lead's name is  not displayed:");
		}
		
	}

}
