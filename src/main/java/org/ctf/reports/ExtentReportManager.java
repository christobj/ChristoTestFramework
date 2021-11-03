package org.ctf.reports;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public final class ExtentReportManager {

    private ExtentReportManager() {
        //Preventing from creating instances
    }

    private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    static ExtentTest getExtentTest() {
        return extentTestThreadLocal.get();
    }

    static void setExtentTest(ExtentTest extentTest) {
        extentTestThreadLocal.set(extentTest);
    }

    static void unload() {
        extentTestThreadLocal.remove();
    }
}
