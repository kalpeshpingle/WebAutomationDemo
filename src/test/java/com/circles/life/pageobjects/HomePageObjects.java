package com.circles.life.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import lombok.Data;

@Data
public class HomePageObjects {
	
	@FindBy(xpath = "//*[contains(text(), 'Sign up')]")
	private WebElement signUpBtn;	
}
