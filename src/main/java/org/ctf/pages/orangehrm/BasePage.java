package org.ctf.pages.orangehrm;

import org.ctf.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected void sleep (int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getBrowserTitle() {
        return getDriver().getTitle();
    }

    protected void sendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    protected boolean clickOn (WebElement element) {
        boolean isClickSuccess = true;
        try {
            element.click();
        } catch (Exception e) {
            isClickSuccess = false;
            //need to add log
        }
        return isClickSuccess;
    }

    protected void clickOnInterceptedElement (WebElement element, int withInSeconds) {
        while (withInSeconds > 0) {
            if (clickOn(element))
                break;
            else
                sleep(1);
            withInSeconds--;
        }
    }
}
