package org.ctf.constants;

import org.ctf.enums.CoreConfigProperties;
import org.ctf.utils.PropertyReaderUtil;

public final class FrameworkConstants {

    private FrameworkConstants() {
        // Restricting to create instances
    }

    private static final String PATHTOTESTRESOURCES = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String CONFIGPROPERTYPATH = PATHTOTESTRESOURCES + "properties/config.properties";
    private static final String LOGINTESTDATA = PATHTOTESTRESOURCES + "testData/LoginTestData.xlsx";
    private static final String ADMINTESTDATA = PATHTOTESTRESOURCES + "testData/AdminTestData.xlsx";
    private static final String RUNMANGERFILE = PATHTOTESTRESOURCES + "runManager/RunManager.xlsx";
    private static final String PATHTOEXTENTREPORTS = System.getProperty("user.dir") + "/extent-report-output/";

    public static String getConfigpropertypath() {
        return CONFIGPROPERTYPATH;
    }

    public static String getLogintestdata() { return LOGINTESTDATA; }

    public static String getAdmintestdata() { return ADMINTESTDATA; }

    public static String getRunmanger() { return RUNMANGERFILE; }

    public static String getPathtoextentreports() {
        if (PropertyReaderUtil.getValue(CoreConfigProperties.OVERRIDEEXTENTREPORTS).equalsIgnoreCase("no")) {
            return PATHTOEXTENTREPORTS + System.currentTimeMillis() + "/index.html";
        } else {
            return PATHTOEXTENTREPORTS + "index.html";
        }
    }
}
