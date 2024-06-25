package com.luki;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import com.luki.common.Common;
import com.luki.pom.PageCartDetail;
import com.luki.pom.PageCheckoutInformation;
import com.luki.pom.PageCheckoutOverview;
import com.luki.pom.PageHome;
import com.luki.util.AppLauncher;
import io.appium.java_client.android.AndroidDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
	private AndroidDriver driver;
	
	@BeforeEach
	public void setUp() throws Exception{
		driver = AppLauncher.startApp("emulator-5554");
		Common.startLogin("standard_user", "secret_sauce", driver);
		Thread.sleep(4000);
	}
	
	@AfterEach
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
	
	@Test
	public void filterPriceHightoLow() throws Exception {
		PageHome.iconFilter(driver).click();
		PageHome.textPriceHighToLow(driver).click();
		Thread.sleep(4000);
		List<WebElement> prices = PageHome.listItemPrices(driver);
		double price1 = Double.parseDouble(((WebElement)prices.get(0)).getText().substring(1));
		double price2 = Double.parseDouble(((WebElement)prices.get(1)).getText().substring(1));
		
		
		assertTrue(price1 > price2, "item #1 price should be > than item #2");
	}
	
	@Test
	public void filterPriceLowToHigh() throws Exception {
		PageHome.iconFilter(driver).click();
		PageHome.textPriceLowToHigh(driver).click();
		Thread.sleep(4000);
		List<WebElement> prices = PageHome.listItemPrices(driver);
		double price1 = Double.parseDouble(((WebElement)prices.get(0)).getText().substring(1));
		double price2 = Double.parseDouble(((WebElement)prices.get(1)).getText().substring(1));
		
		assertTrue(price1 < price2, "item #1 price should be < than item #2");
	}
	
	@Test
	public void checkoutItem() throws Exception{
		// obtain item lists
		List<WebElement> titles = PageHome.listItemTitle(driver);
		List<WebElement> buttons = PageHome.listButtonAdd(driver);
		List<WebElement> prices = PageHome.listItemPrices(driver);
		
		// data from item #1 on the item list
		final String itemTitle = ((WebElement) titles.get(0)).getText();
		final String itemPrice = ((WebElement) prices.get(0)).getText();
		((WebElement) buttons.get(0)).click();
		PageHome.iconCart(driver).click();
		
		// checkout page #1, cart detail
		Common.checkElementExistsByText(itemTitle, driver);
		Common.checkElementExistsByText(itemPrice, driver);
		PageCartDetail.buttonCheckout(driver).click();
		
		// checkout page #2, checkout information
		Thread.sleep(1000);
		PageCheckoutInformation.inputFirstName(driver).sendKeys("Luki");
		PageCheckoutInformation.inputLastName(driver).sendKeys("R Daniel");
		PageCheckoutInformation.inputPostalCode(driver).sendKeys("16900");
		PageCheckoutInformation.buttonContinue(driver).click();
		
		// checkout page #3, checkout overview and submit
		Thread.sleep(1000);
		Common.checkElementExistsByText(itemTitle, driver);
		Common.checkElementExistsByText(itemPrice, driver);
		Common.scrollVertical(0.30, driver);
		PageCheckoutOverview.buttonFinish(driver).click();
		
		// checkout page $4, complete screen
		boolean checkoutScreenPresent =  Common.checkElementExistsByAccessibilityID("test-CHECKOUT: COMPLETE!", driver);
		boolean buttonBackPresent = Common.checkElementExistsByAccessibilityID("test-BACK HOME", driver);
		
		assertTrue(checkoutScreenPresent, "checkout screen should be present");
		assertTrue(buttonBackPresent, "button back should be present");
	}

}
