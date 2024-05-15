package steps;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WelcomePage extends Baseclasspom {
	
	@ When ("click on applauncher")
	public WelcomePage appLanucher() {
		try {
			getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']"))));
			getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			reportStep("pass", "Applanucher is clicking successfully");
		} catch (Exception e) {
			reportStep("fail", "Applanucher is not clicking successfully");
		}
		return this;
		
	}
	
	@And ("click on viewall")
	public WelcomePage clickViewAll() {
		try {
			try {
				getWait() .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='View All']"))).click();
			} catch (Exception e) {
				getDriver().findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
				getDriver().findElement(By.xpath("//button[text()='View All']")).click();
			}
			reportStep("pass", "ClickviewAll is success");
		} catch (Exception e) {
			reportStep("fail", "ClickviewAll is not success");
		}
		return this;
	}
	
	@And ("click on slaes")
    public homepage clickSales() {
		try {
			try {
				getDriver().findElement(By.xpath("//p[text()='Sales']")).click();
			} catch (ElementClickInterceptedException e) {
			WebElement sale = getDriver().findElement(By.xpath("//p[text()='Sales']"));
			getDriver().executeScript("arguments[0].click();", sale);
			}
			reportStep("pass", "Clicksales is success");
		} catch (Exception e) {
			reportStep("pass", "Clicksales is not success");
		}
		return new homepage();
		
	}
		
	

}
