package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src = new File("src/test/resources/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		return pro.getProperty("baseURL");
	}
	
	public String getUser(){
		return pro.getProperty("userName");
	}
	public String getPassword(){
		return pro.getProperty("password");
	}
	public String getChromepath(){
		return pro.getProperty("chromepath");
	}

	public String getFirefoxpath() {
		return pro.getProperty("firefoxpath");
	}
	

}
