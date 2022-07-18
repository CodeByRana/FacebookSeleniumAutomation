package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]/div[1]/div[1]/div[1]/svg[1]/g[1]/image[1]")
	private WebElement clickOnUserProfile;
	//Initializing the Page Object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public HomePage homePagePost() {
		clickOnUserProfile.click();
		return new HomePage();
	}
	
}
