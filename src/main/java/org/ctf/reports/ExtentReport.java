package org.ctf.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.ctf.constants.FrameworkConstants;
import org.ctf.enums.CategoryType;
import org.ctf.enums.DeviceType;

import java.util.Objects;

public final class ExtentReport {

    private ExtentReport() {}

    private static ExtentReports extentReports;

    public static void intiExtentReport() {
        if (Objects.isNull(extentReports)) {
            extentReports = new ExtentReports();
            ExtentSparkReporter extentReporter = new ExtentSparkReporter(FrameworkConstants.getPathtoextentreports());
            extentReports.attachReporter(extentReporter);
            extentReporter.config().setTheme(Theme.DARK);
            extentReporter.config().setReportName("Orange HRM");
            extentReporter.config().setDocumentTitle("ChristoTestFW");
            extentReporter.config().setTimelineEnabled(true);
        }
    }

    public static void flushReport() {
        if (Objects.nonNull(extentReports))
            extentReports.flush();
        ExtentReportManager.unload();
    }

    public static void createTest(String testCaseName) {
        ExtentReportManager.setExtentTest(extentReports.createTest(testCaseName));
    }

    public static void addAuthors(String[] authors) {
        for (String author : authors) {
            ExtentReportManager.getExtentTest().assignAuthor(author);
        }
    }

    public static void addCategories(CategoryType[] categories) {
        for (CategoryType category : categories) {
            ExtentReportManager.getExtentTest().assignCategory(category.toString());
        }
    }

    public static void setDevice(DeviceType device) {
        ExtentReportManager.getExtentTest().assignDevice(device.toString());
    }
}
