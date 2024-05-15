package steps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
@Test
public class viewcalenderpage extends Baseclasspom {
	
	@And ("click on New Button in Calender page")
	public viewcalenderpage calendernewevent() {
		try {
			getWait() .until(ExpectedConditions.visibilityOf( getDriver().findElement(By.xpath("//button[text()='New Event']"))));
			getDriver().findElement(By.xpath("//button[text()='New Event']")).click();
			 reportStep("pass", "click on new event  is success");
		} catch (Exception e) {
			 reportStep("fail", "click on new event  is not success");
		}
		 return this;
	}
	
	@And ("click on subject view calender")
	public viewcalenderpage subjectviewcalender() {
		try {
			try {
				getDriver().findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
			} catch (NoSuchElementException e) {
				getDriver().get(getDriver().getCurrentUrl());
				getDriver().findElement(By.xpath("//button[text()='New Event']")).click();
				getDriver().findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
			}
			getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Meeting']")).click();
			 reportStep("pass", "click on new event  is success");
		} catch (Exception e) {
			 reportStep("fail", "click on new event  is not success");
		}
		return this;
	}
	
	@And  ("click on Date in viewcalender")
	public viewcalenderpage Dateviewcalender() {
		 try {
			WebElement duedate1 = getDriver().findElement(By.xpath("//*[text()='Start']/following::input[@class='slds-input']"));
			 WebElement endDate =getDriver().findElement(By.xpath("//*[text()='End']/following::input[@class='slds-input']"));
			
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
	
	@And ("Enter the  Description in viewcalender")
	public viewcalenderpage Descriptionviewcalender() {
		try {
			getDriver().findElement(By.xpath("//textarea[@aria-describedby='quickTextKeyboardTip']")).sendKeys("New event for opportunity");
			 reportStep("pass", "enter description  is success");
		} catch (Exception e) {
			 reportStep("fail", "enter description  is not success");
		}
		return this;
	}
	
	@And ("click on  save view calender")
	public OpportunityselectPage saveviewcalender() {
		 try {
			 getDriver().findElement(By.xpath("//button[@title='Save']")).click();
			 reportStep("pass", "click on save in view calender is success");
		} catch (Exception e) {
			 reportStep("fail", "click on save in view calender is not success");;
		}
		 getDriver().close();
		 return new OpportunityselectPage();
	}

}
