package runners;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish =true,
		features = "src//test//resources//features//ProductStore.feature",
		glue= {"stepDefs"},
		monochrome = true,
		dryRun=false,
		plugin= {"pretty",
				"html:target/reports/HtmlReport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		)
public class ProductStoreRunner {

}
