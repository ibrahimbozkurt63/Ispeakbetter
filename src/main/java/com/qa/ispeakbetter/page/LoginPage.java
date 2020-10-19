package com.qa.ispeakbetter.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.ispeakbetter.util.ElementUtil;

public class LoginPage {

	// Locatars
	// Constructors
	// Page Methods

	WebDriver driver;
	ElementUtil elementUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);

	}

		By goodEvening = By.id("dashboard_goodday");
		public String getAccountName() {
		return elementUtil.doGetText(goodEvening);

	}

}
