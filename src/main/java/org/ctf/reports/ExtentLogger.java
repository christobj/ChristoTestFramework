package org.ctf.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import org.ctf.driver.DriverFactory;
import org.ctf.enums.CoreConfigProperties;
import org.ctf.utils.PropertyReaderUtil;
import org.ctf.utils.ScreenshotUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

    private ExtentLogger() {}

    public static void pass(String message) {
        if (PropertyReaderUtil.getValue(CoreConfigProperties.PASSSCREENSHOT).equalsIgnoreCase("yes")) {
            pass(message,true);
        } else {
            pass(message,false);
        }
    }

    public static void fail(String message) {
        if (PropertyReaderUtil.getValue(CoreConfigProperties.FAILSCREENSHOT).equalsIgnoreCase("yes")) {
            fail(message,true);
        } else {
            fail(message,false);
        }
    }

    public static void warning(String message) {
        ExtentReportManager.getExtentTest().warning(message);
    }

    public static void skip(String message) {
        if (PropertyReaderUtil.getValue(CoreConfigProperties.SKIPSCREENSHOT).equalsIgnoreCase("yes")) {
            skip(message,true);
        } else {
            skip(message,false);
        }
    }

    public static void info(String message) {
        ExtentReportManager.getExtentTest().info(message);
    }

    private static void pass(String message, boolean isscreenshotneeded) {
        if (isscreenshotneeded)
            ExtentReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Screenshot()).build());
        else
            ExtentReportManager.getExtentTest().pass(message);
    }

    private static void fail(String message, boolean isscreenshotneeded) {
        if (isscreenshotneeded)
            ExtentReportManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Screenshot()).build());
        else
            ExtentReportManager.getExtentTest().fail(message);
    }

    private static void skip(String message, boolean isscreenshotneeded) {
        if (isscreenshotneeded)
            ExtentReportManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Screenshot()).build());
        else
            ExtentReportManager.getExtentTest().skip(message);
    }
}
