package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.inetBanking.testCases.BaseClass;

public class ScreenshotUtil extends BaseClass{
	public static String captureScreenshot(String tname) throws IOException {
		String dateName = new SimpleDateFormat("YYYY.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/screenshots/"+tname+"-"+dateName+".png";
		File target= new File(destinationFile);
		FileUtils.copyFile(source, target);
		return destinationFile;
	}
}
