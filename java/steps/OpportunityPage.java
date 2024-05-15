package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class OpportunityPage extends Baseclasspom {
	
	@And ("Enter the Opportunity Name")
	public OpportunityPage Searchopportunity() {
		try {
			getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//input[@name='Opportunity-search-input']"))));
			getDriver().findElement(By.xpath("//input[@name='Opportunity-search-input']")).click();
			getDriver().findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(comname+Keys.ENTER);
			reportStep("pass", "enter on search opportunity name is success");
		} catch (Exception e) {
			reportStep("fail", "enter on search opportunity name is not success");
		}
		return this;
	}
	
	@When ("click on opportunity")
	public OpportunityselectPage clickopportunitymatch() {
		try {
			try {
				getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//a[@title='"+ comname +"-']")))).click();
			}catch (StaleElementReferenceException e) {
				WebElement oppclick = getDriver().findElement(By.xpath("//a[@title='"+ comname +"-']"));
				getDriver().executeScript("arguments[0].click();", oppclick);
			}catch (ElementClickInterceptedException e2) {
				WebElement opportu = getDriver().findElement(By.xpath("//a[@title='"+comname+"-']"));
				getDriver().executeScript("arguments[0].click();", opportu);
			   }catch (ElementNotInteractableException e2) {
				WebElement opportunity1 = getDriver().findElement(By.xpath("//a[@title='"+comname+"-']"));
				opportunity1.click();
			}catch (JavascriptException e) {
				WebElement oppclick = getDriver().findElement(By.xpath("//a[@title='"+ comname +"-']"));
				getDriver().executeScript("arguments[0].click();", oppclick);
			}
			reportStep("pass","click on opportunity is success");
		} catch (Exception e) {
			reportStep("fail","click on opportunity is not success");
		}
		return new OpportunityselectPage();
		}

}
