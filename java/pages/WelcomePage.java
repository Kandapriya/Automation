package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Baseclass.Baseclasspom;

public class WelcomePage extends Baseclasspom {
	
	public WelcomePage appLanucher() {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			reportStep("pass", "Applanucher is clicking successfully");
		} catch (Exception e) {
			reportStep("fail", "Applanucher is not clicking successfully");
		}
		return this;
		
	}
	
	public WelcomePage clickViewAll() {
		try {
			try {
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']"))).click();
			} catch (Exception e) {
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			}
			reportStep("pass", "ClickviewAll is success");
		} catch (Exception e) {
			reportStep("fail", "ClickviewAll is not success");
		}
		return this;
	}
	
	public homepage clickSales() {
		try {
			try {
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
			} catch (ElementClickInterceptedException e) {
			WebElement sale = driver.findElement(By.xpath("//p[text()='Sales']"));
			driver.executeScript("arguments[0].click();", sale);
			}
			reportStep("pass", "Clicksales is success");
		} catch (Exception e) {
			reportStep("pass", "Clicksales is not success");
		}
		return new homepage();
		
	}
		
	

}
