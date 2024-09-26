package com.inetBanking.testCases;

import org.testng.annotations.Test;

import org.testng.Assert;
import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	private static int doNotSellCount=1;

	@Test
	public void loginTest() throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		
		if(doNotSellCount==1) {
			lp.clickDoNotSellInfo();
			++doNotSellCount;
		}
		Thread.sleep(1000);

		lp.enterUserName(rc.getUser());
		logger.info("username: " + rc.getUser());
		lp.enterPassword(rc.getPassword());
		logger.info("password: " + rc.getPassword());
		
		lp.clickLogin();
		Thread.sleep(1000);
		logger.info("Login button pressed");
		
		
		if(lp.isAlertPresent()==true) {
			logger.info("Login test failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			
		}
		else {
			logger.info("Logintest passed");			
			Assert.assertTrue(true);
			Thread.sleep(3000);			
		}
		
	}
}
