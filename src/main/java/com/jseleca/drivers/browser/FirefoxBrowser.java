package com.jseleca.drivers.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.jseleca.utils.Properties.DRIVER_LOCATIONS;

/**
 * Firefox browser werbdriver.
 */
public class FirefoxBrowser implements Browser {

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.gecko.driver", DRIVER_LOCATIONS.getGeckoDriverPath());
        return new FirefoxDriver();
    }
}
