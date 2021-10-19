package org.ctf.testcases.orangeHRM;

import org.ctf.pages.orangehrm.LoginPage;
import org.ctf.testcases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {

    @Test
    public void verifySearchUsingUserName() {
        Assert.assertTrue(new LoginPage().enterUserName("Admin").enterPassword("admin123").clickLogin()
                .navigateToAdminTab().searchUser("Aravind"));
    }

    @Test
    public void verifySearchUsingUserType() {
        Assert.assertTrue(new LoginPage().enterUserName("Admin").enterPassword("admin123").clickLogin()
                .navigateToAdminTab().searchUserType("All"));
    }
}
