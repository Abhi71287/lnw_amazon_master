package com.qa.lnw.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = { "src/test/resources/Features" }, glue = { "com/qa/lnw/stepDefination" }, plugin = {
		"pretty", "html:target/htmlreport.html" })
public class TestRunner  extends AbstractTestNGCucumberTests{

}
