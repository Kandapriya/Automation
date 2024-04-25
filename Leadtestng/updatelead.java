package Leadtestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class updatelead extends BaseclassLead{
   
	@Test(dependsOnMethods = "Leadtestng.Createlead.runcreatelead")
	public void runeditlead() {
		
	//java scrpit to click lead
	//replacing Thread.sleep() with explicit waits
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchedit = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(searchedit));
		Faker faker=new Faker();
		String name = faker.name().firstName();
	//	searchedit.sendKeys(name+Keys.ENTER);
		
        //javascrpit to click dropdown
		//replacing Thread.sleep() with explicit waits
		String printeditlead = driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread forceInlineEditCell'])[1]/parent::th")).getText();
		System.out.println("The leadname going to edit/update is :"+printeditlead);
		WebElement dp = driver.findElement(By.xpath("(//span[text()='Show Actions'])[1]/ancestor::a"));
		wait.until(ExpectedConditions.visibilityOfAllElements(dp));
		driver.executeScript("arguments[0].click()", dp);
		//replacing Thread.sleep() with explicit waits
		WebElement edit = driver.findElement(By.xpath("//a[@title='Edit']"));
		
		driver.executeScript("arguments[0].click()", edit);
		
		//Update Information: Change the First Name to 'Ganesh'.
		
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(name);
		
		//Modify Lead Status: Set the Lead Status to 'Working-Contacted'.
		WebElement status = driver.findElement(By.xpath("//label[text()='Lead Status']"));
		driver.executeScript("arguments[0].click()", status);
		WebElement status1 = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']"));
		driver.executeScript("arguments[0].click()", status1);
		
		//Save Changes: Click 'Save'
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
		//Verification: Confirm that the lead's name is updated as 'Ganesh Kumar'.
		String verificationMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage sld')]")).getText();
		System.out.println(verificationMessage);

		
		if (verificationMessage.contains(name)) {
			System.out.println(" verifying,the lead's name is displayed:"+verificationMessage);
		} else {
			System.out.println(" verifying,the lead's name is  not displayed:");
		}
		


	}

}
