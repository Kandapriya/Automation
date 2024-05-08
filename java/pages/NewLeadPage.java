package pages;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Baseclass.Baseclasspom;
import Leadtestng.BaseclassLead;

public class  NewLeadPage extends Baseclasspom {
	
	  public NewLeadPage  verifyLeadDetails() {
		  try {
			String leadt = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-name")).getText();
			    System.out.println(leadt);
			   String actualname="Mrs. " + lastName;
			    Assert.assertEquals(leadt, actualname);
			    String comlead = driver.findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).getText();
			    System.out.println(comlead);
			    String actualcomlead=comname;
			    Assert.assertEquals(comlead , actualcomlead);
			    reportStep("pass","Verifylead is getting successfully");
		} catch (Exception e) {
			 reportStep("fail","Verifylead is not getting successfully");
		}
		    return this;
	   }
	  
	  public NewLeadPage EmailToDoList() {
		  try {
			driver.findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
			reportStep("pass","Click on ToDOListWidget is success");
		} catch (Exception e) {
			reportStep("fail","Click on ToDOListwidget is not success");
		}
		  return this;
		}
	  
	  public NewLeadPage clickToDoList() {
			try {
				driver.findElement(By.xpath("//span[text()='Add Email to To Do List']")).click();
				reportStep("pass","clickToDoList is success");
			} catch (Exception e) {
				reportStep("fail","clickToDoList is not success");
			}
			return this;
			
		}public NewLeadPage Clicksubjectemail() {
			try {
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subject = driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
				driver.executeScript("arguments[0].click();", subject);
				reportStep("pass","click on subject in todolist is success");
			} catch (Exception e) {
				reportStep("fail","click on subject in todolist is not success");
			}
			return this;
			}
		
		public NewLeadPage dueDate() {
			try {
				WebElement duedate = driver.findElement(By.xpath("(//input[@class='slds-input'])[5]"));
				LocalDate currentDate = LocalDate.now();
				System.out.println(currentDate);
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String date = currentDate.format(dateFormat);
				System.out.println(date);
				duedate.sendKeys(date);
				reportStep("pass", "Entering date is success");
			} catch (Exception e) {
				reportStep("fail", "Entering date is not success");
			}
			return this;
			}
		
		public NewLeadPage statusTask() {
			try {
				driver.findElement(By.xpath("//a[@class='select']")).click();
				driver.findElement(By.xpath("//a[@title='In Progress']")).click();
				reportStep("pass", "selecting status in todolist is success");
			} catch (Exception e) {
				reportStep("pass", "selecting status in todolist is success");
			}
			return this;
					}
		
		public NewLeadPage  saveTask() {
			try {
				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				reportStep("pass","save the task in todolist is success");
			} catch (Exception e) {
				reportStep("fail","save the task in todolist is not success");
			}
			return this;
		}
	  
	     public NewLeadPage Emailbutton() {
		  try {
			WebElement sendemail = driver.findElement(By.xpath("//button[@title='Email']"));
				driver.executeScript("arguments[0].click();", sendemail);
				reportStep("pass", "click on emailbutton is success");
		} catch (Exception e) {
			reportStep("fail", "click on emailbutton is not success");
		}
			return this;
		}
	     
	     public NewLeadPage EmailId() {
	 		try {
				WebElement mailid = driver.findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]"));
				wait.until(ExpectedConditions.visibilityOf(mailid));
				mailid.sendKeys("kpriya@testleaf.com");
				reportStep("pass","entering MailID is success");
			} catch (Exception e) {
				reportStep("fail","entering MailID is not success");
			}
	 		return this;
	 	}
	 	
	 	public NewLeadPage emailsubject() {
	 		try {
				WebElement sub = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
				wait.until(ExpectedConditions.visibilityOf(sub));
				sub.sendKeys("ManageLeads for END TO END");
				reportStep("pass","message passing in subject is success");
			} catch (Exception e) {
				reportStep("fail","message passing in subject is not success");
			}
	 		return this;
	 	}
	 	
	 	public NewLeadPage composeEmail() {
	 		try {
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); 
				WebElement compose = driver.findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']"));
				wait.until(ExpectedConditions.visibilityOfAllElements(compose));
				compose.sendKeys("This story covers the steps to update the email status to 'Completed END TO END\r\n");
				driver.switchTo().defaultContent();
				reportStep("pass", "Composemail is success");
			} catch (Exception e) {
				reportStep("fail", "Composemail is not success");
			}
	 		return this;
	 	}
	 	
	 	public NewLeadPage  SendEmail() {
	 		try {
				driver.findElement(By.xpath("//span[text()='Send']")).click();
				reportStep("pass","click on sendMail is success");
			} catch (Exception e) {
				reportStep("fail","click on sendMail is not success");
			}
	 		return this;
	 	}
	 		
	 	public NewLeadPage upcomingOverDue() {
		   try {
			WebElement emailstatus;
				emailstatus = driver.findElement(By.xpath("(//span[text()='Show more actions']//ancestor::a)[2]"));
				driver.executeScript("arguments[0].click();", emailstatus);
				reportStep("pass","click on upcoming email widget is success");
		} catch (Exception e) {
			reportStep("fail","click on upcoming email widget is not success");;
		}
			return this;
	     }
	 	
	 	public NewLeadPage ClickChangeStatuss() {
			try {
				WebElement click1 = driver.findElement(By.xpath("(//div[@title='Change Status']/parent::a)[2]"));
				driver.executeScript("arguments[0].click();",click1);
				reportStep("pass", "click on changestatus in upcoming is success");
			} catch (Exception e) {
				reportStep("fail", "click on changestatus in upcoming is not success");
				
			}
			return this;
			}
	 	
	 	public NewLeadPage clickselectStatusupcoming() {
	 		 try {
				WebElement statuschange= driver.findElement(By.xpath("//a[@class='select']"));
					try {
						statuschange.click();
					} catch (StaleElementReferenceException e) {
						//driver.get(driver.getCurrentUrl());
						try {
							driver.findElement(By.xpath("//a[@class='select']")).click();
					}catch (StaleElementReferenceException e1) {
						driver.findElement(By.xpath("//a[@class='select']")).click();
					}
					}
					reportStep("pass","Select status in upcomingoverdue is success");
			} catch (Exception e) {
				reportStep("fail","Select status in upcomingoverdue is not success");
			}
				return this;
		  }
	 	
	 	public NewLeadPage chooseselectStatusupcoming() {
	 		try {
				driver.findElement(By.xpath("//a[text()='Completed']")).click();
				reportStep("pass","choose completed in upcoming is success");
			} catch (Exception e) {
				reportStep("fail","choose completed in upcoming is not success");
			}
	 		return this;
			
		}
	 	
	 	public NewLeadPage Savestatusupcoming() {
	 		try {
				driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				reportStep("pass", "Savestatusupcoming is success");
			} catch (Exception e) {
				reportStep("fail", "Savestatusupcoming is not success");
			}
			return this;
		}
	 	
	 	public NewLeadPage Detailslead() {
	 		try {
				try {
					driver.findElement(By.xpath("//li[@title='Details']")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement detail = driver.findElement(By.xpath("//li[@title='Details']"));
					driver.executeScript("arguments[0].click();",detail);
				}
				reportStep("pass", "click on detailstap is success");
			} catch (Exception e) {
				reportStep("pass", "click on detailstap is success");
			}
			return this;
		}
        
	 	public NewLeadPage clickediticiondetails() {
	 		try {
				WebElement editicon = driver.findElement(By.xpath("//button[@title='Edit Lead Status']"));
				driver.executeScript("arguments[0].click();", editicon);
				reportStep("pass","clickediticion in details is success");
			} catch (Exception e) {
				reportStep("fail","clickediticion in details is not success");
			}
			return this;
		}
	 	
	 	public NewLeadPage scrollToSelectdetails() {
	 		try {
				toleadstatus=new Actions(driver);
				toleadstatus.scrollToElement(driver.findElement(By.xpath("//label[text()='No. of Employees']"))).perform();
				driver.findElement(By.xpath("//label[text()='Lead Status']")).click();
				try {
					driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
				} catch (NoSuchElementException e1) {
					driver.findElement(By.xpath("//label[text()='Lead Status']")).click();	
					driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
				}
				reportStep("pass","clicking on working is success");
			} catch (Exception e) {
				reportStep("fail","clicking on working is not success");
			}
			return this;
		}
	 	
	 	public NewLeadPage Clicksavedetails() {
	 		try {
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				reportStep("pass","click on save in details is success");
			} catch (Exception e) {
				reportStep("fail","click on save in details is not success");
			}
			return this;
		}
	 	public NewLeadPage statusCompletion() {
	 		try {
				toleadstatus.scrollToElement(driver.findElement(By.xpath("//a[@title='Working - Contacted']"))).perform();
				WebElement complete = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']/.."));
				driver.executeScript("arguments[0].click();", complete);
				reportStep("pass", "click on statuscompletion is success");
			} catch (Exception e) {
				reportStep("fail", "click on statuscompletion is not success");
			}
			return this;
		}
	 	public NewLeadPage dropdown() {
	 		try {
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//span[text()='Status changed successfully.']"))));
				WebElement submitdropdown = driver.findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]"));
				wait.until(ExpectedConditions.elementToBeClickable(submitdropdown));
				try {
					submitdropdown.click();
				} catch (Exception e) {
					driver.executeScript("arguments[0].click();", submitdropdown);
				}
				reportStep("pass", "click on dropdown for convert is success");
			} catch (Exception e) {
				reportStep("fail", "click on dropdown for convert is not success");
			}
			return this;
			}
	 	
	 	public NewLeadPage Convertfirst() {
	 		try {
				try {
					driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
					driver.executeScript("arguments[0].click()", dropDown2);
				}catch (StaleElementReferenceException e) {
					driver.navigate().refresh();
					try {
						driver.findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]")).click();
						driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
					} catch (ElementClickInterceptedException e1) {
						WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						driver.executeScript("arguments[0].click()", dropDown2);
					}
				}
				reportStep("pass", "click on convert in submitbutton is success");
			} catch (Exception e) {
				reportStep("fail", "click on convert in submitbutton is not success");
			}
			return this;
		}
	 	
	 	public NewLeadPage convertsecond() {
	 		try {
				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='modal-container slds-modal__container']"))));
				WebElement convertlead1 = driver.findElement(By.xpath("//button[text()='Convert']"));
				wait.until(ExpectedConditions.elementToBeClickable(convertlead1));
				 //driver.executeScript("arguments[0].click();", convertlead1);
				try {
					 driver.findElement(By.xpath("//button[text()='Convert']")).click();
					
				} catch (Exception e) {
					 WebElement elementcon = driver.findElement(By.xpath("//button[text()='Convert']"));
					driver.executeScript("arguments[0].click();", elementcon);
				}
				try {
					WebElement convertopp = driver.findElement(By.xpath("//button[text()='Convert']"));
					//wait.until(ExpectedConditions.elementToBeClickable(convertopp));
					convertopp.click();
				} catch (ElementClickInterceptedException e) {
					WebElement convert1 = driver.findElement(By.xpath("//button[text()='Convert']"));
					driver.executeScript("arguments[0].click();",convert1);
				}catch(TimeoutException e) {
					WebElement convert1 = driver.findElement(By.xpath("//button[text()='Convert']"));
					driver.executeScript("arguments[0].click();",convert1);
				}
				reportStep("pass", "click on convert to opportunity is success");
			} catch (Exception e) {
				reportStep("fail", "click on convert to opportunity is not success");
			}
	 		return this;
	 	}
	 	
	 	public NewLeadPage converfullsecond() {
	 		try {
				try {
					driver.findElement(By.xpath("//button[text()='Go to Leads']")).click();
					} catch (Exception e3) {
					driver.get(driver.getCurrentUrl());
					try {
						driver.findElement(By.xpath("//span[text()='Show more actions']/parent::button")).click();
					} catch (Exception e1) {
						WebElement showMore = driver.findElement(By.xpath("//span[text()='Show more actions']/parent::button"));
						driver.executeScript("arguments[0].click()", showMore);
					} 
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
					} catch (ElementClickInterceptedException e1) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						driver.executeScript("arguments[0].click()", dropDown2);
					} catch (ElementNotInteractableException e1) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						WebElement dropDown2 = driver.findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						driver.executeScript("arguments[0].click()", dropDown2);
					} 
					try {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']")));
						driver.findElement(By.xpath("//button[text()='Convert']")).click();			
					} catch (Exception e6) {
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']")));
						WebElement convert3 = driver.findElement(By.xpath("//button[text()='Convert']"));
						driver.executeScript("arguments[0].click()", convert3);
					}
				}
				reportStep("pass", "Convert to opportunity after refreshing is success");
			} catch (Exception e) {
				reportStep("fail", "Convert to opportunity after refreshing is not success");
			}
			return this;
		}
	 	
	 	public NewLeadPage snapshotpopup() throws IOException {
	 		try {
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='modal-container slds-modal__container']"))));
				 File scr=driver.getScreenshotAs(OutputType.FILE);
				File des=new File("./snapshot/leadconvert.png");
				FileUtils.copyFile(scr, des);
				reportStep("pass", "taking screenshot is success");
			} catch (WebDriverException e) {
				reportStep("fail", "taking screenshot is not success");
			} catch (IOException e) {
				reportStep("fail", "taking screenshot is not success");
			}
			return this;
			}
	 	
	 	public leadHomePage closepopup() {
	 		try {
				try {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"))));
				} catch (StaleElementReferenceException e3) {
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'modal-body')]"))));
				}
				reportStep("pass", "close pop message is success");
			} catch (Exception e) {
				reportStep("fail", "close pop message is not success");
			}
			return new leadHomePage();
		}
	 	
	 	
	 	
	 	
	 	
	 	
}
