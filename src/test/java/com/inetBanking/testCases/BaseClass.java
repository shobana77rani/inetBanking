package com.inetBanking.testCases;


import java.io.IOException;
import java.time.Duration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc = new ReadConfig();

	public String baseURL = rc.getApplicationURL();
	public static WebDriver driver;
	protected static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {

		logger = LogManager.getLogger(this.getClass());

		if (br.equals("chrome")) {
	//		System.setProperty("webdriver.chrome.driver", rc.getChromepath());
			driver = new ChromeDriver();
			logger.info("chromeBrowser");
		} else if (br.equals("firefox")) {
		//	System.setProperty("webdriver.gecko.driver", rc.getFirefoxpath());
		//	File pathBinary = new File("/Applications/Firefox.app/Contents/MacOS/firefox");
		//	FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
		//	DesiredCapabilities desired = DesiredCapabilities.firefox();
		//	FirefoxOptions options = new FirefoxOptions();
		//	desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
			driver = new FirefoxDriver();
			logger.info("firefoxBrowser");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
	}

}
