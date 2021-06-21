package pages.PageEspaceCompte;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import communs.Communs;

public class HautDePage {
	private By xpathButtonDeconnexion = By.xpath("//button[@class='dropdown-item dropdown-signout']");
	private By xpathLinkDownload = By
			.xpath("//a[@href='/serignebabacar/automatisation_code/archive/refs/heads/master.zip']");
	private By xpathMenuDeroulantDownloadRepo = By
			.xpath("//span/get-repo/details/summary/span[@class='dropdown-caret']");
	private By xpathBouttonAddMe = By.xpath("//a[@href='/serignebabacar/automatisation_code/new/master?readme=1']");
	private By xpathRepositoryAutomisationCours = By.xpath("//a[@href='/serignebabacar/automatisation_code']");
	private By xpathRepository = By.xpath("//a[@role='menuitem']");
	private By xpathClassMenuDeroulant = By.xpath("//span[@class='dropdown-caret']");
	private WebDriver driver;

	public HautDePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addMe() {
		Communs.click(Communs.findElements(driver, xpathClassMenuDeroulant).get(1));
		Communs.sleep(3000);
		Communs.click(Communs.findElements(driver, xpathRepository).get(7));
		Communs.click(Communs.findElement(driver, xpathRepositoryAutomisationCours));
		Communs.click(Communs.findElement(driver, xpathBouttonAddMe));
	}

	public void downLoadRepo() {
		Communs.click(Communs.findElements(driver, xpathClassMenuDeroulant).get(1));
		Communs.sleep(3000);
		Communs.click(Communs.findElements(driver, xpathRepository).get(7));
		Communs.click(Communs.findElement(driver, xpathRepositoryAutomisationCours));
		Communs.click(Communs.findElement(driver, xpathMenuDeroulantDownloadRepo));
		Communs.click(Communs.findElement(driver, xpathLinkDownload));
	}

	public void deconnexion() {
		Communs.click(Communs.findElements(driver, xpathClassMenuDeroulant).get(1));
		Communs.sleep(2000);
		Communs.click(Communs.findElement(driver, xpathButtonDeconnexion));
	}

}