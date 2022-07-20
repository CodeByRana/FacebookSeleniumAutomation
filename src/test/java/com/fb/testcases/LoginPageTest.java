package com.fb.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.base.BaseClass;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;


public class LoginPageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		log.info("*********** Starting TestCase **************");
		log.info("*********** FacebookTitleTest **************");
		String title = loginPage.validateLoginPageTitle();
		log.info("login page title is ---->"+title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
		log.info("*********** Ending TestCase ****************");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		log.info("*********** Starting TestCase ***************");
		log.info("*********** FacebookTitleTest ***************");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		System.out.println("User logged in successfully...!");
		Thread.sleep(5000);
		log.info("*********** Ending TestCase *****************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("*********** Browser is closed ***************");
	}
}
