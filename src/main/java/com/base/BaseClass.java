package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.utils.TestUtil;
import com.utils.WebEventListener;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log = Logger.getLogger(BaseClass.class);
	//public static Logger logger = LogManager.getLogger(BaseClass.class);
	public BaseClass() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\CFP-program\\FacebookSeleniumProject\\src\\main\\java\\com\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() throws IOException, InterruptedException {

		String browserName = prop.getProperty("browser");
		log.info("*********** Starting TestCases Executions *************");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("*********** Launching chrome browser ***********");
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("*********** Launching firefox browser ***********");
		} else {
			System.out.println("No browser found !!");
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//Now create object of EventLitenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		// maximize the window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		// define the URL
		driver.get(prop.getProperty("url"));
		log.info("*********** Entering application URL ***********");
		String urlFromWebPage = driver.getCurrentUrl();
		if(urlFromWebPage.equals("https://www.facebook.com/")) {
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		Thread.sleep(2000);
	}

}
