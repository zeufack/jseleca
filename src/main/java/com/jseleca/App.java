package com.jseleca;

import com.jseleca.properties.ReadDriverLocation;

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

        ReadDriverLocation driverLocations = ReadDriverLocation.getInstance();
        System.out.println(driverLocations.getGeckoDriverPath());
    }
}
