package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {
	
	public AddCustomerPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(how = How.LINK_TEXT,using = "New Customer")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(how = How.XPATH, using= "(//table[@class='layout']//input)[1]")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.XPATH, using = "//table[@class='layout']//input[@value='m']")
	@CacheLookup
	WebElement rdGenderMale;
	
	@FindBy(how = How.XPATH, using = "//table[@class='layout']//input[@value='f']")
	@CacheLookup
	WebElement rdGenderFemale;

	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;

	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;

	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;

	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtstate;

	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;

	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;

	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;

	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnSubmit;
	
	public void clickNewCustomerLink() {
		lnkAddNewCustomer.click();
	}
	
	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}
	
	public void custGender(String cgender) {
		if(cgender=="female") {
		rdGenderFemale.click();
		}
	}

	public void custDOB(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custCity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custPinNo(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custTelephoneNo(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custEmailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custPassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custSubmit() {
		btnSubmit.click();
	}
	
	public void skipAd() {
		System.out.println("skipad clicked");
	//	WebElement frame = ldriver.findElement(By.id("ad_iframe"));
		ldriver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		ldriver.switchTo().frame("ad_iframe");
		WebElement btnDismissAd=ldriver.findElement(By.id("dismiss-button"));
		btnDismissAd.click();
		ldriver.switchTo().defaultContent();
	}
	
}
