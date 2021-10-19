package org.ctf.testcases.orangeHRM;

import org.ctf.pages.orangehrm.LoginPage;
import org.ctf.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginTest() {
        String title = new LoginPage().enterUserName("Admin").enterPassword("admin123").clickLogin()
                            .clickWelcome().clickLogout()
                            .getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }
}
