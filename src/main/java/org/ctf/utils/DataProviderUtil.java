package org.ctf.utils;

import org.ctf.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public final class DataProviderUtil {

    private DataProviderUtil() {}

    @DataProvider (parallel = true, name = "LoginPageDataProvider")
    public static Object[][] loginTestData(Method method) {
        if (method.getName().equalsIgnoreCase("validLoginTest"))
            return ExcelReaderUtil.getMultipleColumnData(FrameworkConstants.getLogintestdata(),"valid credentials");
        else if (method.getName().equalsIgnoreCase("invalidLoginTest"))
            return ExcelReaderUtil.getMultipleColumnData(FrameworkConstants.getLogintestdata(),"invalid credentials");
        else if (method.getName().equalsIgnoreCase("emptyCredentialsLoginTest"))
            return ExcelReaderUtil.getMultipleColumnData(FrameworkConstants.getLogintestdata(),"empty credentials");
        return null;
    }

    @DataProvider (parallel = true, name = "AdminSearchDataProvider")
    public static String[] getAdminData(Method method) {
        if (method.getName().equalsIgnoreCase("verifySearchUsingUserName"))
            return ExcelReaderUtil.getSingleColumnData(FrameworkConstants.getAdmintestdata(),"search user name");
        else if (method.getName().equalsIgnoreCase("verifySearchUsingUserType"))
            return ExcelReaderUtil.getSingleColumnData(FrameworkConstants.getAdmintestdata(),"search user type");
        else if (method.getName().equalsIgnoreCase("verifySearchUsingUserStatus"))
            return ExcelReaderUtil.getSingleColumnData(FrameworkConstants.getAdmintestdata(),"search user status");
        else
            return null;
    }
}
