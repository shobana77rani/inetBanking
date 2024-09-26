package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ScreenshotUtil;


public class TC_AddNewCustomer_001 extends BaseClass{
	
//	private static int doNotSellCount=1;
	@Test
	public void addCustomer() throws InterruptedException, IOException {
		
		
		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		
//		if(doNotSellCount==1) {
//			lp.clickDoNotSellInfo();
//			++doNotSellCount;
//		}
		Thread.sleep(1000);
		lp.enterUserName(rc.getUser());
		logger.info("username entered");
		lp.enterPassword(rc.getPassword());
		logger.info("password entered");
		lp.clickLogin();
		Thread.sleep(1000);
		logger.info("Login button pressed");
		
		
		
		AddCustomerPage addCust = new AddCustomerPage(driver);
		addCust.clickNewCustomerLink();
		logger.info("customer link clicked");
		Thread.sleep(1000);
	//	addCust.skipAd();
		
		
		addCust.custName(RandomStringUtils.randomAlphabetic(5));
		addCust.custGender("female");
		addCust.custDOB("15","11","2010");
		addCust.custAddress("INDIA");
		addCust.custCity("Chennai");
		addCust.custState("TN");
		addCust.custPinNo("500274");
		addCust.custTelephoneNo(RandomStringUtils.randomNumeric(10));
		String email = RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
		addCust.custEmailid(email);
		logger.info("email: "+ email);
		String password = RandomStringUtils.randomAlphanumeric(8);
		addCust.custPassword(password);
		logger.info("pass: "+ password);
		ScreenshotUtil.captureScreenshot("add customer");
		addCust.custSubmit();
		Thread.sleep(3000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			ScreenshotUtil.captureScreenshot("registered-customer");
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			ScreenshotUtil.captureScreenshot("registered-customer");
			Assert.assertTrue(false);
		}
		
	}

}
