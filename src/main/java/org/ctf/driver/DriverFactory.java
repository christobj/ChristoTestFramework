package org.ctf.driver;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

    private DriverFactory() {
        //Preventing from creating instances
    }

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void unload() {
        driverThreadLocal.remove();
    }
}
