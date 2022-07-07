package com.jseleca.drivers.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static com.jseleca.utils.Properties.DRIVER_LOCATIONS;

/**
 * MsedgeBrowser.
 */
public class MsedgeBrowser implements Browser {

    @Override
    public WebDriver getWebDriver() {
        System.setProperty("webdriver.edge.driver", DRIVER_LOCATIONS.getMsedgeDriverPath());
        return new EdgeDriver();
    }

}
