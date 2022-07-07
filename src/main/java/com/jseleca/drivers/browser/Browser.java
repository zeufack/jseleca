package com.jseleca.drivers.browser;

import org.openqa.selenium.WebDriver;

/**
 * Browser interface, call it browser instead of driver to avoid colision with.
 * selenim.
 */
public interface Browser {
    /**
     * @return an webdriver instace for given browser.
     */
    WebDriver getWebDriver();

}
