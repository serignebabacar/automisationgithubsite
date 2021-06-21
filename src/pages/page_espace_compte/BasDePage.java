package pages.page_espace_compte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import communs.Communs;

public class BasDePage {
	private WebDriver driver;
	private By xpathAPI = By.xpath("//a[@href='https://docs.github.com']");

	public BasDePage(WebDriver driver) {
		this.driver = driver;
	}

	public void testAPI() {
		Communs.click(Communs.findElements(driver, xpathAPI).get(0));
		Communs.sleep(2000);
	}
	public void testDOCS() {
		Communs.click(Communs.findElements(driver, xpathAPI).get(1));
		Communs.sleep(2000);
	}
	

}
