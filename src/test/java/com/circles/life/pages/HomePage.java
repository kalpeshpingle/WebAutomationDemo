package com.circles.life.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.circles.life.config.CommonMethods;
import com.circles.life.pageobjects.HomePageObjects;

public class HomePage extends CommonMethods {

	public HomePageObjects homePageObjects = new HomePageObjects();

	/*
	 * Initialize all Web Element in HomePageObjects Class
	 */
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, homePageObjects);
	}

	public void clickOnSignUpBtn() {
		clickOnElement(homePageObjects.getSignUpButton());
	}
}
