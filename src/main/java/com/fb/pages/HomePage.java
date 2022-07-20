package com.fb.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.base.BaseClass;

public class HomePage extends BaseClass {
	@FindBy(xpath = "//span[contains(text(),'Anmol Rana')]")
	private WebElement clickOnUserName;

	// Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public HomePage homePagePost() {
		clickOnUserName.click();
		return new HomePage();
	}

}
