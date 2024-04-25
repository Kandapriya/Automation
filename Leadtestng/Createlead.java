package Leadtestng;

import java.time.Duration;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class Createlead extends BaseclassLead{
	
	
     @Test
	public  void runcreatelead() throws InterruptedException {
			
			//java scrpit to click lead
			driver.findElement(By.xpath("//a[@title='New']")).click();
			
			//creating new lead
			
			driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
			driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
			name = faker.name().firstName();
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(name);
			System.out.println("The lead name is: "+name);
			cname = faker.company().name();
			driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(cname);
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/..")).getText();
			if (leadt.contains(name)) {
				System.out.println(" verifying,the lead's name is displayed: "+leadt);
			} else {
				System.out.println(" verifying,the lead's name is  not displayed:");
			}
     	
			
			
     }
    
	}
     

