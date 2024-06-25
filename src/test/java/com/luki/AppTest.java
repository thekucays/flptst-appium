package com.luki;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import com.luki.common.Common;
import com.luki.pom.PageHome;
import com.luki.util.AppLauncher;
import io.appium.java_client.android.AndroidDriver;

public class AppTest {
	
	@Test
	public void filterPrice() throws Exception {
		AndroidDriver driver = AppLauncher.startApp("emulator-5554");
		Common.startLogin("standard_user", "secret_sauce", driver);
		Thread.sleep(4000);
		
		// high to low
		PageHome.iconFilter(driver).click();
		PageHome.textPriceHighToLow(driver).click();
		Thread.sleep(4000);
		List<WebElement> prices = PageHome.listItemPrices(driver);
		double price1 = Double.parseDouble(((WebElement)prices.get(0)).getText().substring(1));
		double price2 = Double.parseDouble(((WebElement)prices.get(1)).getText().substring(1));
		
		if(price1 > price2) {
			System.out.println(">>> bener");
		} else {
			System.out.println(">>> salah");
		}

	}
	
	@Test
	public void filterPrice2() throws Exception {
		AndroidDriver driver = AppLauncher.startApp("emulator-5554");
		Common.startLogin("standard_user", "secret_sauce", driver);
		Thread.sleep(4000);
		
		// low to high
		PageHome.iconFilter(driver).click();
		PageHome.textPriceLowToHigh(driver).click();
		Thread.sleep(4000);
		List<WebElement> prices = PageHome.listItemPrices(driver);
		double price1 = Double.parseDouble(((WebElement)prices.get(0)).getText().substring(1));
		double price2 = Double.parseDouble(((WebElement)prices.get(1)).getText().substring(1));
		
		if(price1 < price2) {
			System.out.println(">>> bener");
		} else {
			System.out.println(">>> salah");
		}
	}

}
