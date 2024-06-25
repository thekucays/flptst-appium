package com.luki.common;

import com.luki.pom.PageLogin;
import io.appium.java_client.android.AndroidDriver;

public class Common {
	public static void startLogin(String uname, String pwd, AndroidDriver driver) {
		// filling login form
		PageLogin.inputUsername(driver).sendKeys("standard_user");
		PageLogin.inputPassword(driver).sendKeys("secret_sauce");
		PageLogin.buttonLogin(driver).click();
	}
}
