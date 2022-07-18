package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pages.HomePage;
import com.pages.SignUpPage;

public class SignUpPageTest extends BaseClass {
	SignUpPage signupPage;
	HomePage homePage;
	
	public SignUpPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		signupPage = new SignUpPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.info("*********** Starting TestCase **************");
		log.info("*********** FacebookTitleTest **************");
		String title = signupPage.validateLoginPageTitle();
		log.info("signup page title is ---->"+title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
		log.info("*********** Ending TestCase ****************");
	}
	@Test(priority=2)
	public void signUpTest() throws InterruptedException {
		log.info("*********** Starting TestCase ***************");
		log.info("*********** FacebookTitleTest ***************");
		homePage = signupPage.signUp("Prakash", "Rathore", "deepakrana.softpower@gmail.com", "admin@123");
		System.out.println("User create account successfully...!");
		Thread.sleep(5000);
		log.info("*********** Ending TestCase *****************");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("*********** Browser is closed ***************");
	}
}
