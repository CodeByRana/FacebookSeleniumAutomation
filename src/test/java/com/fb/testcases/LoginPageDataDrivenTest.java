package com.fb.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fb.base.BaseClass;
import com.fb.pages.LoginPage;
import com.fb.utils.XLUtility;

public class LoginPageDataDrivenTest extends BaseClass {
	LoginPage loginPage;
	// initialize Object
	public LoginPageDataDrivenTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
	}

	@Test(dataProvider = "LoginData")
	public void loginTest(String username, String password) throws InterruptedException {
		System.out.println(username +" "+password);
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		// get the data from excel
		String path = "C:\\CFP-program\\FacebookSeleniumProject\\src\\main\\java\\com\\fb\\testdata\\facebook-application.xlsx";
		XLUtility xlutil = new XLUtility(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		//Read the data and manage in excel file row and column
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}

		return loginData;
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
