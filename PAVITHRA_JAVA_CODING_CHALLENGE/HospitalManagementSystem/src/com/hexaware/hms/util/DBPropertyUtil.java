package com.hexaware.hms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
	
	public static String getConnectionString(String propertyFileName) throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(propertyFileName);
        properties.load(file);
        return properties.getProperty("db.url");
    }


}
