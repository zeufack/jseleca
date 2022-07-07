package com.jseleca.drivers;

import com.jseleca.drivers.browser.Browser;

/**
 * DriverFactory.
 */
public final class DriverFactory {
    private DriverFactory() {
    }

    /**
     * @param drivers enum value.
     * @return web driver corresponding to geven driver name.
     */
    public static Browser getDriver(Drivers drivers) {
        return drivers.getbSupplier().get();
    }
}
