package org.ctf.testcases.orangeHRM;

import org.ctf.annotations.FrameworkAnnotations;
import org.ctf.enums.CategoryType;
import org.ctf.enums.DeviceType;
import org.ctf.pages.orangehrm.LoginPage;
import org.ctf.testcases.BaseTest;
import org.ctf.utils.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @FrameworkAnnotations(category = CategoryType.SANITY, device = DeviceType.ANDROID, author = "Christob")
    @Test (dataProviderClass = DataProviderUtil.class)
    public void validLoginTest(String userName, String password) {
        String title = new LoginPage().enterUserName(userName).enterPassword(password).clickLogin()
                            .clickWelcome().clickLogout()
                            .getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @FrameworkAnnotations(category = CategoryType.REGRESSION, device = DeviceType.MAC, author = "Christob")
    @Test (dataProviderClass = DataProviderUtil.class)
    public void invalidLoginTest(String userName, String password) {
        String errorMessage = new LoginPage().enterUserName(userName).enterPassword(password).getErrorMessage();
        Assert.assertEquals(errorMessage,"Invalid credentials");
    }

    @FrameworkAnnotations(category = CategoryType.REGRESSION, device = DeviceType.WINDOWS, author = "Christob")
    @Test (dataProviderClass = DataProviderUtil.class)
    public void emptyCredentialsLoginTest(String userName,String password) {
        String errorMessage = new LoginPage().enterPassword(password).getErrorMessage();
        Assert.assertEquals(errorMessage,"Username cannot be empty");
    }
}
