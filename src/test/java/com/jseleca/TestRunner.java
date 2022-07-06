package com.jseleca;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
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
     * Log.
     */
    private static final Logger LOG = LoggerFactory.getLogger(TestRunner.class);

    /**
     * Setup.
     */
    @Parameters({ "browser" })
    @BeforeClass
    public void beforeSuite(@Optional("chrome") String browser) {
        LOG.info("using browser  " + browser);
    }

    /**
     * Tear down and release resources.
     */
    @AfterSuite
    public void afterSuite() {
    }
}
