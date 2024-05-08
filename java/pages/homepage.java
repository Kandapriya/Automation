package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Baseclass.Baseclasspom;

public class homepage extends Baseclasspom {
	
	public leadHomePage clickleadstap() {
		try {
			WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
			driver.executeScript("arguments[0].click()", lead);
			reportStep("pass","clickleadTap is success");
		} catch (Exception e) {
			reportStep("fail","clickleadTap is success");
		}
		return new leadHomePage();
		
	}

}
