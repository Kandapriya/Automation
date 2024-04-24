package Leads;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		driver.executeScript("arguments[0].click();", lead);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"))));
		driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys("kandhapriya"+Keys.ENTER);
		
		WebElement leadsname = driver.findElement(By.xpath("//a[@title='kandhapriya']"));
        wait.until(ExpectedConditions.visibilityOf(leadsname));
		driver.executeScript("arguments[0].click()",leadsname );
		
		//Edit Lead Status
		driver.findElement(By.xpath("//li[@title='Details']")).click();
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
		
		//Check Status Completion:
		toleadstatus.scrollToElement(driver.findElement(By.xpath("//a[@title='Working - Contacted']"))).perform();
		WebElement complete = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']/.."));
		driver.executeScript("arguments[0].click();", complete);
		
		//Convert Lead:
		WebElement submitdropdown = driver.findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]"));
		wait.until(ExpectedConditions.elementToBeClickable(submitdropdown));
		//driver.executeScript("arguments[0].click();", submitdropdown);
		try {
			submitdropdown.click();
		} catch (Exception e) {
			driver.executeScript("arguments[0].click();", submitdropdown);
		}
		
//		WebElement conve1 = driver.findElement(By.xpath("//span[text()='Convert']/parent::a"));
//		wait.until(ExpectedConditions.elementToBeClickable(conve1));
//		//driver.executeScript("arguments[0].click();", conve1);
//		conve1.click();
		try {
			driver.findElement(By.xpath("//span[text()='Convert']")).click();
		} catch (ElementClickInterceptedException e) {
			WebElement dropDown2 = driver.findElement(By.xpath("//span[text()='Convert']"));
			driver.executeScript("arguments[0].click()", dropDown2);
		}catch (StaleElementReferenceException e) {
			driver.navigate().refresh();
			try {
				driver.findElement(By.xpath("//span[text()='Convert']")).click();
			} catch (ElementClickInterceptedException e1) {
				WebElement dropDown2 = driver.findElement(By.xpath("//span[text()='Convert']"));
				driver.executeScript("arguments[0].click()", dropDown2);
			}
		}

		WebElement convertlead1 = driver.findElement(By.xpath("//button[text()='Convert']"));
		wait.until(ExpectedConditions.elementToBeClickable(convertlead1));
		//driver.executeScript("arguments[0].click();", convertlead1);
		try {
			convertlead1.click();
		} catch (Exception e) {
			driver.executeScript("arguments[0].click();", convertlead1);
		}
		try {
			WebElement convert = driver.findElement(By.xpath("//button[text()='Convert']"));
			wait.until(ExpectedConditions.elementToBeClickable(convert));
			convert.click();
		} catch (ElementClickInterceptedException e) {
			WebElement convert1 = driver.findElement(By.xpath("//button[text()='Convert']"));
			driver.executeScript("arguments[0].click();",convert1);
		}catch(TimeoutException e) {
			WebElement convert1 = driver.findElement(By.xpath("//button[text()='Convert']"));
			driver.executeScript("arguments[0].click();",convert1);
		}
		//Snapshot
		
		WebElement snaplead = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
		wait.until(ExpectedConditions.visibilityOf(snaplead));
		File scr=driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./snapshot/leadconvert.png");
		FileUtils.copyFile(scr, des);
		
		//Close Pop-up:
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@title='Close this window']")));
		try {
			driver.findElement(By.xpath("//button[@title='Close this window']")).click();
		} catch (ElementClickInterceptedException e) {
			WebElement closelead = driver.findElement(By.xpath("//button[@title='Close this window']"));
			driver.executeScript("arguments[0].click();",closelead);
		}
	}

}
