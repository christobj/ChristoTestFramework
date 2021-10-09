package org.ctf.testcases;

import org.ctf.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    @Test
    public void test01() {
        DriverFactory.getDriver().findElement(By.name("q")).sendKeys("Christob", Keys.ENTER);
    }

}
