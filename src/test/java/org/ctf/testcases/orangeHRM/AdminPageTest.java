package org.ctf.testcases.orangeHRM;

import org.ctf.annotations.FrameworkAnnotations;
import org.ctf.enums.CategoryType;
import org.ctf.enums.DeviceType;
import org.ctf.pages.orangehrm.LoginPage;
import org.ctf.testcases.BaseTest;
import org.ctf.utils.DataProviderUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminPageTest extends BaseTest {

    @FrameworkAnnotations (author = "Christob", category = CategoryType.COMMON,device = DeviceType.WINDOWS)
    @Test (dataProviderClass = DataProviderUtil.class)
    public void verifySearchUsingUserName(String userName) {
        Assert.assertTrue(new LoginPage().enterUserName(getUserName()).enterPassword(getPassword()).clickLogin()
                .navigateToAdminTab().searchUser(userName));
    }

    @FrameworkAnnotations (author = "Christob", category = CategoryType.SANITY,device = DeviceType.WINDOWS)
    @Test (dataProviderClass = DataProviderUtil.class)
    public void verifySearchUsingUserType(String userType) {
        Assert.assertTrue(new LoginPage().enterUserName(getUserName()).enterPassword(getPassword()).clickLogin()
                .navigateToAdminTab().searchUserType(userType));
    }

    @FrameworkAnnotations (author = "Christob", category = CategoryType.REGRESSION,device = DeviceType.WINDOWS)
    @Test (dataProviderClass = DataProviderUtil.class)
    public void verifySearchUsingUserStatus(String userStatus) {
        Assert.assertTrue(new LoginPage().enterUserName(getUserName()).enterPassword(getPassword()).clickLogin()
                .navigateToAdminTab().searchUserStatus(userStatus));
    }
}
