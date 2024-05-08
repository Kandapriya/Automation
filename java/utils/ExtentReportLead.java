package utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportLead {

	public static void main(String[] args) throws IOException {
		//step 1-Set path for the report
				ExtentHtmlReporter wb=new ExtentHtmlReporter("./snapshot/LeadToOpportunity.html");
				
				//to keep previous report also
				wb.setAppendExisting(true);
				
				//step 2 create object for extentreports
				ExtentReports extent=new ExtentReports();
				
				//step 3-attach the data with physical file (combine step1 & step2)
				extent.attachReporter(wb);
				
				//step 4-create testcase and adding details 
				ExtentTest test=extent.createTest("Lead To Opportunity", "Login with valid credential from End to End");
				test.assignAuthor("kandhapriya");
				test.assignCategory("Regression Testing");
				
				//step 5-step level status
				
				test.pass("enter username");
				test.pass("enter password");
				test.fail("login button");
				test.pass("Crmsfa", MediaEntityBuilder.createScreenCaptureFromPath(".././snap/orderin.png").build());
				
				ExtentTest test1=extent.createTest("CreateLead","createlead with valid data"); 
				test1.assignAuthor("Gokul");
				test1.assignCategory("smoke Testing");
			    test1.pass("enter username"); 
			    test1.pass("enter password");
				test1.pass("login button");
				test1.pass("Crmsfa", MediaEntityBuilder.createScreenCaptureFromPath(".././snap/snap1.png").build());
				
				 ExtentTest test2=extent.createTest("editlead","Login with valid credential"); 
				 test2.assignAuthor("Vinoth");
				 test2.assignCategory("regression Testing");
				 test2.pass("enter username"); 
				 test2.pass("enter password");
				 test2.fail("login button");
				 test2.pass("Crmsfa", MediaEntityBuilder.createScreenCaptureFromPath(".././snap/tata.png").build());
				 
				 //step6 -
				extent.flush();
				System.out.println("successful");

	}

}
