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

	public static boolean isEquals(String chaine, String chaineTest) {
		return chaine.equals(chaineTest);
	}

	public static boolean isEqualsTextWebElemennt(WebElement element, String text) {
		return isEquals(element.getText(), text);
	}

	public static boolean isEqualsCurrentUrl(WebDriver driver, String urlTest) {
		return isEquals(driver.getCurrentUrl(), urlTest);
	}

	public static List<WebElement> findElements(WebDriver driver, By locator) {
		return driver.findElements(locator);
	}

	public static String getMdp(String chaine) {
		String result = chaine.replaceAll("[\\-\\+\\.\\^:,*//]", "");
		return result;
	}
}
