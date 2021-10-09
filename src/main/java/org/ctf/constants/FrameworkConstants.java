package org.ctf.constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
        // Restricting to create instances
    }

    private static final String PATHTOTESTRESOURCES = System.getProperty("user.dir") + "/src/test/resources/";
    private static final String CHROMEDRIVERPATH = PATHTOTESTRESOURCES + "executables/chromedriver.exe";
    private static final String CONFIGPROPERTYPATH = PATHTOTESTRESOURCES + "properties/config.properties";

    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }

    public static String getConfigpropertypath() {
        return CONFIGPROPERTYPATH;
    }
}
