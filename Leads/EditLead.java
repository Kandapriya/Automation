package Leads;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditLead {

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
		
		//replacing Thread.sleep() with explicit waits
		WebElement searchedit = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(searchedit));
		searchedit.sendKeys("kandhapriya"+Keys.ENTER);
		
		WebElement leadsname = driver.findElement(By.xpath("//a[@title='kandhapriya']"));
		wait.until(ExpectedConditions.visibilityOf(leadsname));
		driver.executeScript("arguments[0].click()",leadsname );
		
		//javascrpit to click dropdown
		//replacing Thread.sleep() with explicit waits
		WebElement dp = driver.findElement(By.xpath("(//span[text()='Show more actions']/..)[2]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(dp));
		driver.executeScript("arguments[0].click()", dp);
		//replacing Thread.sleep() with explicit waits
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']/.."));
		
		driver.executeScript("arguments[0].click()", edit);
		
		//Update Information: Change the First Name to 'Ganesh'.
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Ganesh");
		
		//Modify Lead Status: Set the Lead Status to 'Working-Contacted'.
		WebElement status = driver.findElement(By.xpath("//button[@data-value='Open - Not Contacted']"));
		driver.executeScript("arguments[0].click()", status);
		WebElement status1 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']"));
		driver.executeScript("arguments[0].click()", status1);
		
		//Save Changes: Click 'Save'
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
		//Verification: Confirm that the lead's name is updated as 'Ganesh Kumar'.
		String verificationMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage sld')]")).getText();
		System.out.println(verificationMessage);

		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-aura-class='forceToastMessage']")));
		//String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/..")).getText();
		if (verificationMessage.contains("Ganesh")) {
			System.out.println(" verifying,the lead's name is displayed:"+verificationMessage);
		} else {
			System.out.println(" verifying,the lead's name is  not displayed:");
		}
		

		}
		
		
}

