package libararyclassic;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class libraries extends Baseclassclassic {

	@Test
	public void classiclibraries() throws IOException {
		//Switch to Salesforce Classic
		try {
			driver.findElement(By.xpath("(//span[@data-aura-class='uiImage'])[1]")).click();
			driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")).click();
		} catch (Exception e) {
		
		}
		//Ensure that the switch
		boolean displayed = driver.findElement(By.xpath("//div[@id='AppBodyHeader']")).isDisplayed();
		Assert.assertTrue(displayed);
		System.out.println(displayed);
		
		//Navigate to Libraries:
		driver.findElement(By.xpath("//li[@id='Workspace_Tab']")).click();
		//Select Asset Library
		driver.findElement(By.xpath("//select[@id='workspacesCombo']")).click();
		WebElement asset = driver.findElement(By.xpath("//select[@id='workspacesCombo']"));
		Select ass=new Select(asset);
		ass.selectByIndex(1);
		
		//Initiate Contribution
		driver.findElement(By.xpath("//table[@id='contributeMenu']")).click();
		//Link to Website:
		driver.findElement(By.xpath("//a[@id='__contributeshow_link_']")).click();
		
		//Enter URL:
		driver.findElement(By.xpath("//input[@id='contentUrl']")).clear();
		driver.findElement(By.xpath("//input[@id='contentUrl']")).sendKeys("http://randomName.com.");
		driver.findElement(By.xpath("//button[@id='documentcreate_contribute_']")).click();
		
		//Provide Title
		driver.findElement(By.xpath("//input[@id='title']")).clear();
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("About Random name.");
		driver.findElement(By.xpath("//table[@id='publishBtn']")).click();
		
		//Capture Snapshot
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='contentDetailTable']")));
		File scr=driver.getScreenshotAs(OutputType.FILE);
		File des=new File("./snapshot/libraries.png");
		FileUtils.copyFile(scr, des);
		
		//Complete Publishing:
		
		try {
			driver.findElement(By.xpath("//button[text()='Done Publishing']")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("//button[text()='Done Publishing']/parent::em")).click();
		}
		
	}

}
