package org.ctf.listeners;

import org.ctf.annotations.FrameworkAnnotations;
import org.ctf.reports.ExtentLogger;
import org.ctf.reports.ExtentReport;
import org.testng.*;

import java.sql.Array;
import java.util.Arrays;

public class ChristoListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.intiExtentReport(suite.getXmlSuite().getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getDescription());
        ExtentLogger.info(result.getMethod().getDescription());
        ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().
                getAnnotation(FrameworkAnnotations.class).author());
        ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().
                getAnnotation(FrameworkAnnotations.class).category());
        ExtentReport.setDevice(result.getMethod().getConstructorOrMethod().getMethod().
                getAnnotation(FrameworkAnnotations.class).device());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is Fail");
        ExtentLogger.fail(result.getThrowable().toString());
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped");
    }
}
