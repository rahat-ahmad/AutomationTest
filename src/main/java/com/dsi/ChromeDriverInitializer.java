package com.dsi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverInitializer {
	
	public WebDriver getChromeDriver() {
		System.setProperty("webdriver.chrome.driver","webdriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();  
		options.setHeadless(true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
}
