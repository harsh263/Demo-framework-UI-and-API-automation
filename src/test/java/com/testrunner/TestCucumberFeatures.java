package com.testrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		features = "src/test/java/com/featurefiles"
		,glue={"com.stepdefenitions"}
		)

public class TestCucumberFeatures {
	

}
