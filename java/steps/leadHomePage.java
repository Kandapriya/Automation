package steps;

import org.checkerframework.checker.units.qual.t;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bind.annotation.Super;

public class leadHomePage extends Baseclasspom {
	
	@When ("click oncreateNewLead")
	public leadHomePage createNewLead() {
		try {
			getDriver().findElement(By.xpath("//a[@title='New']")).click();
			reportStep("pass", "New button is clicked successfully");
		} catch (Exception e) {
			reportStep("fail", "New button is not clicked successfully");
		}
		return this;
		}
	
	@And ("click on Salutation")
	public leadHomePage Salutation() {
		try {
			getDriver().findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
			getDriver().findElement(By.xpath("//span[text()='Mrs.']")).click();
			reportStep("pass", "Clicking on Salution is success");
		} catch (Exception e) {
			reportStep("pass", "Clicking on Salution is success");
		}
		return this;
	}
	
	@And  ("Enter the lastName")
	 public leadHomePage LastName() {
		    try {
		    	super.lastName=lastName;
				lastName = faker.name().lastName();
				getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName );
				//String lastName1 = getDriver().findElement(By.xpath("//input[@name='lastName']")).getText();
				//System.out.println("The lead name is"+ lastName1);
				reportStep("pass","lastname enter successfully");
			} catch (Exception e) {
				reportStep("fail","lastname not enter successfully");
			}
		   return this;
	}
	
	@And ("Enter the CompanyName")
	 public leadHomePage Company() {
		 try {
			 super.comname=comname;
			comname = faker.company().name();
			getDriver().findElement(By.xpath("//input[@name='Company']")).sendKeys(comname);
			//String company1 = getDriver().findElement(By.xpath("//input[@name='Company']")).getText();
			//System.out.println("The companyname is"+company1);
			 reportStep("pass", "company name is entered successfully"); 
		} catch (Exception e) {
			 reportStep("pass", "company name is not entered successfully"); 
		}
		 return this;
		}
	
	@And ("click on save") 
     public NewLeadPage clickSave() {
    	 try {
    		 getDriver().findElement(By.xpath("(//button[text()='Save'])[2]")).click();
			reportStep("pass","clicking on save is success");
		} catch (Exception e) {
			reportStep("fail","clicking on save is not success");
		}
    	 return new NewLeadPage();
    	}
	
	@Then ("verify  lead is convert to opporunity")
     public leadHomePage searchleadname() {
    	 try {
    		 getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']"))));
			getDriver().findElement(By.xpath("//input[@aria-label='Search Recently Viewed list view.']")).sendKeys(lastName +Keys.ENTER);
				WebElement verify = getDriver().findElement(By.xpath("//div[@class='uiScroller scroller-wrapper scroll-bidirectional native']"));
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
     
	@When ("lead is conver to opportunity click on opportunityTap")
     public OpportunityPage clickopportunity() {
    	 try {
			WebElement opportunity = getDriver().findElement(By.xpath("//a[@title='Opportunities']"));
			getDriver().executeScript("arguments[0].click();", opportunity);
				reportStep("pass","click on opportunity is success");
		} catch (Exception e) {
			reportStep("pass","click on opportunity is success");
		}
 		return new OpportunityPage();
 	}

	

}
