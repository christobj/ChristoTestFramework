package org.ctf.testcases;

import org.ctf.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{

    @Test
    public void test02() {
        DriverFactory.getDriver().findElement(By.name("q")).sendKeys("Raj", Keys.ENTER);
    }

    @Test
    public void test03() {
        DriverFactory.getDriver().findElement(By.name("q")).sendKeys("Arputha", Keys.ENTER);
    }
}
