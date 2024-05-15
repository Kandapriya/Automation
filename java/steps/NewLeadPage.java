package steps;

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

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class  NewLeadPage extends Baseclasspom {
	
	@Then ("Verify new lead is created")
	  public NewLeadPage  verifyLeadDetails() {
		  try {
			  getWait() .until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"))));
			String leadt = getDriver().findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-name")).getText();
			    System.out.println(leadt);
			    super.lastName=lastName;
			   String actualname="Mrs. " + lastName;
			    Assert.assertEquals(leadt, actualname);
			    String comlead = getDriver().findElement(By.xpath("(//p[contains(@class,'nent slds-text-body--regular slds-show_inline')])[2]")).getText();
			    System.out.println(comlead);
			    String actualcomlead=comlead;
			    Assert.assertEquals(comlead , actualcomlead);
			    reportStep("pass","Verifylead is getting successfully");
		} catch (Exception e) {
			 reportStep("fail","Verifylead is not getting successfully");
		}
		    return this;
	   }
	  
	 @When ("click on EmailtoDolist")
	  public NewLeadPage EmailToDoList() {
		  try {
			  getDriver().findElement(By.xpath("(//button[@title='More Actions'])[3]")).click();
			reportStep("pass","Click on ToDOListWidget is success");
		} catch (Exception e) {
			reportStep("fail","Click on ToDOListwidget is not success");
		}
		  return this;
		}
	  
	 @And ("click on DotoList Widget")
	  public NewLeadPage clickToDoList() {
			try {
				getDriver().findElement(By.xpath("//span[text()='Add Email to To Do List']")).click();
				reportStep("pass","clickToDoList is success");
			} catch (Exception e) {
				reportStep("fail","clickToDoList is not success");
			}
			return this;
			
		}
	 
	 @And ("click on subject on DoToList")
	  public NewLeadPage Clicksubjectemail() {
			try {
				getDriver().findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).click();
				WebElement subject = getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Email']"));
				getDriver().executeScript("arguments[0].click();", subject);
				reportStep("pass","click on subject in todolist is success");
			} catch (Exception e) {
				reportStep("fail","click on subject in todolist is not success");
			}
			return this;
			}
		
	    @And ("enter the Date") 
		public NewLeadPage dueDate() {
			try {
				WebElement duedate = getDriver().findElement(By.xpath("(//input[@class='slds-input'])[5]"));
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
		
	    @And ("select the Status in DoToList")
		public NewLeadPage statusTask() {
			try {
				getDriver().findElement(By.xpath("//a[@class='select']")).click();
				getDriver().findElement(By.xpath("//a[@title='In Progress']")).click();
				reportStep("pass", "selecting status in todolist is success");
			} catch (Exception e) {
				reportStep("pass", "selecting status in todolist is success");
			}
			return this;
					}
		
	    @And ("Click on save in DoToList")
		public NewLeadPage  saveTask() {
			try {
				getDriver().findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				reportStep("pass","save the task in todolist is success");
			} catch (Exception e) {
				reportStep("fail","save the task in todolist is not success");
			}
			return this;
		}
	  
	    @When ("click on Email Button")
	    public NewLeadPage Emailbutton() {
		  try {
			WebElement sendemail = getDriver().findElement(By.xpath("//button[@title='Email']"));
			getDriver().executeScript("arguments[0].click();", sendemail);
				reportStep("pass", "click on emailbutton is success");
		} catch (Exception e) {
			reportStep("fail", "click on emailbutton is not success");
		}
			return this;
		}
	     
	    @And ("Enter the Mail Id")
	     public NewLeadPage EmailId() {
	 		try {
				WebElement mailid = getDriver().findElement(By.xpath("(//input[@aria-describedby='recipientsInputLabel'])[1]"));
				getWait() .until(ExpectedConditions.visibilityOf(mailid));
				mailid.sendKeys("kpriya@testleaf.com");
				reportStep("pass","entering MailID is success");
			} catch (Exception e) {
				reportStep("fail","entering MailID is not success");
			}
	 		return this;
	 	}
	 	
	    @And ("Enter the Subject for Mail")
	 	public NewLeadPage emailsubject() {
	 		try {
				WebElement sub = getDriver().findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
				getWait() .until(ExpectedConditions.visibilityOf(sub));
				sub.sendKeys("ManageLeads for END TO END");
				reportStep("pass","message passing in subject is success");
			} catch (Exception e) {
				reportStep("fail","message passing in subject is not success");
			}
	 		return this;
	 	}
	 	
	    @And ("Enter the Compose Mail")
	 	public NewLeadPage composeEmail() {
	 		try {
	 			getWait() .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
	 			getWait() .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0)); 
				WebElement compose = getDriver().findElement(By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']"));
				getWait() .until(ExpectedConditions.visibilityOfAllElements(compose));
				compose.sendKeys("This story covers the steps to update the email status to 'Completed END TO END\r\n");
				getDriver().switchTo().defaultContent();
				reportStep("pass", "Composemail is success");
			} catch (Exception e) {
				reportStep("fail", "Composemail is not success");
			}
	 		return this;
	 	}
	 	
	    @And ("Click on Send")
	 	public NewLeadPage  SendEmail() {
	 		try {
	 			getDriver().findElement(By.xpath("//span[text()='Send']")).click();
				reportStep("pass","click on sendMail is success");
			} catch (Exception e) {
				reportStep("fail","click on sendMail is not success");
			}
	 		return this;
	 	}
	 	
	    @When ("Click on Upcoming and Overdue")
	 	public NewLeadPage upcomingOverDue() {
		   try {
			WebElement emailstatus;
				emailstatus = getDriver().findElement(By.xpath("(//span[text()='Show more actions']//ancestor::a)[2]"));
				getDriver().executeScript("arguments[0].click();", emailstatus);
				reportStep("pass","click on upcoming email widget is success");
		} catch (Exception e) {
			reportStep("fail","click on upcoming email widget is not success");;
		}
			return this;
	     }
	 	
	    @And ("Click on Change Status")
	 	public NewLeadPage ClickChangeStatuss() {
			try {
				WebElement click1 = getDriver().findElement(By.xpath("(//div[@title='Change Status']/parent::a)[2]"));
				getDriver().executeScript("arguments[0].click();",click1);
				reportStep("pass", "click on changestatus in upcoming is success");
			} catch (Exception e) {
				reportStep("fail", "click on changestatus in upcoming is not success");
				
			}
			return this;
			}
	 	
	    @When("click on Status in upcoming")
	 	public NewLeadPage clickselectStatusupcoming() {
	 		 try {
				WebElement statuschange= getDriver().findElement(By.xpath("//a[@class='select']"));
					try {
						statuschange.click();
					} catch (StaleElementReferenceException e) {
						//driver.get(driver.getCurrentUrl());
						try {
							getDriver().findElement(By.xpath("//a[@class='select']")).click();
					}catch (StaleElementReferenceException e1) {
						getDriver().findElement(By.xpath("//a[@class='select']")).click();
					}
					}
					reportStep("pass","Select status in upcomingoverdue is success");
			} catch (Exception e) {
				reportStep("fail","Select status in upcomingoverdue is not success");
			}
				return this;
		  }
	 	
	    @And ("Click on Completed in Status") 
	 	public NewLeadPage chooseselectStatusupcoming() {
	 		try {
	 			getDriver().findElement(By.xpath("//a[text()='Completed']")).click();
				reportStep("pass","choose completed in upcoming is success");
			} catch (Exception e) {
				reportStep("fail","choose completed in upcoming is not success");
			}
	 		return this;
			
		}
	 	
	    @When("click on Save") 
	 	public NewLeadPage Savestatusupcoming() {
	 		try {
	 			getDriver().findElement(By.xpath("(//span[text()='Save'])[3]")).click();
				reportStep("pass", "Savestatusupcoming is success");
			} catch (Exception e) {
				reportStep("fail", "Savestatusupcoming is not success");
			}
			return this;
		}
	 	
	    @When ("Click on Details Tab")
	 	public NewLeadPage Detailslead() {
	 		try {
				try {
					getDriver().findElement(By.xpath("//li[@title='Details']")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement detail = getDriver().findElement(By.xpath("//li[@title='Details']"));
					getDriver().executeScript("arguments[0].click();",detail);
				}
				reportStep("pass", "click on detailstap is success");
			} catch (Exception e) {
				reportStep("pass", "click on detailstap is success");
			}
			return this;
		}
        
	    @And ("click edit icion details Tab") 
	 	public NewLeadPage clickediticiondetails() {
	 		try {
				WebElement editicon = getDriver().findElement(By.xpath("//button[@title='Edit Lead Status']"));
				getDriver().executeScript("arguments[0].click();", editicon);
				reportStep("pass","clickediticion in details is success");
			} catch (Exception e) {
				reportStep("fail","clickediticion in details is not success");
			}
			return this;
		}
	 	
	    @And ("scroll To Select details Tab")
	 	public NewLeadPage scrollToSelectdetails() {
	 		try {
				toleadstatus=new Actions(getDriver());
				toleadstatus.scrollToElement(getDriver().findElement(By.xpath("//label[text()='No. of Employees']"))).perform();
				getDriver().findElement(By.xpath("//label[text()='Lead Status']")).click();
				try {
					getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
				} catch (NoSuchElementException e1) {
					getDriver().findElement(By.xpath("//label[text()='Lead Status']")).click();	
					getDriver().findElement(By.xpath("//lightning-base-combobox-item[@data-value='Working - Contacted']")).click();
				}
				reportStep("pass","clicking on working is success");
			} catch (Exception e) {
				reportStep("fail","clicking on working is not success");
			}
			return this;
		}
	 	
	    @And  ("Click on saved in details Tab")
	 	public NewLeadPage Clicksavedetails() {
	 		try {
	 			getDriver().findElement(By.xpath("//button[@name='SaveEdit']")).click();
				reportStep("pass","click on save in details is success");
			} catch (Exception e) {
				reportStep("fail","click on save in details is not success");
			}
			return this;
		}
	    
	    @When ("click to status Completion") 
	 	public NewLeadPage statusCompletion() {
	 		try {
				toleadstatus.scrollToElement(getDriver().findElement(By.xpath("//a[@title='Working - Contacted']"))).perform();
				WebElement complete = getDriver().findElement(By.xpath("//span[text()='Mark Status as Complete']/.."));
				getDriver().executeScript("arguments[0].click();", complete);
				reportStep("pass", "click on statuscompletion is success");
			} catch (Exception e) {
				reportStep("fail", "click on statuscompletion is not success");
			}
			return this;
		}
	    
	    @And ("click on Dropdown")
	 	public NewLeadPage dropdown() {
	 		try {
	 			getWait() .until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//span[text()='Status changed successfully.']"))));
				WebElement submitdropdown = getDriver().findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]"));
				getWait() .until(ExpectedConditions.elementToBeClickable(submitdropdown));
				try {
					submitdropdown.click();
				} catch (Exception e) {
					getDriver().executeScript("arguments[0].click();", submitdropdown);
				}
				reportStep("pass", "click on dropdown for convert is success");
			} catch (Exception e) {
				reportStep("fail", "click on dropdown for convert is not success");
			}
			return this;
			}
	 	
	    @And ("click on Convert in dropdown")
	 	public NewLeadPage Convertfirst() {
	 		try {
				try {
					getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement dropDown2 = getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
					getDriver().executeScript("arguments[0].click()", dropDown2);
				}catch (StaleElementReferenceException e) {
					getDriver().navigate().refresh();
					try {
						getDriver().findElement(By.xpath("//lightning-button-menu[contains(@data-target-reveals,'StandardButton.Lead.Convert')]")).click();
						getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
					} catch (ElementClickInterceptedException e1) {
						WebElement dropDown2 = getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						getDriver().executeScript("arguments[0].click()", dropDown2);
					}
				}
				reportStep("pass", "click on convert in submitbutton is success");
			} catch (Exception e) {
				reportStep("fail", "click on convert in submitbutton is not success");
			}
			return this;
		}
	 	
	    @And ("click on convert in ConvertPage")
	 	public NewLeadPage convertsecond() {
	 		try {
	 			getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@class='modal-container slds-modal__container']"))));
				WebElement convertlead1 = getDriver().findElement(By.xpath("//button[text()='Convert']"));
				getWait() .until(ExpectedConditions.elementToBeClickable(convertlead1));
				 //driver.executeScript("arguments[0].click();", convertlead1);
				try {
					getDriver().findElement(By.xpath("//button[text()='Convert']")).click();
					
				} catch (Exception e) {
					 WebElement elementcon = getDriver().findElement(By.xpath("//button[text()='Convert']"));
					 getDriver().executeScript("arguments[0].click();", elementcon);
				}
				try {
					WebElement convertopp = getDriver().findElement(By.xpath("//button[text()='Convert']"));
					//wait.until(ExpectedConditions.elementToBeClickable(convertopp));
					convertopp.click();
				} catch (ElementClickInterceptedException e) {
					WebElement convert1 = getDriver().findElement(By.xpath("//button[text()='Convert']"));
					getDriver().executeScript("arguments[0].click();",convert1);
				}catch(TimeoutException e) {
					WebElement convert1 = getDriver().findElement(By.xpath("//button[text()='Convert']"));
					getDriver().executeScript("arguments[0].click();",convert1);
				}
				reportStep("pass", "click on convert to opportunity is success");
			} catch (Exception e) {
				reportStep("fail", "click on convert to opportunity is not success");
			}
	 		return this;
	 	}
	 	
	    @When ("Refersh page for whole dropdown to convert")
	 	public NewLeadPage converfullsecond() {
	 		try {
				try {
					getDriver().findElement(By.xpath("//button[text()='Go to Leads']")).click();
					} catch (Exception e3) {
						getDriver().get(getDriver().getCurrentUrl());
					try {
						getDriver().findElement(By.xpath("//span[text()='Show more actions']/parent::button")).click();
					} catch (Exception e1) {
						WebElement showMore = getDriver().findElement(By.xpath("//span[text()='Show more actions']/parent::button"));
						getDriver().executeScript("arguments[0].click()", showMore);
					} 
					try {
						getWait() .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")).click();
					} catch (ElementClickInterceptedException e1) {
						getWait() .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						WebElement dropDown2 = getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						getDriver().executeScript("arguments[0].click()", dropDown2);
					} catch (ElementNotInteractableException e1) {
						getWait() .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span")));
						WebElement dropDown2 = getDriver().findElement(By.xpath("//lightning-menu-item[contains(@data-target-selection-name,'Lead.Convert')]//span"));
						getDriver().executeScript("arguments[0].click()", dropDown2);
					} 
					try {
						getWait() .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']")));
						getDriver().findElement(By.xpath("//button[text()='Convert']")).click();			
					} catch (Exception e6) {
						getWait() .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']")));
						WebElement convert3 = getDriver().findElement(By.xpath("//button[text()='Convert']"));
						getDriver().executeScript("arguments[0].click()", convert3);
					}
				}
				reportStep("pass", "Convert to opportunity after refreshing is success");
			} catch (Exception e) {
				reportStep("fail", "Convert to opportunity after refreshing is not success");
			}
			return this;
		}
	 	
	    @And ("Take A snapShot")
	 	public NewLeadPage snapshotpopup() throws IOException {
	 		try {
	 			getWait() .until(ExpectedConditions.invisibilityOf(getDriver().findElement(By.xpath("//div[@class='modal-container slds-modal__container']"))));
				 File scr=getDriver().getScreenshotAs(OutputType.FILE);
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
	 	
	    @And ("close the Popup Message")
	 	public leadHomePage closepopup() {
	 		try {
				try {
					getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[contains(@class,'modal-body')]"))));
				} catch (StaleElementReferenceException e3) {
					getWait() .until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[contains(@class,'modal-body')]"))));
				}
				try {
					getDriver().findElement(By.xpath("//button[@title='Close this window']")).click();
				} catch (ElementClickInterceptedException e) {
					WebElement closelead = getDriver().findElement(By.xpath("//button[@title='Close this window']"));
					getDriver().executeScript("arguments[0].click();",closelead);
				}
				reportStep("pass", "close pop message is success");
			} catch (Exception e) {
				reportStep("fail", "close pop message is not success");
			}
			return new leadHomePage();
		}
	 	
	 	
	 	
	 	
	 	
	 	
}
