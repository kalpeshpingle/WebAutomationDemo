package com.circles.life.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lombok.Data;

/*
 * Using lombok library to avoid creation getter and setter
 */
@Data
public class HomePageObjects {

	@FindBy(xpath = "//a[@href='https://shop.circles.life/login']")
	private WebElement signUpButton;
}
