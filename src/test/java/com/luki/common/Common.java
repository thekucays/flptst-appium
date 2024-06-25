package com.luki.common;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;

import com.luki.pom.PageLogin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Common {
	public static void startLogin(String uname, String pwd, AndroidDriver driver) {
		// filling login form
		PageLogin.inputUsername(driver).sendKeys("standard_user");
		PageLogin.inputPassword(driver).sendKeys("secret_sauce");
		PageLogin.buttonLogin(driver).click();
	}
	
	public static boolean checkElementExistsByText(String text, AndroidDriver driver) throws Exception {
		List<WebElement> elements = driver.findElements(By.xpath("//*[@text='" + text + "']"));
		
		boolean result = false;
		if(elements.size() != 0) {
			result = true;
		}
		
		return result;
	}
	
	public static boolean checkElementExistsByAccessibilityID(String accID, AndroidDriver driver) throws Exception {
		List<WebElement> elements = driver.findElements(AppiumBy.accessibilityId(accID));
		
		return elements.isEmpty();
	}
	
	public static void scrollVertical(double deltaY, AndroidDriver driver) {
		Dimension size = driver.manage().window().getSize();
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endX = startX;
		int endY = (int) (size.getHeight() * deltaY);
		
		PointerInput finger1 = new PointerInput(Kind.TOUCH, "finger1");
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200)))
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(sequence));
	}
}
