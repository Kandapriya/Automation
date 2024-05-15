package steps;

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
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class OpportunityselectPage extends Baseclasspom {
	
	@And ("Click on PriceBook dropdown")
	public OpportunityselectPage Pricebook() {
		try {
			getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]"))));
			getDriver().findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")).click();
			reportStep("pass", "select pricebook widget is success");
		} catch (Exception e) {
			reportStep("fail", "select pricebook widget is not success");
		}
		return this;
	}
	
	@And ("Select the ChoosePriceBook")
	public OpportunityselectPage choosepricebook() {
		try {
			getDriver().findElement(By.xpath("//a[@title='Choose Price Book']")).click();
			reportStep("pass", "choose price book is success");
		} catch (Exception e) {
			reportStep("fail", "choose price book is not success");
		}
		return this;
		
	}
	
	@When ("Clik on Save for price Book")
	public OpportunityselectPage savePricebook() {
		try {
			getDriver().findElement(By.xpath("(//span[text()='Save']/..)[2]")).click();
			reportStep("pass", "save price book is success");
		} catch (Exception e) {
			reportStep("fail", "save price book is not success");
		}
		return this;
	}
	
	@And ("Click on priceBook dropdown")
	public OpportunityselectPage addproduct() {
		try {
			try {
				getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")))).click();
			} catch (StaleElementReferenceException e1) {
				getDriver().findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]")).click();
			}
			reportStep("pass", "choose add productc widget is success");
		} catch (Exception e) {
			reportStep("fail", "choose add product widget is not success");
		}
		return this;
	}
	
	@When ("Click on Add Product")
	public OpportunityselectPage addProduct2() {
		try {
			getDriver().findElement(By.xpath("//a[@title='Add Products']")).click();
			reportStep("pass", "select the add productc is success");
		} catch (Exception e) {
			reportStep("fail", "select the add productc is not success");
		}
		return this;
		
	}
	
	@And ("Search the Product which is SLA")
	public OpportunityselectPage SLAsearch() {
		try {
			getDriver().findElement(By.xpath("//input[@title='Search Products']")).click();
			//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@title='Search Products']"))));
			getDriver().findElement(By.xpath("//input[@title='Search Products']")).sendKeys("SLA"+Keys.ENTER);
			reportStep("pass", "Enter the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "Enter the SLA product is not success");
		}
       return this;
	}
	
	@And ("Click on SlA in Search Box")
	public OpportunityselectPage clickSLAsearch() {
     try {
		try {
				
			getDriver().findElement(By.xpath("//span[text()='Search Products']")).click();
			} catch (ElementClickInterceptedException e3) {
				WebElement sla1 = getDriver().findElement(By.xpath("//span[text()='Search Products']"));
				getDriver().executeScript("arguments[0].click()", sla1);
			}catch (ElementNotInteractableException e4) {
				WebElement sla1 = getDriver().findElement(By.xpath("//span[text()='Search Products']"));
				getDriver().executeScript("arguments[0].click()",sla1);
			}
		reportStep("pass", "search the SLA product is success");
	} catch (Exception e) {
		reportStep("fail", "search the SLA product is not success");
	}
       return this;
		
	}
	
	@And("Click SLA")
    public OpportunityselectPage clickSLA() {
    	try {
			WebElement add;
			try {
				add = getDriver().findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
				add.click();
			} catch (Exception e) {
				add = getDriver().findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[1]"));
				getDriver().executeScript("arguments[0].click();", add);	
			}
			reportStep("pass", " click the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "click the SLA product is not success");
		}
		return this;
    }
	
	@When ("print all SLA Product")
    public OpportunityselectPage PrintSLA() {
    	 try {
    		 getWait() .until(ExpectedConditions.visibilityOfAllElements(getDriver().findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"))));
				List<WebElement> colvalue =getDriver().findElements(By.xpath("//div[@class='undefined hideRowNumberColumn hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr/td[2]/following-sibling::th"));
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
    
	@And ("Select All the SlA Product")
    public OpportunityselectPage SelectSLA() {
    	try {
			try {
				getDriver().findElement(By.xpath("//span[text()='Select 4 items']/../..")).click();
			} catch (ElementClickInterceptedException e) {
				WebElement select = getDriver().findElement(By.xpath("//span[text()='Select 4 items']/../.."));
				select.click();
			}
			reportStep("pass", " tickmark to select the SLA product is success");
		} catch (Exception e) {
			reportStep("fail", " tickmark to select the SLA product is not success");
		}
    	return this;
	}
    
	@And  ("Click on Next")
    public OpportunityselectPage nextSLA() {
    	try {
    		getDriver().findElement(By.xpath("//button[@title='Next']")).click();
			reportStep("pass", "clicking the next on SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "clicking the next on SLA product is not success");
		}
    	return this;
		}
    
	@And ("Enter Quantity of SLAProduct")
    public OpportunityselectPage EnterquanitySLA() {
    	 try {
    		 getDriver().findElement(By.xpath("//div[@class='undefined hideSelection hideRLAColumn forceListViewManagerGrid']//div/table/tbody/tr[1]/td[2]")).click();
    		 getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("(//a[text()='SLA: Gold']/ancestor::th/following-sibling::td)[1]"))));
				getDriver().findElement(By.xpath("(//a[text()='SLA: Gold']/ancestor::th/following-sibling::td)[1]")).click();
				getDriver().findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td//input")).sendKeys("2"+Keys.ENTER);
				getDriver().findElement(By.xpath("(//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td)[1]")).click();
				getDriver().findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td//input")).sendKeys("10"+Keys.ENTER);
				getDriver().findElement(By.xpath("(//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td)[1]")).click();
				getDriver().findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td//input")).sendKeys("1"+Keys.ENTER);
				getDriver().findElement(By.xpath("(//a[text()='SLA: Silver']/ancestor::th/following-sibling::td)[1]")).click();
				getDriver().findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td//input")).sendKeys("5"+Keys.ENTER);
				getDriver().findElement(By.xpath("//button[@title='Save']")).click();
				getWait() .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'-notify--toast forceToastMessage')]")));
				reportStep("pass", "Enter quanity  on SLA product is success");
		} catch (Exception e) {
			reportStep("fail", "Enter quanity  on SLA product is not success");
		}
		return this;
	}
      
	@When ("Click on UPloadSampleFile")
     public OpportunityselectPage UploadSampleFile() {
    	 try {
			Actions contname=new Actions(getDriver());
			    try {
					contname.scrollToElement(getDriver().findElement(By.xpath("//span[text()='Upload Files']"))).perform();
				} catch (NoSuchElementException e) {
					contname.scrollToElement(getDriver().findElement(By.xpath("//span[text()='Upload Files']"))).perform();
				}
			WebElement upload = getDriver().findElement(By.xpath("//input[@type='file']"));
			
			try {
				getWait() .until(ExpectedConditions.visibilityOf(upload));
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
     
	@And ("Click on  Done to close Sample file")
     public OpportunityselectPage closeSamplefile() {
    	 try {
    		 getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//lightning-primitive-icon[@variant='success']"))));
    		 getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[text()='Done']/.."))));
			getDriver().findElement(By.xpath("//span[text()='Done']/..")).click();
				reportStep("pass", "uploading file  is success click on done");
		} catch (Exception e) {
			reportStep("fail", "uploading file  is not success click on done");
		}
		return this;
	}
	
	@And ("Click on Close after uploading")
     public OpportunityselectPage closeuploadfile() {
    	 try {
    		 getDriver().findElement(By.xpath("//button[@title='Close this window']")).click();
			reportStep("pass", "click on close window uploading file  is success");
		} catch (Exception e) {
			reportStep("fail", "click on close window uploading file  is not success");
		}
    	 return this;
	}
     
	@And ("click on ScheduleMeetingEvent")
     public OpportunityselectPage ScheduleMeetingEvent() {
    	 try {
			try {
					toleadstatus.scrollToElement(getDriver().findElement(By.xpath("(//*[text()='New Event'])[4]"))).perform();
				} catch (NoSuchElementException e) {
					toleadstatus.scrollToElement(getDriver().findElement(By.xpath("(//*[text()='New Event'])[4]"))).perform();
				}
			reportStep("pass", "click on schedulemeetingevent  is success");
		} catch (Exception e) {
			reportStep("fail", "click on schedulemeetingevent  is not success");
		}
		return this;
	}
    
	@And ("Click on Event widget")
    public OpportunityselectPage Eventwidget() {
    	try {
			try {
				getDriver().findElement(By.xpath("(//button[@title='More Actions'])[5]")).click();
				} catch (ElementClickInterceptedException e) {
				WebElement newevent = getDriver().findElement(By.xpath("(//button[@title='More Actions'])[5]"));
				getDriver().executeScript("arguments[0].click();", newevent);	
			}
			reportStep("pass", "click on eventwidget  is success");
		} catch (Exception e) {
			reportStep("fail", "click on eventwidget  is not success");
		} 
		return this;
	} 
    
	@When ("click on view calender")
    public viewcalenderpage clickviewcalender() {
    	try {
			try {
				getDriver().findElement(By.xpath("//span[text()='View Calendar']")).click();
			} catch (ElementClickInterceptedException e) {
				WebElement vcal = getDriver().findElement(By.xpath("//span[text()='View Calendar']"));
				getDriver().executeScript("arguments[0].click();", vcal);
			}
			getWait() .until(ExpectedConditions.numberOfWindowsToBe(2));
			Set<String> windowcalendar = getDriver().getWindowHandles();
			List<String> viewcalendar=new ArrayList<String>(windowcalendar);
			getDriver().switchTo().window(viewcalendar.get(1));
			reportStep("pass", "click on viewcalender  is success");
		} catch (Exception e) {
			reportStep("pass", "click on viewcalender  is not success");
		}
		return new viewcalenderpage();
	}
    
   
}
