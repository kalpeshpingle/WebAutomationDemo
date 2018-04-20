package com.circles.life.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lombok.Data;

@Data
public class LoginPageObject {

	@FindBy(name = "email")
	private WebElement emailIdField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//*[contains(text(), 'Sign In')]")
	private WebElement signInBtn;

	@FindBy(xpath = "//*[contains(text(), 'MY ACCOUNT')]")
	private WebElement myAccount;

	@FindBy(xpath = "//*[@id=\\\"st-container\\\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div/div[2]/div[2]/div/div/div/form/div[3]/div/input")
	private WebElement emailIdValue;

	@FindBy(xpath = "//*[contains(text(), 'Facebook')]")
	private WebElement fbLoginBtn;

	@FindBy(id = "email")
	private WebElement fbUserIdField;

	@FindBy(id = "pass")
	private WebElement fbPasswordField;

}
