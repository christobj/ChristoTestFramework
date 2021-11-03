package org.ctf.pages.orangehrm;

import org.ctf.reports.ExtentLogger;
import org.ctf.reports.ExtentReport;
import org.ctf.reports.ExtentReportManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy (id = "txtUsername")
    private WebElement textInputUserName;

    @FindBy (xpath = "//input[@id='txtPassword' and @type='password']")
    private WebElement textInputPassword;

    @FindBy (id = "btnLogin")
    private WebElement buttonLogin;

    @FindBy (id = "spanMessage")
    private WebElement messageInvalidCredentials;

    public LoginPage enterUserName(String userName) {
        sendKeys(textInputUserName,userName);
        ExtentLogger.pass("Entered Username as "+userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(textInputPassword,password);
        ExtentLogger.pass("Entered Password as " +password);
        return this;
    }

    public HomePage clickLogin() {
        clickOn(buttonLogin);
        return new HomePage();
    }

    public String getTitle() {
        return getBrowserTitle();
    }

    public String getErrorMessage() {
        clickOn(buttonLogin);
        if (messageInvalidCredentials.isDisplayed())
            return messageInvalidCredentials.getText();
        else {
            System.out.println("Error message not displayed");
            return null;
        }
    }
}
