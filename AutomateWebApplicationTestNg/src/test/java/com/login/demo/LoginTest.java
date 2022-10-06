package com.login.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest {
	
	WebDriver driver;
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	public void closeBrowser() {

		driver.quit();

	}

	public void performTest() throws InterruptedException {
		Thread.sleep(2000);
		driver.get("https://leetcode.com/accounts/login/");
		WebElement username = driver.findElement(By.id("id_login"));
		WebElement password = driver.findElement(By.id("id_password"));
		WebElement login = driver.findElement(By.id("signin_btn"));
		// Entering credentials
		System.out.println("Login Automation Started....");
		username.clear();// clear id_login field if any filled
		username.click();
		username.sendKeys("ankit11081998@gmail.com");// use your email id
		System.out.println("Username is Entered.");

		password.clear();// clear id_password field if any filled
		password.click();
		password.sendKeys("Ankit@1998");// use your password
		System.out.println("Password is Entered");
		Thread.sleep(2000);
		login.click();
		Thread.sleep(2000);
		System.out.println("Clicked On Login Button");

	}

	@Test
	public void loginTest() {

		LoginTest obj = new LoginTest();
		try {
			obj.launchBrowser();
			obj.performTest();
			obj.closeBrowser();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Testing is Going to start..");

	}

	@AfterTest
	public void afterTest() {
		System.out.println("Testing is Done!");
	}

	
	

}
