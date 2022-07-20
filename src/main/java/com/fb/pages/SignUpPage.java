package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.fb.base.BaseClass;

public class SignUpPage extends BaseClass {
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/a[1]")
	private WebElement CreateAccountBtn;
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstname;
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastname;
	@FindBy(xpath = "//input[contains(@name,'reg_email__')]")
	private WebElement emailOrPhoneNo;
	@FindBy(xpath = "//input[contains(@name,'reg_email_confirmation__')]")
	private WebElement confirm_emailOrPhoneNo;
	@FindBy(xpath = "//input[contains(@name,'reg_passwd__')]")
	private WebElement password;
	@FindBy(xpath = "//select[@id='day']")
	private WebElement selectDate;
	@FindBy(xpath = "//select[@id='month']")
	private WebElement selectMonth;
	@FindBy(xpath = "//select[@id='year']")
	private WebElement selectYear;
	@FindBy(xpath = "//label[contains(text(),'Male')]")
	private WebElement genderOption;
	@FindBy(xpath = "//button[@name='websubmit']")
	private WebElement SignUpBtn;

	// Initializing the page Objects
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage signUp(String fn, String ln, String em, String c_em, String pwd) {
		CreateAccountBtn.click();
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		emailOrPhoneNo.sendKeys(em);
		confirm_emailOrPhoneNo.sendKeys(c_em);
		password.sendKeys(pwd);
		Select dateDropdown = new Select(selectDate);
		dateDropdown.selectByValue("19");
		Select monthDropdown = new Select(selectMonth);
		monthDropdown.selectByVisibleText("Feb");
		Select yearDropdown = new Select(selectYear);
		yearDropdown.selectByValue("1995");
		genderOption.click();
		SignUpBtn.click();
		return new HomePage();
	}
}
