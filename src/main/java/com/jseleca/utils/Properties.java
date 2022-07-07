package com.jseleca.utils;

import com.jseleca.properties.EnvProperties;
import com.jseleca.properties.ReadDriverLocation;

/**
 * Properties access points.
 */
public final class Properties {
    /**
     * Env properties reader instance.
     */
    public static final EnvProperties ENV_PROPERTIES = EnvProperties.getInstance();

    /**
     * Env properties reader instance.
     */
    public static final ReadDriverLocation DRIVER_LOCATIONS = ReadDriverLocation.getInstance();

    /**
     * Make this class not instanciable.
     */
    private Properties() {

    }

}
