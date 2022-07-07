package com.jseleca.drivers.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.jseleca.utils.Properties.DRIVER_LOCATIONS;

/**
 * ChromeBrowser, implement Browser interfac an return an instance of
 * Chromedriver.
 */
public class ChromeBrowser implements Browser {

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATIONS.getChromeDriverPath());
        return new ChromeDriver();
    }

}
