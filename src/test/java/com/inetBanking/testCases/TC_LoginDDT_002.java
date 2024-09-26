package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass{
	
	private static int doNotSellCount=1;

	@Test(dataProviderClass = com.inetBanking.utilities.DataUtil.class, dataProvider = "LoginData")
	public void loginTest(String userName,String password) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		driver.get(baseURL);
		
		if(doNotSellCount==1) {
			lp.clickDoNotSellInfo();
			++doNotSellCount;
		}
		Thread.sleep(3000);

		lp.enterUserName(userName);
		logger.info("username: " + userName);
		lp.enterPassword(password);
		logger.info("password: " + password);
		
		lp.clickLogin();
		Thread.sleep(3000);
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
//			lp.clickLogout();
//			driver.switchTo().alert().accept();
//			driver.switchTo().defaultContent();
			
		}
		
	}
	
	
	

}
