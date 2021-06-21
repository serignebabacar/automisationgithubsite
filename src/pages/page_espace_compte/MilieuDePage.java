package pages.page_espace_compte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import communs.Communs;

public class MilieuDePage {
	private WebDriver driver;
	private By xpathTextPrenomUtilisateur = By.xpath("//span[@class='css-truncate css-truncate-target ml-1']");

	public MilieuDePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstNameUser() {
		return Communs.findElements(driver, xpathTextPrenomUtilisateur).get(1).getText();

	}
}
