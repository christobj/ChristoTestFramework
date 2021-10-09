package org.ctf.utils;

import org.ctf.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

public final class PropertyReader {

    private PropertyReader() {
        //Preventing from creating instances
    }

    private static Properties properties = new Properties();
    private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigpropertypath());
            properties.load(fileInputStream);
            properties.entrySet().forEach(entrySet -> CONFIGMAP.put(String.valueOf(entrySet.getKey()), String.valueOf(entrySet.getValue())));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key)  {
        //if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key)))
            //Need log here
        return CONFIGMAP.get(key);
    }
}
