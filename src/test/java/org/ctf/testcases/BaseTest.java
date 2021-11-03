package org.ctf.testcases;

import org.ctf.driver.Driver;
import org.ctf.enums.CoreConfigProperties;
import org.ctf.reports.ExtentReport;
import org.ctf.utils.PropertyReaderUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected BaseTest() {
       //Only Test Class Files can create instance or extend the class
    }

    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    public String getUserName() {
        return PropertyReaderUtil.getValue(CoreConfigProperties.USERNAME);
    }

    public String getPassword() {
        return PropertyReaderUtil.getValue(CoreConfigProperties.PASSWORD);
    }
}
