package org.ctf.driver;

import org.ctf.constants.FrameworkConstants;
import org.ctf.utils.PropertyReader;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public final class Driver {

    private Driver() {
        //Preventing from Creating instances
    }

    public static void initDriver() {
        if (Objects.isNull(DriverFactory.getDriver())) {
            System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
            DriverFactory.setDriver(new ChromeDriver());
            DriverFactory.getDriver().get(PropertyReader.getValue("url"));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverFactory.getDriver()))
            DriverFactory.getDriver().quit();
        DriverFactory.unload();
    }
}
