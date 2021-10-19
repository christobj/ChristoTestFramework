package org.ctf.testcases;

import org.ctf.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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
}
