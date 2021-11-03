package org.ctf.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.ctf.constants.FrameworkConstants;
import org.ctf.enums.CoreConfigProperties;
import org.ctf.utils.PropertyReaderUtil;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public final class Driver {

    private Driver() {
        //Preventing from Creating instances
    }

    public static void initDriver() {
        if (Objects.isNull(DriverFactory.getDriver())) {
            if (PropertyReaderUtil.getValue(CoreConfigProperties.BROWSER).equalsIgnoreCase("chrome")) {
                if (PropertyReaderUtil.getValue(CoreConfigProperties.EXECUTIONMODE).equalsIgnoreCase("remote")) {
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setBrowserName(Browser.CHROME.browserName());
                    try {
                        DriverFactory.setDriver(new RemoteWebDriver(new URL("http://localhost:4444"),desiredCapabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    WebDriverManager.chromedriver().setup();
                    DriverFactory.setDriver(new ChromeDriver(chromeOptions));
                }
            } else if (PropertyReaderUtil.getValue(CoreConfigProperties.BROWSER).equalsIgnoreCase("edge")) {
                if (PropertyReaderUtil.getValue(CoreConfigProperties.EXECUTIONMODE).equalsIgnoreCase("remote")) {
                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setBrowserName(Browser.EDGE.browserName());
                    try {
                        DriverFactory.setDriver(new RemoteWebDriver(new URL("http://localhost:4445"),desiredCapabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    WebDriverManager.edgedriver().setup();
                    DriverFactory.setDriver(new EdgeDriver());
                }
            }
            DriverFactory.getDriver().manage().window().maximize();
            DriverFactory.getDriver().manage().deleteAllCookies();
            DriverFactory.getDriver().get(PropertyReaderUtil.getValue(CoreConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverFactory.getDriver()))
            DriverFactory.getDriver().quit();
        DriverFactory.unload();
    }
}
