package org.ctf.utils;

import org.ctf.constants.FrameworkConstants;
import org.ctf.enums.CoreConfigProperties;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

public final class PropertyReaderUtil {

    private PropertyReaderUtil() {
        //Preventing from creating instances
    }

    private static Properties properties = new Properties();
    private static final HashMap<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigpropertypath());
            properties.load(fileInputStream);
            properties.entrySet().forEach(entrySet ->
                    CONFIGMAP.put(String.valueOf(entrySet.getKey()), String.valueOf(entrySet.getValue()).trim()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getValue(CoreConfigProperties key)  {
        //if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toString().toLowerCase)))
            //Need log here
        return CONFIGMAP.get(key.toString().toLowerCase());
    }
}
