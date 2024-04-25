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

public class Deletelead extends BaseclassLead {
   
	@Test(dependsOnMethods = "Leadtestng.updatelead.runeditlead")
	public  void rundeletelead() {
		
        //java scrpit to click lead
		//replacing Thread.sleep() with explicit waits
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchedit = driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"));
		wait.until(ExpectedConditions.visibilityOf(searchedit));
		Faker faker=new Faker();
		String dname = faker.name().firstName();
		//searchedit.sendKeys(dname+Keys.ENTER);
		
       //javascrpit to click dropdown
		//replacing Thread.sleep() with explicit waits
		WebElement dp = driver.findElement(By.xpath("(//span[text()='Show Actions'])[1]/ancestor::a"));
		wait.until(ExpectedConditions.visibilityOfAllElements(dp));
		driver.executeScript("arguments[0].click()", dp);
		//replacing Thread.sleep() with explicit waits
		WebElement delete = driver.findElement(By.xpath("//a[@title='Delete']"));
		driver.executeScript("arguments[0].click()", delete);
		
		//Update Information: Change the First Name to 'Ganesh'.
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		//Verification: Confirm that the lead's name is updated as 'Ganesh Kumar'.
		String verificationMessage = driver.findElement(By.xpath("//span[contains(@class,'toastMessage sld')]")).getText();
		System.out.println(verificationMessage);
          if (verificationMessage.contains("Ganesh")) {
			System.out.println(" verifying,the lead's name is displayed:"+verificationMessage);
		} else {
			System.out.println(" verifying,the lead's name is  not displayed:");
		}
		

	}

}
