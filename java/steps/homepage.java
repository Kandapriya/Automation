package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;

public class homepage extends Baseclasspom {
	
	@When ("click on homepage")
	public leadHomePage clickleadstap() {
		try {
			WebElement lead = getDriver().findElement(By.xpath("(//span[text()='Leads'])[1]"));
			getDriver().executeScript("arguments[0].click()", lead);
			reportStep("pass","clickleadTap is success");
		} catch (Exception e) {
			reportStep("fail","clickleadTap is success");
		}
		return new leadHomePage();
		
	}

}
