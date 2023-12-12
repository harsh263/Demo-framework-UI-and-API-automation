package com.testutils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileHandle {
	
	static Properties prop = new Properties();
	
	public PropertiesFileHandle(String file_name) {
		
		try {
			InputStream input = new FileInputStream(file_name);
			prop.load(input);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String get_property(String key) {
		return prop.getProperty(key);
	}
	public void set_property(String key, String value) {
		prop.setProperty(key, value);
	}

}
