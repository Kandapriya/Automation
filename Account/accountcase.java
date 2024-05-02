package Account;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
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
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class accountcase extends Baseclassaccount {
     @Test
	public  void runaccount() throws IOException {
		
					
					//switch to lightning:
					try {
						driver.findElement(By.xpath("//a[@class='switch-to-lightning']")).click();
					} catch (Exception e1) {
						
					}
									
					//click to sales
					WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
					driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
					try {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']"))).click();
					} catch (NoSuchElementException e) {
						driver.findElement(By.xpath("//button[text()='View All']")).click();
					}
					
					try {
						driver.findElement(By.xpath("//p[text()='Sales']")).click();
					} catch (ElementClickInterceptedException e) {
						WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
						driver.executeScript("arguments[0].click();", sale);
					}
					
					//Access Accounts:
					try {
						driver.findElement(By.xpath("(//span[text()='Accounts'])[1]")).click();
					} catch (Exception e) {
						WebElement account = driver.findElement(By.xpath("(//span[text()='Accounts'])[1]"));
						driver.executeScript("arguments[0].click();", account);
					}
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Account-search-input']"))));
					driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Testleaf"+Keys.ENTER);
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Testleaf'])[1]"))));
					try {
						driver.findElement(By.xpath("(//a[text()='Testleaf'])[1]")).click();
					} catch (ElementClickInterceptedException e) {
						WebElement testclick = driver.findElement(By.xpath("(//a[text()='Testleaf'])[1]"));
						driver.executeScript("arguments[0].click();", testclick);
					} catch (StaleElementReferenceException e) {
						driver.navigate().refresh();
						try {
							 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Testleaf'])[1]")))).click();
						} catch (ElementClickInterceptedException e2) {
							WebElement test1 = driver.findElement(By.xpath("(//a[text()='Testleaf'])[1]"));
							driver.executeScript("arguments[0].click();", test1);
						}
					}
					
					
				//Create New Case:Add New Contact:Retrieve Case Number
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='New Case']"))));
					driver.findElement(By.xpath("//button[text()='New Case']")).click();
					driver.findElement(By.xpath("//input[@placeholder='Search Contacts...']")).click();
					driver.findElement(By.xpath("//span[@title='New Contact']")).click();
					String namec = faker.name().firstName();
					driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(namec+Keys.ENTER);
					try {
						driver.findElement(By.xpath("(//span[text()='Save'])[4]")).click();
					} catch (ElementClickInterceptedException e3) {
						WebElement savecontact = driver.findElement(By.xpath("(//span[text()='Save'])[4]"));
						driver.executeScript("arguments[0].click();", savecontact);
					}
					try {
						wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))));
					} catch (TimeoutException e4) {
						wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))));
					}
					try {//button[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']
						driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
					} catch (ElementClickInterceptedException e3) {
						WebElement savecase = driver.findElement(By.xpath("(//span[text()='Save'])[3]"));
						driver.executeScript("arguments[0].click();", savecase);
					}
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))));
					String toaster = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
					System.out.println("The case number from the toasted message :"+toaster);
					
					
					
					
					

                 //Open and Edit Case:
					wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))));
					try {
						driver.findElement(By.xpath("//span[text()='More']")).click();
					} catch (ElementClickInterceptedException e3) {
						WebElement more = driver.findElement(By.xpath("//span[text()='More']"));
						driver.executeScript("arguments[0].click();", more);
					}
					try {
						driver.findElement(By.xpath("(//span[text()='Cases'])[2]/ancestor::a")).click();
					} catch (JavascriptException e) {
						WebElement tabcase = driver.findElement(By.xpath("(//span[text()='Cases'])[2]/ancestor::a"));
						driver.executeScript("arguments[0].click();", tabcase);
					}
					//driver.findElement(By.xpath("//input[@name='Case-search-input']")).click();
					String caseno = toaster.replaceAll("[^0-9]", "");
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Case-search-input']"))));
					driver.findElement(By.xpath("//input[@name='Case-search-input']")).sendKeys(caseno+Keys.ENTER);
					try {
						WebElement caseclick1 = driver.findElement(By.xpath("(//a[contains(@class,'pLink slds-truncate outputLookupLink-500')])[1]"));
						wait.until(ExpectedConditions.visibilityOf(caseclick1)).click();
					}  catch (ElementClickInterceptedException e2) {
							WebElement clickcase = driver.findElement(By.xpath("(//a[contains(@class,'pLink slds-truncate outputLookupLink-500')])[1]"));
							driver.executeScript("arguments[0].click();", clickcase);
						}  catch (StaleElementReferenceException e) {
							driver.get(driver.getCurrentUrl());
							try {
							driver.findElement(By.xpath("(//a[contains(@class,'pLink slds-truncate outputLookupLink-500')])[1]")).click();
						}catch (Exception e1) {
							driver.findElement(By.xpath("(//a[contains(@class,'pLink slds-truncate outputLookupLink-500')])[1]")).click();
						}
						}
					
					//Update Case Details: 
					driver.findElement(By.xpath("//button[@name='Edit']")).click();
                    driver.findElement(By.xpath("//label[text()='Type']")).click();
					try {
						driver.findElement(By.xpath("//span[text()='Other']/../..")).click();
					} catch (ElementNotInteractableException e2) {
						WebElement other = driver.findElement(By.xpath("//span[text()='Other']/../.."));
						driver.executeScript("arguments[0].click();", other);
					}
					driver.findElement(By.xpath("//label[text()='Case Origin']")).click();
					driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']")).click();
					driver.findElement(By.xpath("//label[text()='Case Reason']")).click();
					driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Equipment Complexity']")).click();
					driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
					
					//Navigate to Related Tab
					try {
						driver.findElement(By.xpath("//a[text()='Related']")).click();
					} catch (ElementClickInterceptedException e1) {
						WebElement related = driver.findElement(By.xpath("//a[text()='Related']"));
						driver.executeScript("arguments[0].click();", related);
					}
					driver.findElement(By.xpath("//div[text()='New Task']/parent::a")).click();
					driver.findElement(By.xpath("//label[text()='Subject']")).click();
					driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']")).click();
					try {
						driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).click();
					} catch (ElementClickInterceptedException e) {
						WebElement datecase = driver.findElement(By.xpath("(//input[@class='slds-input'])[3]"));
						driver.executeScript("arguments[0].click();", datecase);
					}
					driver.findElement(By.xpath("//td[@class='slds-is-today']")).click();
					driver.findElement(By.xpath("//button[@title='Save']")).click();
					
					try {
						driver.findElement(By.xpath("//span[text()='Show more actions']/ancestor::button")).click();
					} catch (ElementClickInterceptedException e) {
						WebElement printview = driver.findElement(By.xpath("//span[text()='Show more actions']/ancestor::button"));
						driver.executeScript("arguments[0].click();", printview);
					}
					
					//Printable View:
