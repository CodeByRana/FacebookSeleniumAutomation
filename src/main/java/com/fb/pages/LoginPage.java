package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.base.BaseClass;

public class LoginPage extends BaseClass {
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='email']")
	private WebElement username;
	@FindBy(xpath="//input[@id='pass']")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement LoginBtn;
	// Initializing the page Objects
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		//Actions
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		public HomePage login(String un, String pwd) {
			username.sendKeys(un);
			password.sendKeys(pwd);
			LoginBtn.click();
			
			return new HomePage();
		}
}
