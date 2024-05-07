package Lead2Opportunity;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class leadToopportunity extends Baseclasslead2opp{
	
     @Test
	  public void main() throws IOException {
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
			
            //Verify Lead Details:
		   String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-name")).getText();
	        System.out.println(leadt);
		   String actualname="Mrs. " + lastName;
		    Assert.assertEquals(leadt, actualname);
		    String comlead = driver.findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).getText();
		    System.out.println(comlead);
		    String actualcomlead=comname;
		    Assert.assertEquals(comlead , actualcomlead);
		    
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
			driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
			
			//Send Email to Lead:
             WebElement sendemail = driver.findElement(By.xpath("//button[@title='Email']"));
			driver.executeScript("arguments[0].click();", sendemail);
			WebElement mailid = driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]"));
			wait.until(ExpectedConditions.visibilityOf(mailid));
			mailid.sendKeys("kpriya@testleaf.com");
			WebElement sub = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
			wait.until(ExpectedConditions.visibilityOf(sub));
			sub.sendKeys("ManageLeads for END TO END");
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); 
			WebElement compose = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']"));
			wait.until(ExpectedConditions.visibilityOfAllElements(compose));
			compose.sendKeys("This story covers the steps to update the email status to 'Completed END TO END\r\n");
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//span[text()='Send']")).click();
			
			//Change Lead Status:
			WebElement emailstatus;
			emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions']//ancestor::a)[2]"));
			driver.executeScript("arguments[0].click();", emailstatus);
			WebElement click1 = driver.findElement(By.xpath("(//div[@title='Change Status']/parent::a)[2]"));
			driver.executeScript("arguments[0].click();",click1);
		    WebElement statuschange= driver.findElement(By.xpath("//a[@class='select']"));
			try {
				statuschange.click();
			} catch (StaleElementReferenceException e) {
				//driver.get(driver.getCurrentUrl());
				try {
					driver.findElement(By.xpath("//a[@class='select']")).click();
			}catch (StaleElementReferenceException e1) {
				driver.findElement(By.xpath("//a[@class='select']")).click();
			}
			}
			driver.findElement(By.xpath("//a[text()='Completed']")).click();
			driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
			
			//Navigate to the lead's details.
			try {
				driver.findElement(By.xpath("//li[@title='Details']")).click();
			} catch (ElementClickInterceptedException e) {
				WebElement detail = driver.findElement(By.xpath("//li[@title='Details']"));
				driver.executeScript("arguments[0].click();",detail);
			}
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
//			WebElement snaplead = driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"));
//			wait.until(ExpectedConditions.visibilityOf(snaplead));
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
			if (veirfyname.contains(lastName)) {
				System.out.println("The lead " + lastName + " is not convert to opportunity ");
			} else {
				System.out.println("The lead "+ lastName +" is convert to opportunity ");
			}
			
			//Open the opportunity converted from the lead (company name).
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
			}catch (JavascriptException e) {
				WebElement oppclick = driver.findElement(By.xpath("//a[@title='"+ comname +"-']"));
				driver.executeScript("arguments[0].click();", oppclick);
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
				wait.until(ExpectedConditions.visibilityOf(upload));
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
			try {
				driver.findElement(By.xpath("//span[text()='View Calendar']")).click();
			} catch (ElementClickInterceptedException e) {
				WebElement vcal = driver.findElement(By.xpath("//span[text()='View Calendar']"));
				driver.executeScript("arguments[0].click();", vcal);
			}
			
			//view calender
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowcalendar = driver.getWindowHandles();
			 List<String> viewcalendar=new ArrayList<String>(windowcalendar);
			 driver.switchTo().window(viewcalendar.get(1));
			 wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button[text()='New Event']"))));
			 driver.findElement(By.xpath("//button[text()='New Event']")).click();
			 try {
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
			} catch (NoSuchElementException e) {
				driver.get(driver.getCurrentUrl());
				driver.findElement(By.xpath("//button[text()='New Event']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
			}
			 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Meeting']")).click();
			 WebElement duedate1 = driver.findElement(By.xpath("//*[text()='Start']/following::input[@class='slds-input']"));
			 WebElement endDate = driver.findElement(By.xpath("//*[text()='End']/following::input[@class='slds-input']"));
			
				LocalDate currentDate1 = LocalDate.now();
				System.out.println(currentDate1);
				DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
				String date1 = currentDate.format(dateFormat1);
				System.out.println(date1);
				LocalDate nextDay = currentDate.plusDays(1);
				String nextdate1= nextDay.format(dateFormat1);
				System.out.println(nextdate1);
				duedate1.clear();
				duedate1.sendKeys(nextdate1);
				endDate.clear();
				endDate.sendKeys(nextdate1);
				driver.findElement(By.xpath("//textarea[@aria-describedby='quickTextKeyboardTip']")).sendKeys("New event for opportunity");
				 driver.findElement(By.xpath("//button[@title='Save']")).click();
				 driver.close();
		

	}

}
