package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties pLoad = new Properties();
		pLoad.load(fis);
		String value = pLoad.getProperty(Key);
		return value;
		
	}
}


