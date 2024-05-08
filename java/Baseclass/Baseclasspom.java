package Baseclass;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;


import utils.ExcelwtihTCSales;


public class Baseclasspom {
	
//globally declare driver	
public static ChromeDriver driver;
public static WebDriverWait wait;
public static Faker faker;
public static String lastName;
public static String comname;
public static Actions toleadstatus;
public static String testcasename;
public static String testcasedescription,author,testcategory;
public static ExtentTest node,test;
public ExtentReports Extent;

//public static String filedata;
public static ExtentReports extent;

          @BeforeSuite
          public void ReportStartlead() {
        	//step 1-Set path for the report
			ExtentHtmlReporter wb=new ExtentHtmlReporter(new File("./Leadreports/report.html"));
			//to keep previous report also
			wb.setAppendExisting(true);
			//step 2 create object for extentreports
			extent=new ExtentReports();
			//step 3-attach the data with physical file (combine step1 & step2)
		    extent.attachReporter(wb);
				}
          
          @BeforeClass
          public void testDetailslead() {
        	ExtentTest test = extent.createTest(testcasename, testcasedescription);
			test.assignAuthor(author);
			test.assignCategory(testcategory);
			node = test.createNode(testcasename);
		}
          
          public int takeSnap() {

      		int random = (int) ((Math.random())*999999);
            File src = driver.getScreenshotAs(OutputType.FILE);
      		File des = new File("./snaplead/img"+random+".png");
      		try {
      			FileUtils.copyFile(src, des);
      		} catch (IOException e) {
      			}
      		return random;
	        }


      	public void reportStep(String status, String desc) {

      		if(status.equalsIgnoreCase("pass")) {
      			try {
      				node.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaplead/img"+takeSnap()+".png").build());
      			} catch (IOException e) {

      			}
      		}else if (status.equalsIgnoreCase("fail")) {
      			try {
      				node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaplead/img"+takeSnap()+".png").build());
      			} catch (IOException e) {

      		}
      		}
      	}
          
    @BeforeMethod
	public void perconditionslead(){
		// To disable the notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//lanch chrome 
		faker = new Faker();			
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		toleadstatus=new Actions(driver);
    }
    
   //@AfterMethod
//       public void postconditionlead() {
//		driver.close();
//	  }
//    @DataProvider(name="getName")
//       	public String[][] Fetchdata() throws IOException{
//   		//annotation ClassName.methodName() and add return type for it.
//   		String[][] exceldata=ExcelwtihTCSales.excelData(filedata);
//   		return exceldata;
//   	}
    
    @AfterSuite
     public void Reportcloselead() {
    	//step6 -
		extent.flush();
		System.out.println("successful");
	}
}
