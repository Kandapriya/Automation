package runner;

import org.testng.annotations.BeforeTest;

import io.cucumber.testng.CucumberOptions;
import steps.Baseclasspom;

@CucumberOptions(features="src/test/java/features/Salesforce.feature",
                    glue={"steps"},monochrome = true, publish = true,
                   tags="@Regression" )

public class runsales extends Baseclasspom{

	@BeforeTest
	public void setData() {
		testcasename = "Lead to Opportunity";
		testcasedescription = "Converting the Lead to opportunity with valid data";
		author = "Kandhapriya";
		testcategory = "regression Testing";	
	}


}
