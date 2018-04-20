package com.circles.life.config;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
	public static WebDriver driver;
	public static String baseUrl = "";
	public static String userEmailId = "";
	public static String userEmailPass = "";
	public static String fbUserId = "";
	public static String fbPass = "";

	@BeforeSuite(alwaysRun = true)
	@Parameters({ "baseUrl" })
	public void startBrowser(String url) {
		baseUrl = url;
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		System.out.println("Set desired capabilities");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		System.out.println("Launch Browser");
		driver = new ChromeDriver(cap);
		driver.get(baseUrl);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}

	@AfterSuite(alwaysRun = true)
	public void quitBrowser() {
		System.out.println("Close Browser");
		driver.close();
		driver.quit();
	}
}
