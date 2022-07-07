package com.jseleca;

import com.jseleca.drivers.DriverFactory;
import com.jseleca.drivers.Drivers;
import com.jseleca.drivers.browser.Browser;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import static com.jseleca.utils.Properties.ENV_PROPERTIES;

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
    @BeforeClass()
    public void beforeSuite() {
        Browser browser = DriverFactory.getDriver(Drivers.valueOf(ENV_PROPERTIES.getBrowserName().toUpperCase()));
        LOG.info("using browser " + ENV_PROPERTIES.getBrowserName().toUpperCase());

    }

    /**
     * Tear down and release resources.
     */
    @AfterSuite
    public void afterSuite() {
    }

}
