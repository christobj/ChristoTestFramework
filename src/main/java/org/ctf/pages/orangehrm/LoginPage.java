package org.ctf.pages.orangehrm;

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

    public LoginPage enterUserName(String userName) {
        sendKeys(textInputUserName,userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(textInputPassword,password);
        return this;
    }

    public HomePage clickLogin() {
        clickOn(buttonLogin);
        return new HomePage();
    }

    public String getTitle() {
        return getBrowserTitle();
    }
}
