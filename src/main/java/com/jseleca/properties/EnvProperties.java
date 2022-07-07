package com.jseleca.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Read properties from env.properties file.
 */
public enum EnvProperties {
    /**
     * an instance of ReadDriverLocation to share between class client's.
     */
    INSTANCE;

    // Logger.
    private static final Logger LOG = LoggerFactory.getLogger(EnvProperties.class);

    // env file name.
    private static final String ENV_FILE_NAME = "env.properties";
    // env file path.
    private static final String ENV_FILE_PATH = "config/" + ENV_FILE_NAME;

    // properties from java util, use to reade properties from key value file.
    private Properties properties;

    // browser name.
    private String browserName;

    // environment name.
    private String environmentName;

    // browser stack link.
    private String browserstackLink;

    // selenium grid link.
    private String seleniumGridLink;

    /**
     * private contructor.
     */
    EnvProperties() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ENV_FILE_PATH))) {
            this.properties = new Properties();
            this.properties.load(reader);
            this.browserName = readProperties("browser");
            this.environmentName = readProperties("environment");
            this.browserstackLink = readProperties("browserstack_link");
            this.seleniumGridLink = readProperties("seleniumgrid_link");

        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Ther is not " + ENV_FILE_NAME + " file in the path" + ENV_FILE_PATH);
        }

    }

    /**
     * @param propertyName
     * @return property vale from env.properties file
     */
    private String readProperties(String propertyName) {
        String property = this.properties.getProperty(propertyName);
        if (property == null) {
            LOG.warn("you didn't provide {} property in your env.properties file, hope you don't need if",
                    propertyName);
        }
        return property;
    }

    /**
     * return an instance of the single env properties file reader.
     */
    public static EnvProperties getInstance() {
        return INSTANCE;
    }

    /**
     * @return browser name as set in env.properties file.
     */
    public String getBrowserName() {
        return browserName;
    }

    /**
     * @return browserstack link name as set in env.properties file.
     */
    public String getBrowserstackLink() {
        return browserstackLink;
    }

    /**
     * @return seleniumGrid link name as set in env.properties file.
     */
    public String getSeleniumGridLink() {
        return seleniumGridLink;
    }

    /**
     * @return environment name link name as set in env.properties file.
     */
    public String getEnvironmentName() {
        return environmentName;
    }

}
