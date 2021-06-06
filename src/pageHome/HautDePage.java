package pageHome;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import communs.Communs;

public class HautDePage {
	private By xpathButtonDeconnexion = By.xpath("//button[@class='dropdown-item dropdown-signout']");

	private By xpathLinkDownload = By
			.xpath("//a[@href='/serignebabacar/automatisation_code/archive/refs/heads/master.zip']");
	private By xpathMenuDeroulantDownloadRepo = By
			.xpath("//span/get-repo/details/summary/span[@class='dropdown-caret']");
	private By xpathButtonSeCoonnecter = By.name("commit");
	private By xpathInputMdp = By.id("password");
	private By xpathInputLogin = By.name("login");
	private By xpathBouttonAddMe = By.xpath("//a[@href='/serignebabacar/automatisation_code/new/master?readme=1']");
	private By xpathRepositoryAutomisationCours = By.xpath("//a[@href='/serignebabacar/automatisation_code']");
	private By xpathRepository = By.xpath("//a[@role='menuitem']");
	private By xpathClassMenuDeroulant = By.xpath("//span[@class='dropdown-caret']");
	private WebDriver driver;
	private String PROPERTIES_FILE_PATH = "src/data.properties";
	private String mdp;

	public HautDePage(WebDriver driver) {
		this.driver = driver;
	}

	public void addMe() {
		// List<WebElement> elements = driver.findElements(xpathClassMenuDeroulant);
		// elements.get(1).click();
		Communs.click(Communs.findElements(driver, xpathClassMenuDeroulant).get(1));
		sleep(3000);
		// List<WebElement> elementsMenu = driver.findElements(xpathRepository);
		// elementsMenu.get(7).click();
		Communs.click(Communs.findElements(driver, xpathRepository).get(7));
		// driver.findElement(xpathRepositoryAutomisationCours).click();
		Communs.click(Communs.findElement(driver, xpathRepositoryAutomisationCours));
		// driver.findElement(xpathBouttonAddMe).click();
		Communs.click(Communs.findElement(driver, xpathBouttonAddMe));
	}

	public String getMdp() {
		Properties properties = new Properties();
		try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
			properties.load(inputStream);
			mdp = (String) properties.getProperty("mdp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mdp;
	}

	public void loginWIthGithub(String email, String motDePasse) {

		// driver.findElement(xpathInputLogin).sendKeys(email);
		Communs.findElement(driver, xpathInputLogin).sendKeys(email);
		// driver.findElement(xpathInputMdp).sendKeys(motDePasse);
		Communs.findElement(driver, xpathInputMdp).sendKeys(motDePasse);
		// driver.findElement(xpathButtonSeCoonnecter).click();
		Communs.click(Communs.findElement(driver, xpathButtonSeCoonnecter));
		sleep(2000);
	}

	public void downLoadRepo() {
		// List<WebElement> elements = driver.findElements(xpathClassMenuDeroulant);
		Communs.click(Communs.findElements(driver, xpathClassMenuDeroulant).get(1));
		sleep(3000);
		// List<WebElement> elementsMenu = driver.findElements(xpathRepository);
		// elementsMenu.get(7).click();
		Communs.click(Communs.findElements(driver, xpathRepository).get(7));
		// driver.findElement(xpathRepositoryAutomisationCours).click();
		Communs.click(Communs.findElement(driver, xpathRepositoryAutomisationCours));
		// driver.findElement(xpathMenuDeroulantDownloadRepo).click();
		Communs.click(Communs.findElement(driver, xpathMenuDeroulantDownloadRepo));
		// driver.findElement(xpathLinkDownload).click();
		Communs.click(Communs.findElement(driver, xpathLinkDownload));
	}

	public void deconnexion() {
		// List<WebElement> elements = driver.findElements(xpathClassMenuDeroulant);
		// elements.get(1).click();
		Communs.click(Communs.findElements(driver, xpathClassMenuDeroulant).get(1));
		sleep(2000);
		// driver.findElement(xpathButtonDeconnexion).click();
		Communs.click(Communs.findElement(driver, xpathButtonDeconnexion));
	}

	private void sleep(int milliSeconde) {
		try {
			Thread.sleep(milliSeconde);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}