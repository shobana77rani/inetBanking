package com.inetBanking.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage { 
	
	public LoginPage(WebDriver rdriver) {
			
		super(rdriver);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText ="Log out")
	@CacheLookup
	WebElement btnLogout;
	
	
	public void enterUserName(String uName) {
		txtUserName.sendKeys(uName);
	}
	
	public void enterPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	public void clickDoNotSellInfo() {
		
		WebElement frame = ldriver.findElement(By.id("ccpa-consent-notice"));
		ldriver.switchTo().frame(frame);
		WebElement link = ldriver.findElement(By.linkText("Do Not Sell My Info"));
		link.click();
		WebElement btn = ldriver.findElement(By.className("okButton"));
		btn.click();
		ldriver.switchTo().parentFrame();
	}
	
	public boolean isAlertPresent() {
		
		try {
			ldriver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		
	}
}
