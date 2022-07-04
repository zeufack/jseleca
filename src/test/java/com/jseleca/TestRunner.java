package com.jseleca;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * Global test runner.
 */
@CucumberOptions(glue = { "com.jseleca.steps" }, features = { "src/test/resources/features" }, plugin = {
        "pretty",
        "html:target/reports/html/htmlreport",
        "json:target/reports/jsonreports/index.json",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
})
class TestRunner extends AbstractTestNGCucumberTests {

    /**
     * Setup.
     */
    @Parameters("browser")
    @BeforeSuite
    public void beforeSuite(@Optional() String browser) {
        System.out.println("useing browser" + browser);
    }

    /**
     * Tear down and release resources.
     */
    @AfterSuite
    public void afterSuite() {
    }
}
