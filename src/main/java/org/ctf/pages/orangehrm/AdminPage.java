package org.ctf.pages.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdminPage extends BasePage {

    public AdminPage () {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy (id = "btnAdd")
    private WebElement buttonAdd;

    @FindBy (id = "searchSystemUser_userName")
    private WebElement searchUserName;

    @FindBy (id = "searchBtn")
    private WebElement buttonSearch;

    @FindBy (id = "searchSystemUser_userType")
    private WebElement selectUserType;

    private WebElement getUser (String username) {
        String gridUserList = "//div[@id='tableWrapper']//a[contains(text(),'user')]";
        return getDriver().findElement(By.xpath(gridUserList.replace("user",username)));
    }

    private int getUserCount() {
        List<WebElement> userList = getDriver().findElements(By.xpath("//div[@id='tableWrapper']//tbody//a"));
        return userList.size();
    }

    private WebElement getUserTypeElement (String type) {
        String gridUserType = "//div[@id='tableWrapper']//td[text()='type']";
        return getDriver().findElement(By.xpath(gridUserType.replace("type",type)));
    }

    private List<WebElement> getUserType(String type) {
        String gridUserType = "//div[@id='tableWrapper']//td[text()='type']";
        return getDriver().findElements(By.xpath(gridUserType.replace("type",type)));
    }

    private void selectUserType (String type) {
        Select select = new Select(selectUserType);
        select.selectByVisibleText(type);
    }

    private void search() {
        clickOn(buttonSearch);
    }

    public boolean searchUser(String user) {
        boolean userDisplayed = false;
        sendKeys(searchUserName, user);
        search();
        if (getUser(user).isDisplayed())
            userDisplayed = true;
        return userDisplayed;
    }

    public boolean searchUserType(String type) {
        boolean isFilterProper = false;
        selectUserType(type);
        search();
        if (type.equalsIgnoreCase("Admin") || type.equalsIgnoreCase("ESS")) {
            if (getUserType(type).size() == getUserCount())
                isFilterProper = true;
        } else if (type.equalsIgnoreCase("All") &&
                (getUserTypeElement("Admin").isDisplayed() && getUserTypeElement("ESS").isDisplayed())) {
                isFilterProper = true;
        }
        return isFilterProper;
    }
}
