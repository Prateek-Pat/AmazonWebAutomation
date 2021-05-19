package com.amazon.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utility.utils;

// We need to put all the constant values in base class, which later can be extended by page & test class
// 1) Handle Properties file
// 2) Driver instance
// 1) Maximize		
// 2) pageLoad method
// 3) implicityTimeout
// 4) get(url) or launch Url
// 3) Browser

// Extends utils for getting dynamic wait time
public class Base {

	public static Properties prop;
	public static WebDriver driver;

	public Base() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\prate\\workspace\\AmazonWebAutomation\\src\\main\\java\\com\\amazon\\properties\\config.properties");
		prop.load(fis);
	}

	// WebDriver Initialization
	public static void Initialization() {

		String BrowserName = prop.getProperty("Browser");
		if (BrowserName.equals("Chrome")) {
			/*System.setProperty("webdriver.chrome.driver","E:\\STUDY Mate\\SELENIUM\\Jar's & Software\\webDriver Chrome\\ChromeDriver 88\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();*/
			WebDriverManager.chromedriver().version("89.0.4").setup();
			driver = new ChromeDriver();
			
		} else if (BrowserName.equals("FireFox")) {
			System.setProperty("webdriver.geko.driver",System.getProperty("user.dir")+ "\\src\\main\\java\\com\\amazon\\drivers\\chromedriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(utils.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(utils.implicitlyWait, TimeUnit.SECONDS); // 

		driver.get(prop.getProperty("baseurl"));
	}

}
