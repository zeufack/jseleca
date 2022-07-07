package com.jseleca;

import com.jseleca.properties.EnvProperties;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     */
    public static void main(String[] args) {

        EnvProperties envProperties = EnvProperties.getInstance();
        System.out.println(envProperties.getBrowserName());
    }
}
