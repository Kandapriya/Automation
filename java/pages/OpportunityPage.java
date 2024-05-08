package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Baseclass.Baseclasspom;

public class OpportunityPage extends Baseclasspom {
	
	public OpportunityPage Searchopportunity() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"))));
			driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).click();
			driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(comname+Keys.ENTER);
			reportStep("pass", "enter on search opportunity name is success");
		} catch (Exception e) {
			reportStep("fail", "enter on search opportunity name is not success");
		}
		return this;
	}
	
	public OpportunityselectPage clickopportunitymatch() {
		try {
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
			reportStep("pass","click on opportunity is success");
		} catch (Exception e) {
			reportStep("fail","click on opportunity is not success");
		}
		return new OpportunityselectPage();
		}

}
