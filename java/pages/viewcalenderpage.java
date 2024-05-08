package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import Baseclass.Baseclasspom;
@Test
public class viewcalenderpage extends Baseclasspom {
	
	public viewcalenderpage calendernewevent() {
		try {
			wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//button[text()='New Event']"))));
			 driver.findElement(By.xpath("//button[text()='New Event']")).click();
			 reportStep("pass", "click on new event  is success");
		} catch (Exception e) {
			 reportStep("fail", "click on new event  is not success");
		}
		 return this;
	}
	
	public viewcalenderpage subjectviewcalender() {
		try {
			try {
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
			} catch (NoSuchElementException e) {
				driver.get(driver.getCurrentUrl());
				driver.findElement(By.xpath("//button[text()='New Event']")).click();
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
			}
			driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Meeting']")).click();
			 reportStep("pass", "click on new event  is success");
		} catch (Exception e) {
			 reportStep("fail", "click on new event  is not success");
		}
		return this;
	}
	
	public viewcalenderpage Dateviewcalender() {
		 try {
			WebElement duedate1 = driver.findElement(By.xpath("//*[text()='Start']/following::input[@class='slds-input']"));
			 WebElement endDate = driver.findElement(By.xpath("//*[text()='End']/following::input[@class='slds-input']"));
			
				LocalDate currentDate1 = LocalDate.now();
				System.out.println(currentDate1);
				DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
				String date1 = currentDate1.format(dateFormat1);
				System.out.println(date1);
				LocalDate nextDay = currentDate1.plusDays(1);
				String nextdate1= nextDay.format(dateFormat1);
				System.out.println(nextdate1);
				duedate1.clear();
				duedate1.sendKeys(nextdate1);
				endDate.clear();
				endDate.sendKeys(nextdate1);
				 reportStep("pass", "enter date using java  is success");
		} catch (Exception e) {
			reportStep("fail", "enter date using java  is not success");
		}
		return this;
	}
	
	public viewcalenderpage Descriptionviewcalender() {
		try {
			driver.findElement(By.xpath("//textarea[@aria-describedby='quickTextKeyboardTip']")).sendKeys("New event for opportunity");
			 reportStep("pass", "enter description  is success");
		} catch (Exception e) {
			 reportStep("fail", "enter description  is not success");
		}
		return this;
	}
	
	public OpportunityselectPage saveviewcalender() {
		 try {
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			 reportStep("pass", "click on save in view calender is success");
		} catch (Exception e) {
			 reportStep("fail", "click on save in view calender is not success");;
		}
		 driver.close();
		 return new OpportunityselectPage();
	}

}
