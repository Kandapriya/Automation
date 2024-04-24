package Opportunity;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Enter;

public class Productopportunity {

	public static void main(String[] args) throws InterruptedException {
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
					WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
					driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
					try {
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='slds-button'])[2]"))).click();
					} catch (NoSuchElementException e) {
						driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
					}
					

					try {
						driver.findElement(By.xpath("//p[text()='Sales']")).click();
					} catch (ElementClickInterceptedException e) {
						WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
						driver.executeScript("arguments[0].click();", sale);
					}
					
					//Open Opportunities
					WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
					driver.executeScript("arguments[0].click();", opportunity);
					
					//Search and Open Opportunity:
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"))));
					driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Testleaf"+Keys.ENTER);
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]")))).click();
					}catch (StaleElementReferenceException e) {
						WebElement testleaf1 = driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]"));
						testleaf1.click();
					} catch (ElementClickInterceptedException e1) {
						WebElement testleaf1 = driver.findElement(By.xpath("(//a[text()='Testleaf-'])[1]"));
						driver.executeScript("arguments[0].click();", testleaf1);
					}
					
					
					//Check Qualification Stage
					String stage = driver.findElement(By.xpath("//a[@title='Qualification']")).getText();
					if (stage.contains("stage complete")) {
						System.out.println("The qualification stage is marked as completed");
						
					} else {
                         System.out.println("The qualification stage is marked as not completed");
					}
					
					WebElement stagecomplete = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']/.."));
					wait.until(ExpectedConditions.visibilityOf(stagecomplete));
					driver.executeScript("arguments[0].click();", stagecomplete);
					
					//Select Price Book:
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Show actions for Products']/../../.."))));
					driver.findElement(By.xpath("//span[text()='Show actions for Products']/../../..")).click();
					driver.findElement(By.xpath("//a[@title='Choose Price Book']")).click();
					driver.findElement(By.xpath("(//span[text()='Save']/..)[2]")).click();
					
					//Add Products:
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]")))).click();
					} catch (StaleElementReferenceException e1) {
						driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]")).click();
					}
					
					driver.findElement(By.xpath("//a[@title='Add Products']")).click();
					
                    //Search and Display Products:
					
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Products']"))));
					driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA"+Keys.ENTER);
					
					try {
						driver.findElement(By.xpath("//input[@title='Search Products']")).click();
					} catch (ElementClickInterceptedException e1) {
						WebElement slaclick = driver.findElement(By.xpath("//input[@title='Search Products']"));
						driver.executeScript("arguments[0].click();", slaclick);
					}
					//SLA InProduct clicking
					try {
						wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]")))).click();
					} catch (TimeoutException e) {
					driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]")).click();
					}
					//print the product
					WebElement add;
					try {
						add = driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
						add.click();
					} catch (ElementNotInteractableException e) {
						add = driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
						driver.executeScript("arguments[0].click();", add);	
					}
					 wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"))));
						List<WebElement> colvalue = driver.findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"));
						 int productsize = colvalue.size();
						   System.out.println("col size is :"+productsize);
						for (int i = 0; i < colvalue.size(); i++) {
						 String proname = colvalue.get(i).getText();
						    System.out.println("the product names for the search results SLA"+proname);						
						} 
				
					//Select Products:
					try {
						driver.findElement(By.xpath("//span[text()='Select 4 items']/../..")).click();
					} catch (ElementClickInterceptedException e) {
						WebElement select = driver.findElement(By.xpath("//span[text()='Select 4 items']/../.."));
						select.click();
					}
					driver.findElement(By.xpath("//button[@title='Next']")).click();
				   //div[@class='undefined hideSelection hideRLAColumn forceListViewManagerGrid']//div/table/thead/tr/th/div
					
					driver.findElement(By.xpath("//div[@class='undefined hideSelection hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr[1]/td[2]")).click();
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td"))));
					

					
					driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td")).click();
					driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys("2"+Keys.ENTER);
					// driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys(Keys.ENTER);
                    driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td")).click();
					driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td//input")).sendKeys("10"+Keys.ENTER);
					
					driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td")).click();
				
					driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td//input")).sendKeys("1"+Keys.ENTER);

					driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td")).click();
					driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td//input")).sendKeys("5"+Keys.ENTER);

                     
					driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'-notify--toast forceToastMessage')]")));
					
					//View All Products:
					Actions viewall=new Actions(driver);
					viewall.moveToElement(driver.findElement(By.xpath("(//span[text()='View All']/parent::div)[1]"))).perform();
					
					WebElement view = driver.findElement(By.xpath("(//span[text()='View All']/parent::div)[1]"));
					wait.until(ExpectedConditions.visibilityOf(view));
					driver.executeScript("arguments[0].click();", view);
					
                  //Retrieve Product Details:
					List<WebElement> drop = driver.findElements(By.xpath("(//table)[2]/tbody/tr/td//div[@data-aura-class='forceVirtualAction']"));
				      int columnsize=drop.size();
				    System.out.println("col size is :"+columnsize);
				    for(int i=0;i<drop.size();i++) {
				    //Thread.sleep(8000);
				    drop.get(i).click();
				   
					WebElement edit = driver.findElement(By.xpath("(//a[@title='Edit'])["+(i+1)+"]"));
					edit.click();
					//driver.executeScript("arguments[0].click();", edit);
					
					String code = driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.ProductCode']")).getText();
					String proname = driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.OpportunityLineItem.Product2Id']")).getText();
					System.out.println("The product code is :" + code + "   productname is  :"+  proname);
					WebElement close = driver.findElement(By.xpath("//span[text()='Close this window']"));
					driver.executeScript("arguments[0].click();", close);
					
					}
	}

}
