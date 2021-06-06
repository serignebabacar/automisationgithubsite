package laposte.com.test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import communs.Communs;
import pageHome.HautDePage;

public class TestGithub {
	private WebDriver driver;

	private static final String urlAddMeGithub = "https://github.com/serignebabacar/automatisation_code/new/master?readme=1";
	private By xpathTextPrenomUtilisateur = By.xpath("//span[@class='css-truncate css-truncate-target ml-1']");
	public static final String PROPERTY_WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String PATH_DRIVER_GOOGLE_CHROME = "/home/babacar/Téléchargements/chromedriver_linux64/chromedriver";
	private HautDePage pageCreateRepository;
	private String email = "bdiop68@gmail.com";
	private String urlPageRepoToDownload = "https://github.com/serignebabacar/automatisation_code";

	@BeforeMethod
	public void init() {
		System.setProperty(PROPERTY_WEBDRIVER_CHROME_DRIVER, PATH_DRIVER_GOOGLE_CHROME);
		driver = new ChromeDriver();
		pageCreateRepository = new HautDePage(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Communs.URL);
	}

	@Test(priority = 2)
	public void testAddMe() {
		login();
		pageCreateRepository.addMe();
		assertTrue(Communs.isEquals(driver.getCurrentUrl(), urlAddMeGithub));
	}

	@Test(priority = 1)
	public void testLogin() {
		login();
		assertTrue(
				Communs.isEquals(driver.findElements(xpathTextPrenomUtilisateur).get(1).getText(), "serignebabacar"));
	}

	private void login() {
		pageCreateRepository.loginWIthGithub(email, Communs.getMdp(pageCreateRepository.getMdp()));
	}

	@Test(priority = 3)
	public void testDownLoadRepo() {
		login();
		pageCreateRepository.downLoadRepo();
		assertTrue(Communs.isEquals(driver.getCurrentUrl(), urlPageRepoToDownload));
	}

	@Test(priority = 4)
	public void testDeconnexion() {
		login();
		pageCreateRepository.deconnexion();
		assertTrue(Communs.isEquals(driver.getCurrentUrl(), "https://github.com/"));
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
