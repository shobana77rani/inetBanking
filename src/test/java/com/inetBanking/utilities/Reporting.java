package com.inetBanking.utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter  {

	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public String screenshotPath;

	public void onStart(ITestContext tc) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-report/" + reportName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "shob");

		htmlReporter.config().setDocumentTitle("Internet Banking Test project");
		htmlReporter.config().setReportName("Functional Test Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		
		try {
			screenshotPath = ScreenshotUtil.captureScreenshot(tr.getName());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		logger.log(Status.PASS, "Screenshot is below: " +logger.addScreenCaptureFromPath(screenshotPath,"LOGIN PASSED"));
	}

	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		try {
			screenshotPath = ScreenshotUtil.captureScreenshot(tr.getName());			
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		logger.log(Status.FAIL, tr.getThrowable());
		
		logger.log(Status.FAIL, "Screenshot is below: " +logger.addScreenCaptureFromPath(screenshotPath,"LOGIN FAILED"));
	}

	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel("tr.getName", ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext tc) {
		extent.flush();
	}

}