//					try {
//						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[contains(@class,'down-trigger_click slds-button_last ov')]")))).click();
//					} catch (ElementClickInterceptedException e) {
//						WebElement printdropdown = driver.findElement(By.xpath("//li[contains(@class,'down-trigger_click slds-button_last ov')]"));
//						driver.executeScript("arguments[0].click();", printdropdown);
//					}
			       try {
			    	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Printable View']")))).click();
				} catch (ElementClickInterceptedException e) {
					WebElement printclick = driver.findElement(By.xpath("//span[text()='Printable View']"));
					driver.executeScript("arguments[0].click();", printclick);
				}
					
					//Adjust Zoom Level:
			       wait.until(ExpectedConditions.numberOfWindowsToBe(2));

					 Set<String> wh=driver.getWindowHandles();
					 System.out.println("The size of window:"+wh.size());
                      System.out.println(wh+"Parent WIndow :"+driver.getTitle());
					 List<String> viewpage=new ArrayList<String>(wh);
					 try {
						driver.switchTo().window(viewpage.get(1));
					} catch (IndexOutOfBoundsException e1) {
						driver.switchTo().window(viewpage.get(1));
					}
					 String title = driver.getTitle();
						System.out.println("Title of child window:"+title);

					
					 
					
					 //To set the zoom level --> 0.7 - 70% zoom level
					 try {
						WebElement snapprint = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//html[@class=' ext-strict']"))));
						driver.executeScript("document.body.style.zoom='2'");
					} catch (NoSuchElementException e) {
						driver.executeScript("document.body.style.zoom='2'");
					}
					
					 
					//Take Snapshot:
					// WebElement snapprint = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//html[@class=' ext-strict']"))));
					 File scr=driver.getScreenshotAs(OutputType.FILE);
					File des=new File("./snapshot/printviewaccount.png");
					FileUtils.copyFile(scr, des);
					
					

	}

}
