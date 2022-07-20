package com.fb.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fb.base.BaseClass;

public class TestUtil extends BaseClass{
	
	public static long PAGE_LOAD_TIMEOUT = 10;
	public static long IMPLICIT_WAIT = 10;
	
		public static void takeScreenshotAtEndOfTest() throws IOException {
			// Creating instance of File
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(srcFile, new File(currentDir+"/screenshots/"+System.currentTimeMillis()+ ".png"));
			
			System.out.println("the login page screenshot is taken");
		}
}




