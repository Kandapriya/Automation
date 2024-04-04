package Leads;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

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
		
		//click to new lead
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//java scrpit to click lead
		
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click()", lead);
		driver.findElement(By.xpath("(//a[@title='kandhapriya'])[1]")).click();
		//javascrpit to click dropdown
		
		WebElement dp = driver.findElement(By.xpath("//span[text()='Show more actions']"));
		driver.executeScript("arguments[0].click()", dp);
		driver.findElement(By.xpath("//span[text()='Edit']")).click();
		
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
		String editname = driver.findElement(By.xpath("//lightning-formatted-name[text()='Mrs.  Ganesh']")).getText();
		System.out.println(" the lead's name is updated as "+editname);
}
}
