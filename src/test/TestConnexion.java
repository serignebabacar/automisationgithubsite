package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import communs.Communs;
import pages.PageConnexion;
import pages.page_espace_compte.MilieuDePage;

public class TestConnexion {

	PageConnexion pageConnexion;
	private WebDriver driver;
	private MilieuDePage milieuDePage;
	private static final String firstNameUser = "serignebabacar";
	private static final String PROPERTY_CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER_GOOGLE_CHROME = "/home/babacar/Téléchargements/chromedriver_linux64/chromedriver";
	private static final String email = "bdiop68@gmail.com";

	@BeforeMethod
	public void init() {
		System.setProperty(PROPERTY_CHROME_DRIVER, PATH_DRIVER_GOOGLE_CHROME);
		driver = new ChromeDriver();
		pageConnexion = new PageConnexion(driver);
		milieuDePage = new MilieuDePage(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(Communs.URL);
	}

	@Test(expectedExceptions = IndexOutOfBoundsException.class,priority = 2)
	public void testLoginWithIncorrectPassword() {
		pageConnexion.loginWIthGithub(email, PATH_DRIVER_GOOGLE_CHROME);
		assertFalse(Communs.isEquals(milieuDePage.getFirstNameUser(), firstNameUser));
	}

	@Test(priority = 1)
	public void testLoginWithCorrectEmailAndPassword() {
		login();
		assertTrue(Communs.isEquals(firstNameUser, milieuDePage.getFirstNameUser()));
	}

	private void login() {
		pageConnexion.loginWIthGithub(email, Communs.formatMdp(pageConnexion.getMdp()));
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

}
