package Lead2Opportunity;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

public class leademail {

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
				driver.executeScript("arguments[0].click()", lead);
				driver.findElement(By.xpath("//a[@title='New']")).click();
				
				//creating new lead
				
				driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
				driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
				Faker faker=new Faker();
				String lastName = faker.name().lastName();
				String comname = faker.company().name();
				
				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName );
				driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(comname);
				driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
				
//				//Verify Lead Details:
//				boolean leadpresent = driver.findElement(By.xpath("//lightning-formatted-name[@slot='primaryField']")).isDisplayed();
//				Assert.assertTrue(leadpresent );
//			    System.out.println("The lead name is present as kandhapriya is :"+leadpresent );
//			    boolean compresent = driver.findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).isDisplayed();
//			    Assert.assertTrue(leadpresent );
//			    System.out.println("The company name is present as TESTLEAF is :"+compresent );
			    
			  //Verify Lead Details:
			   String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-name")).getText();
		        System.out.println(leadt);
			   String actualname="Mrs. " + lastName;
			    Assert.assertEquals(leadt, actualname);
			    String comlead = driver.findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).getText();
			    System.out.println(comlead);
			    String actualcomlead=comname;
			    Assert.assertEquals(comlead , actualcomlead);
			    
			    //Create To-Do List for Email:
			  //Add Email to To-Do List:
				driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
				driver.findElement(By.xpath("//span[text()='Add Email to To Do List']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
				driver.executeScript("arguments[0].click();", subject);
				WebElement duedate = driver.findElement(By.xpath("(//input[@class='slds-input'])[5]"));
				LocalDate currentDate = LocalDate.now();
				System.out.println(currentDate);
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String date = currentDate.format(dateFormat);
				System.out.println(date);
				duedate.sendKeys(date);
				//driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
				driver.findElement(By.xpath("//a[@class='select']")).click();
				driver.findElement(By.xpath("//a[@title='In Progress']")).click();
//				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();


	}

}
