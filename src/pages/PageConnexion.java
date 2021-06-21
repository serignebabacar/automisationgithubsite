package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import communs.Communs;

public class PageConnexion {
	WebDriver driver;
	private String PROPERTIES_FILE_PATH = "src/data.properties";
	private String mdp;
	private By xpathButtonSeCoonnecter = By.name("commit");
	private By xpathInputMdp = By.id("password");
	private By xpathInputLogin = By.name("login");

	public PageConnexion(WebDriver driver) {
		this.driver = driver;
	}

	public void loginWIthGithub(String email, String motDePasse) {

		Communs.findElement(driver, xpathInputLogin).sendKeys(email);
		Communs.findElement(driver, xpathInputMdp).sendKeys(motDePasse);
		Communs.click(Communs.findElement(driver, xpathButtonSeCoonnecter));
		Communs.sleep(2000);
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

}
