package com.circles.life.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.circles.life.config.BaseTest;
import com.circles.life.config.TestGroups;
import com.circles.life.pages.HomePage;
import com.circles.life.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(enabled = true, description = "Write the script for, Login in to website. Verify you email address under My account.", groups = {
			TestGroups.SANITY })
	public void verifyLoginTestSample() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"site-navigation\"]/div[2]/div[2]/div/a[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("kalpeshtest1@gmail.com");
		driver.findElement(By.name("password")).sendKeys("kalpesh123");
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//*[@id=\"st-container\"]/div/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[3]/form/div[4]/div/div/button"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"st-container\"]/div/div/div[1]/div/div/div[2]/div/a[3]/div")).click();
		Thread.sleep(5000);
		String emailId = driver.findElement(By.xpath(
				"//*[@id=\"st-container\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/form/div[3]/div/input"))
				.getAttribute("value");
		Assert.assertEquals(emailId, "kalpeshtest1@gmail.com");
		Thread.sleep(5000);
	}

	@Test(enabled = false, description = "Write the script for, Login in to website. Verify your email address under My account.", groups = {
			TestGroups.SANITY }, priority = 1)
	@Parameters({ "emailId", "emailPassword" })
	public void verifyLoginTest(String un, String pass) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		userEmailId = un;
		userEmailPass = pass;

		System.out.println("User SignUp");
		homePage.clickOnSignUpBtn();
		loginPage.enterEmailId(userEmailId);
		loginPage.enterPassword(userEmailPass);
		loginPage.clickOnSignInBtn();

		System.out.println("Verify Email address under My Account");
		loginPage.clickOnMyAccount();
		Assert.assertEquals(userEmailId, loginPage.getEmailIdText(), "Verify Email address");
	}

	@Test(enabled = false, description = "Write a script to login into Facebook account (test account) from website. And Post a test comment.", groups = {
			TestGroups.SANITY }, priority = 2)
	@Parameters({ "fbUserId", "fbPassword" })
	public void verifyFacebookLogin(String un, String pass) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		fbUserId = un;
		fbPass = pass;

		System.out.println("User SignUp");
		homePage.clickOnSignUpBtn();

		// Store the parent window handle
		String parentWindow = driver.getWindowHandle();
		loginPage.clickOnFbLoginBtn();

		// Switch to child window opened
		String childWindow = driver.getWindowHandle();
		driver.switchTo().window(childWindow);

		// FaceBook Login
		loginPage.enterFbUserId(fbUserId);
		loginPage.enterFbPassword(fbPass);

		// close child window
		driver.close();

		// switch back to parent window
		driver.switchTo().window(parentWindow);
	}
}
