package com.jseleca.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A file reader to get webdriver path from config properties, we simple use.
 * java enum implemenation of Singleton design pattern.
 */
public enum ReadDriverLocation {
    /**
     * an instance of ReadDriverLocation to share between class client's.
     */
    INSTANCE;

    /**
     * create the loger.
     */
    private final Logger logger = LoggerFactory.getLogger(ReadDriverLocation.class);

    /**
     * config.properties file name.
     */
    private final String propertiesFile = "config.properties";

    /**
     * config.properties path.
     */
    private final String configFilePaht = "config/" + propertiesFile;

    /**
     * use Properties from java.util to read properties in .properties file.
     */
    private Properties properties;

    /**
     * chromedriver executable path.
     */
    private String chromeDriverPath;

    /**
     * geckodriver executable path.
     */
    private String geckoDriverPath;

    /**
     * msedgeDriver executable path.
     */
    private String msedgeDriverPath;

    /**
     * read all executable provide in config.properties file.
     */
    ReadDriverLocation() {
        try (BufferedReader reader = new BufferedReader(new FileReader(configFilePaht))) {
            this.properties = new Properties();
            this.properties.load(reader);
            this.chromeDriverPath = readDriverPath("path_to_chromedriver");
            this.geckoDriverPath = readDriverPath("path_to_geckodriver");
            this.msedgeDriverPath = readDriverPath("path_to_msedgedriver");

        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Ther is not " + propertiesFile + " file in the path" + configFilePaht);
        }
    }

    /**
     * get chromedriver executable path from config.properties.
     */
    public String getChromeDriverPath() {
        return chromeDriverPath;
    }

    /**
     * get geckodriver executable path from config.properties.
     */
    public String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    /**
     * get msedgedriver executable path from config.properties.
     */
    public String getMsedgeDriverPath() {
        return msedgeDriverPath;
    }

    /**
     * get the ReadDriverLocation running instance, or create one.
     */
    public static ReadDriverLocation getInstance() {
        return INSTANCE;
    }

    /**
     * reade properties for given drivername.
     */
    private String readDriverPath(String driverName) {
        String property = this.properties.getProperty(driverName);
        if (property == null) {
            logger.warn("you didn't provide {} property in your config.properties file", driverName);
        }
        return property;
    }

}
