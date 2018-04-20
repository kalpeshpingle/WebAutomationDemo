package com.circles.life.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.circles.life.config.BaseTest;
import com.circles.life.config.TestGroups;
import com.circles.life.pages.HomePage;
import com.circles.life.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test(enabled = true, description = "Write the script for, Login in to website. Verify your email address under My account.", groups = {
			TestGroups.SANITY }, priority = 1)
	@Parameters({ "emailId", "emailPassword" })
	public void verifyLoginTest(String un, String pass) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		userEmailId = un;
		userEmailPass = pass;

		System.out.println("Verify User Login");
		homePage.clickOnSignUpBtn();
		loginPage.enterEmailId(userEmailId);
		loginPage.enterPassword(userEmailPass);
		loginPage.clickOnSignInBtn();

		System.out.println("Verify Email address under My account");
		loginPage.clickOnMyAccount();

		System.out.println("Email address Under My Account Tab :" + loginPage.getEmailIdText());
		Assert.assertEquals(userEmailId, loginPage.getEmailIdText(), "Verify Email address");
		loginPage.clickOnLogoutBtn();
	}

	/*
	 * Below TC is Block because of 2 reason - 1.Not able to click on
	 * "Login with FaceBook" Button,as it takes time to load. 2.Not getting Post
	 * comment option after login into faceBook.
	 */
	@Test(enabled = true, description = "Write a script to login into Facebook account (test account) from website. And Post a test comment.", groups = {
			TestGroups.SANITY }, priority = 2)
	@Parameters({ "fbUserId", "fbPassword" })
	public void verifyFacebookLogin(String uName, String pass) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = new LoginPage(driver);
		fbUserId = uName;
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
