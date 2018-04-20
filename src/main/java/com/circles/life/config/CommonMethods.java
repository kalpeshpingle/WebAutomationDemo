package com.circles.life.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	WebDriver driver;

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Method to click on Web Element
	 */
	public void clickOnElement(WebElement elem) {
		waitForPresent(elem, 15000);
		elem.click();
	}

	/*
	 * Method to wait for visibility for Web Element
	 */
	public void waitForPresent(WebElement elem, long timeout) {
		WebDriverWait Wait = new WebDriverWait(driver, timeout);
		Wait.until(ExpectedConditions.visibilityOf(elem));
	}

	/*
	 * Method to enter Text in Web Element Field
	 */
	public void enterTextInField(WebElement elem,String test) {
		waitForPresent(elem, 15000);
		elem.clear();
		elem.sendKeys(test);
	}
	
	/*
	 * Method to get attribute value of Web Element
	 */
	public String getAttributeValue(WebElement elem,String name) {
		sleep(10000);
		return elem.getAttribute(name);
	}
	
	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}
