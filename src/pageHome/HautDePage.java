package pageHome;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HautDePage {
	private By xpathButtonDeconnexion = By.xpath("//button[@class='dropdown-item dropdown-signout']");
	private String email = "bdiop68@gmail.com";
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
		loginWIthGithub();
		List<WebElement> elements = driver.findElements(xpathClassMenuDeroulant);
		elements.get(1).click();
		sleep(3000);
		List<WebElement> elementsMenu = driver.findElements(xpathRepository);
		elementsMenu.get(7).click();
		driver.findElement(xpathRepositoryAutomisationCours).click();
		driver.findElement(xpathBouttonAddMe).click();
	}

	private void setMdp() throws IOException {
		Properties properties = new Properties();
		try (InputStream inputStream = new FileInputStream(PROPERTIES_FILE_PATH)) {
			properties.load(inputStream);
			mdp = (String) properties.getProperty("mdp");
		} catch (IOException e) {
			throw new IOException(e.getCause());
		}
	}

	public void loginWIthGithub() {
		try {
			setMdp();
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.findElement(xpathInputLogin).sendKeys(email);
		driver.findElement(xpathInputMdp).sendKeys(mdp);
		driver.findElement(xpathButtonSeCoonnecter).click();
		sleep(2000);
	}

	public void downLoadRepo() {
		loginWIthGithub();
		List<WebElement> elements = driver.findElements(xpathClassMenuDeroulant);
		elements.get(1).click();
		sleep(3000);
		List<WebElement> elementsMenu = driver.findElements(xpathRepository);
		elementsMenu.get(7).click();
		driver.findElement(xpathRepositoryAutomisationCours).click();
		driver.findElement(xpathMenuDeroulantDownloadRepo).click();
		driver.findElement(xpathLinkDownload).click();
	}

	public void deconnexion() {
		loginWIthGithub();
		List<WebElement> elements = driver.findElements(xpathClassMenuDeroulant);
		elements.get(1).click();
		sleep(2000);
		driver.findElement(xpathButtonDeconnexion).click();
	}

	private void sleep(int milliSeconde) {
		try {
			Thread.sleep(milliSeconde);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}