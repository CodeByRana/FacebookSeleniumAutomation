package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;

public class SignUpPage extends BaseClass {
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[5]/a[1]")
	private WebElement CreateAccountBtn;
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstname;
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	@FindBy(xpath="//input[contains(@name,'reg_email__')]")
	private WebElement emailOrPhoneNo;
	@FindBy(xpath="//input[contains(@name,'reg_passwd__')]")
	private WebElement password;
	@FindBy(xpath="//select[@name='birthday_day' and @id='day']')]")
	private WebElement selectDate;
	@FindBy(xpath="//select[@name='birthday_month' and @id='month']")
	private WebElement selectMonth;
	@FindBy(xpath="//select[@name='birthday_year' and @id='year']")
	private WebElement selectYear;
	@FindBy(xpath="//input[contains(@type='radio' and @value='2'")
	private WebElement genderOption;
	@FindBy(xpath="//button[@type='submit' or name='websubmit']")
	private WebElement SignUpBtn;
	
	// Initializing the page Objects
			public SignUpPage() {
				PageFactory.initElements(driver, this);
			}
			//Actions
			public String validateLoginPageTitle() {
				return driver.getTitle();
			}

			public HomePage signUp(String fn, String ln, String em, String pwd) {
				CreateAccountBtn.click();
				firstname.sendKeys(fn);
				lastname.sendKeys(ln);
				emailOrPhoneNo.sendKeys(em);
				password.sendKeys(pwd);
				Select dateDropdown = new Select(selectDate);
				dateDropdown.selectByValue("19");
				Select monthDropdown = new Select(selectMonth);
				monthDropdown.selectByValue("Feb");
				Select yearDropdown = new Select(selectYear);
				yearDropdown.selectByValue("1995");
				genderOption.click();
				SignUpBtn.click();
				return new HomePage();
			}
}
