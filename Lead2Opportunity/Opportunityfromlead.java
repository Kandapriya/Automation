package Lead2Opportunity;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Exp;
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

import com.github.javafaker.Faker;

import net.bytebuddy.asm.MemberSubstitution.Current;

public class Opportunityfromlead {

	public static void main(String[] args) throws IOException {
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
		        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='View All']")))).click();
		             } catch (NoSuchElementException e) {
		            	 driver.findElement(By.xpath("//button[text()='View All']")).click();
		              } catch(StaleElementReferenceException e) {
		            	  driver.get(driver.getCurrentUrl());
		            	  driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		            	  driver.findElement(By.xpath("//button[text()='View All']")).click();
		              }

		        try {
					driver.findElement(By.xpath("//p[text()='Sales']")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
					driver.executeScript("arguments[0].click();", sale);
				}
		        
		        //creating new lead
				WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
				driver.executeScript("arguments[0].click()", lead);
				driver.findElement(By.xpath("//a[@title='New']")).click();
				driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
				driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
				Faker faker=new Faker();
				String lastName = faker.name().lastName();
				String comname = faker.company().name();
				WebElement leadname = driver.findElement(By.xpath("//input[@name='lastName']"));
				leadname.sendKeys(lastName);
				System.out.println("Convert Lead into Opportunity: THE LEAD IS : "+lastName);
				driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(comname);
				driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	
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
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='Status changed successfully.']"))));
				WebElement submitdropdown = driver.findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]"));
				
				wait.until(ExpectedConditions.elementToBeClickable(submitdropdown));
				//driver.executeScript("arguments[0].click();", submitdropdown);
				try {
					submitdropdown.click();
				} catch (Exception e) {
					driver.executeScript("arguments[0].click();", submitdropdown);
				}
				try {
					driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
					driver.executeScript("arguments[0].click()", dropDown2);
				}catch (StaleElementReferenceException e) {
					driver.navigate().refresh();
					try {
						driver.findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]")).click();
						driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
					} catch (ElementClickInterceptedException e1) {
						WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						driver.executeScript("arguments[0].click()", dropDown2);
					}
				}
				//convert 2
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='modal-container slds-modal__container']"))));
                WebElement convertlead1 = driver.findElement(By.xpath("//button[text()='Convert']"));
				wait.until(ExpectedConditions.elementToBeClickable(convertlead1));
			     //driver.executeScript("arguments[0].click();", convertlead1);
				try {
					 driver.findElement(By.xpath("//button[text()='Convert']")).click();
					
				} catch (Exception e) {
					 WebElement elementcon = driver.findElement(By.xpath("//button[text()='Convert']"));
					driver.executeScript("arguments[0].click();", elementcon);
				}
				try {
					WebElement convertopp = driver.findElement(By.xpath("//button[text()='Convert']"));
					//wait.until(ExpectedConditions.elementToBeClickable(convertopp));
					convertopp.click();
				} catch (ElementClickInterceptedException e) {
					WebElement convert1 = driver.findElement(By.xpath("//button[text()='Convert']"));
					driver.executeScript("arguments[0].click();",convert1);
				}catch(TimeoutException e) {
					WebElement convert1 = driver.findElement(By.xpath("//button[text()='Convert']"));
					driver.executeScript("arguments[0].click();",convert1);
				}
				//2nd try to convert
				try {
					driver.findElement(By.xpath("//button[text()='Go to Leads']")).click();
					} catch (Exception e3) {
					driver.get(driver.getCurrentUrl());
					try {
						driver.findElement(By.xpath("//span[text()='Show more actions']/parent::button")).click();
					} catch (Exception e1) {
						WebElement showMore = driver.findElement(By.xpath("//span[text()='Show more actions']/parent::button"));
						driver.executeScript("arguments[0].click()", showMore);
					} 
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
					} catch (ElementClickInterceptedException e1) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						driver.executeScript("arguments[0].click()", dropDown2);
					} catch (ElementNotInteractableException e1) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						driver.executeScript("arguments[0].click()", dropDown2);
					} 
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']")));
						driver.findElement(By.xpath("//button[text()='Convert']")).click();			
					} catch (Exception e6) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']")));
						WebElement convert3 = driver.findElement(By.xpath("//button[text()='Convert']"));
						driver.executeScript("arguments[0].click()", convert3);
					}
				}
				
				
				//Snapshot
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='modal-container slds-modal__container']"))));
//				WebElement snaplead = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
//				wait.until(ExpectedConditions.visibilityOf(snaplead));
				File scr=driver.getScreenshotAs(OutputType.FILE);
				File des=new File("./snapshot/leadconvert.png");
				FileUtils.copyFile(scr, des);

				//Close Pop-up:
				try {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"))));
				} catch (StaleElementReferenceException e3) {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"))));
				}
				try {
					driver.findElement(By.xpath("//button[@title='Close this window']")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement closelead = driver.findElement(By.xpath("//button[@title='Close this window']"));
					driver.executeScript("arguments[0].click();",closelead);
				}

               //Verify that the lead is removed from the lead list.
				WebElement leadverify = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
				wait.until(ExpectedConditions.elementToBeClickable(leadverify));
				driver.executeScript("arguments[0].click()", leadverify);
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"))));
				driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(lastName +Keys.ENTER);
				WebElement verify = driver.findElement(By.xpath("//div[@class='uiScroller scroller-wrapper scroll-bidirectional native']"));
				String veirfyname = verify.getText();
				//System.out.println(veirfyname);
				//String expected=lastName;
				if (veirfyname.contains(lastName)) {
					System.out.println("The lead " + lastName + " is not convert to opportunity ");
				} else {
					System.out.println("The lead "+ lastName +" is convert to opportunity ");
				}
				
				//Open the opportunity converted from the lead (company name).
				//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='uiScroller scroller-wrapper scroll-bidirectional native']"))));
				WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
				driver.executeScript("arguments[0].click();", opportunity);
				
				//Search and Open Opportunity:
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"))));
				driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).click();
				driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(comname+Keys.ENTER);
				try {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='"+ comname +"-']")))).click();
				}catch (StaleElementReferenceException e) {
					WebElement oppclick = driver.findElement(By.xpath("//a[@title='"+ comname +"-']"));
					driver.executeScript("arguments[0].click();", oppclick);
				}catch (ElementClickInterceptedException e2) {
					WebElement opportu = driver.findElement(By.xpath("//a[@title='"+comname+"-']"));
					driver.executeScript("arguments[0].click();", opportu);
                   }catch (ElementNotInteractableException e2) {
					WebElement opportunity1 = driver.findElement(By.xpath("//a[@title='"+comname+"-']"));
					opportunity1.click();
				}
				
				//Select Price Book:
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]"))));
				driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")).click();
				driver.findElement(By.xpath("//a[@title='Choose Price Book']")).click();
				driver.findElement(By.xpath("(//span[text()='Save']/..)[2]")).click();
               
				
				//Add Products:
				try {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")))).click();
				} catch (StaleElementReferenceException e1) {
					driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")).click();
				}
				
				driver.findElement(By.xpath("//a[@title='Add Products']")).click();
				
                //Search and Display Products:
				
				//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='modal-container slds-modal__container']")));
				driver.findElement(By.xpath("//input[@title='Search Products']")).click();
				//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Products']"))));
				driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA"+Keys.ENTER);
                try {
					
					driver.findElement(By.xpath("//span[text()='Search Products']")).click();
				} catch (ElementClickInterceptedException e3) {
					WebElement sla1 = driver.findElement(By.xpath("//span[text()='Search Products']"));
					driver.executeScript("arguments[0].click()", sla1);
				}catch (ElementNotInteractableException e4) {
					WebElement sla1 = driver.findElement(By.xpath("//span[text()='Search Products']"));
					driver.executeScript("arguments[0].click()",sla1);
				}
				
				//print the product
				WebElement add;
				try {
					add = driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
					add.click();
				} catch (Exception e) {
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
			     driver.findElement(By.xpath("//div[@class='undefined hideSelection hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr[1]/td[2]")).click();
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[text()='SLA: Gold']/ancestor::th/following-sibling::td)[1]"))));
				driver.findElement(By.xpath("(//a[text()='SLA: Gold']/ancestor::th/following-sibling::td)[1]")).click();
				driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys("2"+Keys.ENTER);
				// driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys(Keys.ENTER);
                driver.findElement(By.xpath("(//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td)[1]")).click();
				driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td//input")).sendKeys("10"+Keys.ENTER);
				
				driver.findElement(By.xpath("(//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td)[1]")).click();
			
				driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td//input")).sendKeys("1"+Keys.ENTER);

				driver.findElement(By.xpath("(//a[text()='SLA: Silver']/ancestor::th/following-sibling::td)[1]")).click();
				driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td//input")).sendKeys("5"+Keys.ENTER);

                 
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'-notify--toast forceToastMessage')]")));
				

				//Upload Sample File:
				 Actions contname=new Actions(driver);
				    try {
						contname.scrollToElement(driver.findElement(By.xpath("//span[text()='Upload Files']"))).perform();
					} catch (NoSuchElementException e) {
						contname.scrollToElement(driver.findElement(By.xpath("//span[text()='Upload Files']"))).perform();
					}
				WebElement upload = driver.findElement(By.xpath("//input[@type='file']"));
				
				try {
					wait.until(ExpectedConditions.elementToBeClickable(upload));
					
					upload.sendKeys("D:\\2 INTERNSHIP TESTING\\AUTOMATION\\DAY7.txt");
				} catch (Exception e) {
					upload.sendKeys("D:\\2 INTERNSHIP TESTING\\AUTOMATION\\DAY7.txt");
				}
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Done']/.."))));
				driver.findElement(By.xpath("//span[text()='Done']/..")).click();
				driver.findElement(By.xpath("//button[@title='Close this window']")).click();

				//Schedule Meeting Event:
				try {
					contname.scrollToElement(driver.findElement(By.xpath("(//*[text()='New Event'])[4]"))).perform();
				} catch (NoSuchElementException e) {
					contname.scrollToElement(driver.findElement(By.xpath("(//*[text()='New Event'])[4]"))).perform();
				}
				try {
					driver.findElement(By.xpath("(//button[@title='More Actions'])[5]")).click();
					} catch (ElementClickInterceptedException e) {
					WebElement newevent = driver.findElement(By.xpath("(//button[@title='More Actions'])[5]"));
					driver.executeScript("arguments[0].click();", newevent);	
				} 
				driver.findElement(By.xpath("//span[text()='View Calendar']")).click();
				//view calender
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> windowcalendar = driver.getWindowHandles();
				 List<String> viewcalendar=new ArrayList<String>(windowcalendar);
				 driver.switchTo().window(viewcalendar.get(1));
				 wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button[text()='New Event']"))));
				 driver.findElement(By.xpath("//button[text()='New Event']")).click();
				 //wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button[text()='New Event']"))));
				 driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Meeting']")).click();
				 WebElement duedate = driver.findElement(By.xpath("//*[text()='Start']/following::input[@class='slds-input']"));
				 WebElement endDate = driver.findElement(By.xpath("//*[text()='End']/following::input[@class='slds-input']"));
				 duedate.clear();
					LocalDate currentDate = LocalDate.now();
					System.out.println(currentDate);
					DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
					String date = currentDate.format(dateFormat);
					System.out.println(date);
					LocalDate nextDay = currentDate.plusDays(1);
					String nextdate1= nextDay.format(dateFormat);
					System.out.println(nextdate1);
					duedate.clear();
					duedate.sendKeys(nextdate1);
					endDate.clear();
					endDate.sendKeys(nextdate1);
					driver.findElement(By.xpath("//textarea[@aria-describedby='quickTextKeyboardTip']")).sendKeys("New event for opportunity");
					 driver.findElement(By.xpath("//button[@title='Save']")).click();
					 driver.close();
				

	}

}
