package com.testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		try {
			prop = loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod(alwaysRun = true)
	public void setUpMethods() {
		initializeDriver();
	}

	@AfterTest(alwaysRun = true)
	public void tearDown(){
		driver.close();
	}

	protected Properties loadProperties() throws IOException {
		prop = new Properties();
		String fileName = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(fileName);
		prop.load(fis);
		return prop;
	}

	protected WebDriver initializeDriver() {
		driver = new ChromeDriver(setUpChromeOptions());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	protected static ChromeOptions setUpChromeOptions() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("webdriver_location"));
		System.setProperty("webdriver.chrome.silentOutput", "true");

		ChromeOptions options = new ChromeOptions();

		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		logPrefs.enable(LogType.BROWSER, Level.ALL);

		options.addArguments("disable-infobars");
		options.addArguments("--no-sandbox");
		options.addArguments("--dns-prefetch-disable");
		options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
}
