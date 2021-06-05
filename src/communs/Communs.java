package communs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Communs {
	public static String URL = "https://github.com/login";

	public static void click(WebElement webEelement) {
		webEelement.click();
	}

	public boolean isDisplayElement(WebElement webElement) {
		return webElement.isDisplayed();
	}

	public static WebElement find(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}

	public static boolean isEqualText(WebElement element, String text) {
		return element.getText().equals(text);
	}
	
}
