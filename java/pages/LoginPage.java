package pages;

import org.openqa.selenium.By;

import Baseclass.Baseclasspom;

public class LoginPage extends Baseclasspom {
	
	public LoginPage enterUsername(String uname)
	{
		try {
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
			reportStep("pass", "Username entered successfully");
		} catch (Exception e) {
			reportStep("Fail", "Unable enter username ");
		}
	    return this;	
	}

	public LoginPage enterPassword(String pwd)
	{
		try {
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
			reportStep("pass", "Password entered successfully");
		} catch (Exception e) {
			reportStep("Fail", "Unable enter password ");
		}
	    return this;	
	}
	
	public WelcomePage clicklogin() {
		try {
			driver.findElement(By.xpath("//input[@id='Login']")).click();
			reportStep("pass", "Login btn clicked successfully");
		} catch (Exception e) {
			reportStep("pass", "Login btn not clicked successfully");
		}
		return new WelcomePage();
	}

}
