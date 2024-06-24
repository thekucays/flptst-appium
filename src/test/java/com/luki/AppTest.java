package com.luki;

import java.net.URL;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import com.luki.pom.PageHome;
import com.luki.pom.PageLogin;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class AppTest {
	
	@Test
	public void testLaunch() throws Exception {
		// options to connect to device and app under test
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
		options.setDeviceName("emulator-5554");
		options.setApp(System.getProperty("user.dir") + "/apk/apptest.apk");
		options.setAppWaitActivity("com.swaglabsmobileapp.MainActivity");
		
		// init driver
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		Thread.sleep(4000);
		
		// filling login form
		PageLogin.inputUsername(driver).sendKeys("standard_user");
		PageLogin.inputPassword(driver).sendKeys("secret_sauce");
		PageLogin.buttonLogin(driver).click();
		
		// filter low to high
		Thread.sleep(4000);
		PageHome.iconFilter(driver).click();
		PageHome.textPriceLowToHigh(driver).click();
		
		// validate filter result
		Thread.sleep(4000);
		List<WebElement> prices = PageHome.listItemPrices(driver);
		System.out.println(((WebElement)prices.get(0)).getText());
		
	}

}
