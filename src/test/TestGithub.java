package test;

import static org.junit.Assert.assertFalse;
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

	private String urlAddMeGithub = "https://github.com/serignebabacar/automatisation_code/new/master?readme=1";
	private By xpathTextPrenomUtilisateur = By.xpath("//span[@class='css-truncate css-truncate-target ml-1']");
	private static final String PROPERTY_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER_GOOGLE_CHROME = "/home/babacar/Téléchargements/chromedriver_linux64/chromedriver";
	private HautDePage hautDePage;
	private String email = "bdiop68@gmail.com";
	private String urlPageRepoToDownload = "https://github.com/serignebabacar/automatisation_code";

	@BeforeMethod
	public void init() {
		System.setProperty(PROPERTY_CHROME_DRIVER, PATH_DRIVER_GOOGLE_CHROME);
		driver = new ChromeDriver();
		hautDePage = new HautDePage(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Communs.URL);
	}

	@Test(priority = 2)
	public void testAddMe() {
		testLoginWithCorrectEmailAndPassword();
		hautDePage.addMe();
		assertTrue(Communs.isEqualsCurrentUrl(driver, urlAddMeGithub));
	}

	@Test(priority = 1)
	public void testLoginWithCorrectEmailAndPassword() {
		login();
		assertTrue(Communs.isEqualsTextWebElemennt(Communs.findElements(driver, xpathTextPrenomUtilisateur).get(1),
				"serignebabacar"));
	}
 
	@Test(expectedExceptions = IndexOutOfBoundsException.class)
	public void testLoginWithIncorrectPassword() {
		hautDePage.loginWIthGithub(email, PATH_DRIVER_GOOGLE_CHROME);
		assertFalse(Communs.isEqualsTextWebElemennt(Communs.findElements(driver, xpathTextPrenomUtilisateur).get(1),
				"serignebabacar"));
	}

	private void login() {
		hautDePage.loginWIthGithub(email, Communs.getMdp(hautDePage.getMdp()));
	}

	@Test(priority = 3)
	public void testDownLoadRepo() {
		testLoginWithCorrectEmailAndPassword();
		hautDePage.downLoadRepo();
		assertTrue(Communs.isEqualsCurrentUrl(driver, urlPageRepoToDownload));
	}

	@Test(priority = 4)
	public void testDeconnexion() {
		testLoginWithCorrectEmailAndPassword();
		hautDePage.deconnexion();
		assertTrue(Communs.isEqualsCurrentUrl(driver, "https://github.com/"));
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
