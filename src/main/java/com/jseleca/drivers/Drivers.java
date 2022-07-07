package com.jseleca.drivers;

import com.jseleca.drivers.browser.Browser;
import com.jseleca.drivers.browser.ChromeBrowser;
import com.jseleca.drivers.browser.FirefoxBrowser;
import java.util.function.Supplier;

/**
 * Enum of webdriver names.
 */
public enum Drivers {
    /**
     * webdriver implementation for chrome.
     */
    CHROME(ChromeBrowser::new),
    /**
     * webdriver implementation for firefox.
     */
    FIREFOX(FirefoxBrowser::new),
    /**
     * webdriver implementation ms edge.
     */
    MSEDGE(FirefoxBrowser::new);

    // a supplier to get an instance of webdriver.
    private final Supplier<Browser> bSupplier;

    /**
     * @param bSupplier
     */
    Drivers(Supplier<Browser> bSupplier) {
        this.bSupplier = bSupplier;
    }

    /**
     * @return a supplier containing the webdriver instance.
     */
    public Supplier<Browser> getbSupplier() {
        return bSupplier;
    }
}
