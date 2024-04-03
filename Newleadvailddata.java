package Leads;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newleadvailddata {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("kpriya@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("March2016.");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement lead = driver.findElement(By.xpath("(//span[text()='Leads'])[1]"));
		driver.executeScript("arguments[0].click()", lead);
		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='Mrs.']")).click();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("kandhapriya");
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String leadt = driver.findElement(By.xpath("//lightning-formatted-name[text()='Mrs.  kandhapriya']")).getText();
		System.out.println(" verifying,the lead's name is displayed:"+leadt);
	}

}
