package test;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import communs.Communs;
import pages.PageConnexion;
import pages.PageEspaceCompte.BasDePage;
import pages.PageEspaceCompte.HautDePage;

public class TestEspaceCompte {

	private WebDriver driver;
	private HautDePage hautDePage;
	private BasDePage basDePage;
	private PageConnexion pageConnexion;
	private static final String email = "bdiop68@gmail.com";

	private static final String linkAPI_OR_DOCS = "https://docs.github.com/en";

	private static final String urlAddMeGithub = "https://github.com/serignebabacar/automatisation_code/new/master?readme=1";
	private static final String PROPERTY_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER_GOOGLE_CHROME = "/home/babacar/Téléchargements/chromedriver_linux64/chromedriver";

	private static final String urlPageRepoToDownload = "https://github.com/serignebabacar/automatisation_code";

	@BeforeMethod
	public void init() {
		System.setProperty(PROPERTY_CHROME_DRIVER, PATH_DRIVER_GOOGLE_CHROME);
		driver = new ChromeDriver();
		hautDePage = new HautDePage(driver);
		basDePage = new BasDePage(driver);
		pageConnexion = new PageConnexion(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Communs.URL);
	}

	@Test(priority = 2)
	public void testAddMe() {
		login();
		hautDePage.addMe();
		assertTrue(Communs.isEqualsCurrentUrl(driver, urlAddMeGithub));
	}

	private void login() {
		pageConnexion.loginWIthGithub(email, Communs.formatMdp(pageConnexion.getMdp()));
	}

	@Test(priority = 3)
	public void testDownLoadRepo() {
		login();
		hautDePage.downLoadRepo();
		assertTrue(Communs.isEqualsCurrentUrl(driver, urlPageRepoToDownload));
	}

	@Test(priority = 4)
	public void testDeconnexion() {
		login();
		hautDePage.deconnexion();
		assertTrue(Communs.isEqualsCurrentUrl(driver, "https://github.com/"));
	}

	@Test(priority = 5)
	public void testAPI() {
		login();
		basDePage.testAPI();
		Communs.isEqualsCurrentUrl(driver, linkAPI_OR_DOCS);
	}

	@Test(priority = 6)
	public void testDOCS() {
		login();
		basDePage.testDOCS();
		Communs.isEqualsCurrentUrl(driver, linkAPI_OR_DOCS);
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
