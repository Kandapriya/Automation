package steps;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPage extends Baseclasspom {
	
	
	@Given ("Enter the User name (.*)$")
	public LoginPage enterUsername(String uname)
	{
		try {
			getDriver().findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
			reportStep("pass", "Username entered successfully");
		} catch (Exception e) {
			reportStep("Fail", "Unable enter username ");
		}
	    return this;	
	}
	
	@ And ("Enter the Password (.*)$")
	public LoginPage enterPassword(String pwd)
	{
		try {
			getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
			reportStep("pass", "Password entered successfully");
		} catch (Exception e) {
			reportStep("Fail", "Unable enter password ");
		}
	    return this;	
	}
	
	 @When ("clik on login button")
	public WelcomePage clicklogin() {
		try {
			getDriver().findElement(By.xpath("//input[@id='Login']")).click();
			reportStep("pass", "Login btn clicked successfully");
		} catch (Exception e) {
			reportStep("pass", "Login btn not clicked successfully");
		}
		return new WelcomePage();
	}

}
