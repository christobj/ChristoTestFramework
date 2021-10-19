package org.ctf.pages.orangehrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public final class HomePage extends BasePage{

    public HomePage () {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy (id = "welcome")
    private WebElement linkWelcome;

    @FindBy (xpath = "//a[text() = 'Logout']")
    private WebElement linkLogout;

    @FindBy (id = "menu_admin_viewAdminModule")
    private WebElement tabAdmin;

    public HomePage clickWelcome() {
        clickOn(linkWelcome);
        return this;
    }

    public LoginPage clickLogout() {
        clickOnInterceptedElement(linkLogout,30);
        return new LoginPage();
    }

    public AdminPage navigateToAdminTab() {
        clickOn(tabAdmin);
        return new AdminPage();
    }
}
