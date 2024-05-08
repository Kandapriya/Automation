package pages;

import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Baseclass.Baseclasspom;

public class leadHomePage extends Baseclasspom {
	
	public leadHomePage createNewLead() {
		try {
			driver.findElement(By.xpath("//a[@title='New']")).click();
			reportStep("pass", "New button is clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "New button is not clicked successfully");
		}
		return this;
		}
	public leadHomePage Salutation() {
		try {
			driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
			driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
			reportStep("pass", "Clicking on Salution is success");
		} catch (Exception e) {
			reportStep("pass", "Clicking on Salution is success");
		}
		return this;
	}
	 public leadHomePage LastName() {
		    try {
				lastName = faker.name().lastName();
				driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName );
				reportStep("pass","lastname enter successfully");
			} catch (Exception e) {
				reportStep("fail","lastname not enter successfully");
			}
		   return this;
	}
	 public leadHomePage Company() {
		 try {
			comname = faker.company().name();
			 driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(comname);
			 reportStep("pass", "company name is entered successfully"); 
		} catch (Exception e) {
			 reportStep("pass", "company name is not entered successfully"); 
		}
		 return this;
		}
	 
     public NewLeadPage clickSave() {
    	 try {
			driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			reportStep("pass","clicking on save is success");
		} catch (Exception e) {
			reportStep("fail","clicking on save is not success");
		}
    	 return new NewLeadPage();
    	}
     
     public leadHomePage searchleadname() {
    	 try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"))));
				driver.findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(lastName +Keys.ENTER);
				WebElement verify = driver.findElement(By.xpath("//div[@class='uiScroller scroller-wrapper scroll-bidirectional native']"));
				String veirfyname = verify.getText();
				if (veirfyname.contains(lastName)) {
					System.out.println("The lead " + lastName + " is not convert to opportunity ");
				} else {
					System.out.println("The lead "+ lastName +" is convert to opportunity ");
				}
				reportStep("pass", "Serach and enter lead name is success");
		} catch (Exception e) {
			reportStep("fail", "Serach and enter lead name is not success");
		}
		return this;
	}
     
     public OpportunityPage clickopportunity() {
    	 try {
			WebElement opportunity = driver.findElement(By.xpath("//a[@title='Opportunities']"));
				driver.executeScript("arguments[0].click();", opportunity);
				reportStep("pass","click on opportunity is success");
		} catch (Exception e) {
			reportStep("pass","click on opportunity is success");
		}
 		return new OpportunityPage();
 	}

}
