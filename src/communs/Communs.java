package communs;

import java.util.List;

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

	public static WebElement findElement(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}

	public static boolean isEqualText(WebElement element, String text) {
		return element.getText().equals(text);
	}

	public static boolean isEquals(String currentUrl, String urlText) {
		return currentUrl.equals(urlText);
	}

	public static List<WebElement> findElements(WebDriver driver, By locator) {
		return driver.findElements(locator);
	}
	public String getMdp() {
		 String s = "ba,";
		 
		 s.replaceAll(",","7089447");
		 return s;
	}
}
