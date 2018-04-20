package com.circles.life.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.circles.life.config.CommonMethods;
import com.circles.life.pageobjects.LoginPageObject;

public class LoginPage extends CommonMethods {

	public LoginPageObject loginPageObject = new LoginPageObject();

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, loginPageObject);
	}

	public void enterEmailId(String id) {
		sleep(5000);
		enterTextInField(loginPageObject.getEmailIdField(), id);
	}

	public void enterPassword(String pass) {
		enterTextInField(loginPageObject.getPasswordField(), pass);
	}

	public void clickOnSignInBtn() {
		clickOnElement(loginPageObject.getSignInBtn());
	}

	public void clickOnMyAccount() {
		clickOnElement(loginPageObject.getMyAccount());
	}

	public String getEmailIdText() {
		String text= getAttributeValue(loginPageObject.getEmailIdValue(), "value");
		return text;
	}
	
	public void clickOnFbLoginBtn() {
		clickOnElement(loginPageObject.getFbLoginBtn());
	}
	
	public void enterFbUserId(String id) {
		enterTextInField(loginPageObject.getFbUserIdField(), id);
	}
	
	public void enterFbPassword(String pass) {
		enterTextInField(loginPageObject.getFbPasswordField(), pass);
	}
	
}
