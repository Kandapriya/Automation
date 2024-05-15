package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class LeadOpportunity_TC001 extends steps.Baseclasspom {
	
	
//	@BeforeTest
//	public void setData() {
//		testcasename = "Lead to Opportunity";
//		testcasedescription = "Converting the Lead to opportunity with valid data";
//		author = "Kandhapriya";
//		testcategory = "regression Testing";	
//	}

  @Test
	public void Lead() throws IOException {
		
		steps.LoginPage lp= new steps.LoginPage();
		
		lp.enterUsername("kpriya@testleaf.com").enterPassword("March2016.").clicklogin().appLanucher().clickViewAll().clickSales().
		clickleadstap().createNewLead().Salutation().LastName().Company().clickSave().verifyLeadDetails().
		EmailToDoList().clickToDoList().Clicksubjectemail().dueDate().statusTask().saveTask().
		Emailbutton().EmailId().emailsubject().composeEmail().SendEmail().
		upcomingOverDue().ClickChangeStatuss().clickselectStatusupcoming().chooseselectStatusupcoming().Savestatusupcoming().
		Detailslead().clickediticiondetails().scrollToSelectdetails().Clicksavedetails().statusCompletion().
		dropdown().Convertfirst().convertsecond().converfullsecond().snapshotpopup().closepopup().
		searchleadname().clickopportunity().clickopportunitymatch().
		Pricebook().choosepricebook().savePricebook().addproduct().addProduct2().SLAsearch().clickSLAsearch().clickSLA().PrintSLA().SelectSLA().nextSLA().EnterquanitySLA().
		UploadSampleFile().closeSamplefile().closeuploadfile().
		ScheduleMeetingEvent().Eventwidget()
	    .clickviewcalender().calendernewevent().subjectviewcalender().Dateviewcalender().Descriptionviewcalender().saveviewcalender();
	}
	
}
