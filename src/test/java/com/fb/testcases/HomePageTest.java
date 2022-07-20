package com.fb.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.base.BaseClass;
import com.fb.pages.HomePage;
import com.fb.pages.LoginPage;

public class HomePageTest extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTest() {
		log.info("*********** Starting TestCase **************");
		log.info("*********** FacebookTitleTest **************");
		String title = homePage.verifyHomePageTitle();
		log.info("login page title is ---->"+title);
		Assert.assertEquals(title, "Facebook");
		log.info("*********** Ending TestCase ****************");
	}
	
	@Test(priority=2)
	public void HomePageUserProfileTest() throws InterruptedException {
		log.info("*********** Starting TestCase ***************");
		log.info("*********** FacebookTitleTest ***************");
		homePage.homePagePost();
		System.out.println("Check User Profile Clickabled ");
		Thread.sleep(5000);
		log.info("*********** Ending TestCase *****************");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("*********** Browser is closed ***************");
	}
}
