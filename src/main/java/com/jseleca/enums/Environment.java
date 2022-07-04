package com.jseleca.enums;

/**
 * A List of Testing Environment.
 */
public enum Environment {
    /**
     * Local Environment, using the webdriver implementation provide for the
     * browser.
     */
    local,

    /**
     * Remote Enviroment, for scaling test (selenium hub or browserstack).
     */
    remote

}
