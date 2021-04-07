package com.automation.utilities;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigDataProvider {
	
	
	Properties pro;
	public ConfigDataProvider()
	{
		
		File file=new File("./Configs/Config.properties");
		try {
			FileInputStream fin=new FileInputStream(file);
			pro=new Properties();
			pro.load(fin);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	
	public String getConfigData(String key)
	{
		return pro.getProperty(key);
	}

}
