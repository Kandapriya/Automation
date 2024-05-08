package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import freemarker.core.ReturnInstruction.Return;

public class OpportunityselectPage extends OpportunityPage {
	
	public OpportunityselectPage Pricebook() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]"))));
			driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")).click();
			reportStep("pass", "select pricebook widget is success");
		} catch (Exception e) {
			reportStep("fail", "select pricebook widget is not success");
		}
		return this;
	}
	public OpportunityselectPage choosepricebook() {
		try {
			driver.findElement(By.xpath("//a[@title='Choose Price Book']")).click();
			reportStep("pass", "choose price book is success");
		} catch (Exception e) {
			reportStep("fail", "choose price book is not success");
		}
		return this;
		
	}
	public OpportunityselectPage savePricebook() {
		try {
			driver.findElement(By.xpath("(//span[text()='Save']/..)[2]")).click();
			reportStep("pass", "save price book is success");
		} catch (Exception e) {
			reportStep("fail", "save price book is not success");
		}
		return this;
	}
	
	public OpportunityselectPage addproduct() {
		try {
			try {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")))).click();
			} catch (StaleElementReferenceException e1) {
				driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")).click();
			}
			reportStep("pass", "choose add productc widget is success");
		} catch (Exception e) {
			reportStep("fail", "choose add product widget is not success");
		}
		return this;
	}
	public OpportunityselectPage addProduct2() {
		try {
			driver.findElement(By.xpath("//a[@title='Add Products']")).click();
			reportStep("pass", "select the add productc is success");
		} catch (Exception e) {
			reportStep("fail", "select the add productc is not success");
		}
		return this;
		
	}
	
	public OpportunityselectPage SLAsearch() {
		try {
			driver.findElement(By.xpath("//input[@title='Search Products']")).click();
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Products']"))));
			driver.findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA"+Keys.ENTER);
			reportStep("pass", "Enter the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "Enter the SLA product is not success");
		}
       return this;
	}
	
	public OpportunityselectPage clickSLAsearch() {
     try {
		try {
				
				driver.findElement(By.xpath("//span[text()='Search Products']")).click();
			} catch (ElementClickInterceptedException e3) {
				WebElement sla1 = driver.findElement(By.xpath("//span[text()='Search Products']"));
				driver.executeScript("arguments[0].click()", sla1);
			}catch (ElementNotInteractableException e4) {
				WebElement sla1 = driver.findElement(By.xpath("//span[text()='Search Products']"));
				driver.executeScript("arguments[0].click()",sla1);
			}
		reportStep("pass", "search the SLA product is success");
	} catch (Exception e) {
		reportStep("fail", "search the SLA product is not success");
	}
       return this;
		
	}
	
    public OpportunityselectPage clickSLA() {
    	try {
			WebElement add;
			try {
				add = driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
				add.click();
			} catch (Exception e) {
				add = driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
				driver.executeScript("arguments[0].click();", add);	
			}
			reportStep("pass", " click the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "click the SLA product is not success");
		}
		return this;
    }
    public OpportunityselectPage PrintSLA() {
    	 try {
			wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"))));
				List<WebElement> colvalue = driver.findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"));
				 int productsize = colvalue.size();
				   System.out.println("col size is :"+productsize);
				for (int i = 0; i < colvalue.size(); i++) {
				 String proname = colvalue.get(i).getText();
				    System.out.println("the product names for the search results SLA"+proname);						
				}
				reportStep("pass", " print the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", " print the SLA product is not success");
		} 
			return this;
	}
    
    public OpportunityselectPage SelectSLA() {
    	try {
			try {
				driver.findElement(By.xpath("//span[text()='Select 4 items']/../..")).click();
			} catch (ElementClickInterceptedException e) {
				WebElement select = driver.findElement(By.xpath("//span[text()='Select 4 items']/../.."));
				select.click();
			}
			reportStep("pass", " tickmark to select the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", " tickmark to select the SLA product is not success");
		}
    	return this;
	}
    
    public OpportunityselectPage nextSLA() {
    	try {
			driver.findElement(By.xpath("//button[@title='Next']")).click();
			reportStep("pass", "clicking the next on SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "clicking the next on SLA product is not success");
		}
    	return this;
		}
    
    public OpportunityselectPage EnterquanitySLA() {
    	 try {
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
				reportStep("pass", "Enter quanity  on SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "Enter quanity  on SLA product is not success");
		}
		return this;
	}
       
     public OpportunityselectPage UploadSampleFile() {
    	 try {
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
			reportStep("pass", "uploading file  is success");
		} catch (Exception e) {
			reportStep("fail", "uploading file  is not success");
		}
		
		return this;
	}
     
     public OpportunityselectPage closeSamplefile() {
    	 try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//lightning-primitive-icon[@variant='success']"))));
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Done']/.."))));
				driver.findElement(By.xpath("//span[text()='Done']/..")).click();
				reportStep("pass", "uploading file  is success click on done");
		} catch (Exception e) {
			reportStep("fail", "uploading file  is not success click on done");
		}
		return this;
	}
     public OpportunityselectPage closeuploadfile() {
    	 try {
			driver.findElement(By.xpath("//button[@title='Close this window']")).click();
			reportStep("pass", "click on close window uploading file  is success");
		} catch (Exception e) {
			reportStep("fail", "click on close window uploading file  is not success");
		}
    	 return this;
	}
     
     public OpportunityselectPage ScheduleMeetingEvent() {
    	 try {
			try {
					toleadstatus.scrollToElement(driver.findElement(By.xpath("(//*[text()='New Event'])[4]"))).perform();
				} catch (NoSuchElementException e) {
					toleadstatus.scrollToElement(driver.findElement(By.xpath("(//*[text()='New Event'])[4]"))).perform();
				}
			reportStep("pass", "click on schedulemeetingevent  is success");
		} catch (Exception e) {
			reportStep("fail", "click on schedulemeetingevent  is not success");
		}
		return this;
	}
     
    public OpportunityselectPage Eventwidget() {
    	try {
			try {
				driver.findElement(By.xpath("(//button[@title='More Actions'])[5]")).click();
				} catch (ElementClickInterceptedException e) {
				WebElement newevent = driver.findElement(By.xpath("(//button[@title='More Actions'])[5]"));
				driver.executeScript("arguments[0].click();", newevent);	
			}
			reportStep("pass", "click on eventwidget  is success");
		} catch (Exception e) {
			reportStep("fail", "click on eventwidget  is not success");
		} 
		return this;
	} 
    
    public viewcalenderpage clickviewcalender() {
    	try {
			try {
				driver.findElement(By.xpath("//span[text()='View Calendar']")).click();
			} catch (ElementClickInterceptedException e) {
				WebElement vcal = driver.findElement(By.xpath("//span[text()='View Calendar']"));
				driver.executeScript("arguments[0].click();", vcal);
			}
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowcalendar = driver.getWindowHandles();
			List<String> viewcalendar=new ArrayList<String>(windowcalendar);
			driver.switchTo().window(viewcalendar.get(1));
			reportStep("pass", "click on viewcalender  is success");
		} catch (Exception e) {
			reportStep("pass", "click on viewcalender  is not success");
		}
		return new viewcalenderpage();
	}
    
   
}
