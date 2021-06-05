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
	private By xpathTextPrenomUtilisateur = By.xpath("//span[@class='css-truncate css-truncate-target ml-1']");
	private WebDriver driver;
	public static final String PROPERTY_WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String PATH_DRIVER_GOOGLE_CHROME = "/home/babacar/Téléchargements/chromedriver_linux64/chromedriver";
	private HautDePage pageCreateRepository;

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
		pageCreateRepository.addMe();
	}

	@Test(priority = 1)
	public void testLogin() {
		pageCreateRepository.loginWIthGithub();
		assertTrue(driver.findElements(xpathTextPrenomUtilisateur).get(1).getText().equals("serignebabacar"));
	}

	@Test(priority = 3)
	public void testDownLoadRepo() {
		pageCreateRepository.downLoadRepo();
	}

	@Test(priority = 4)
	public void testDeconnexion() {
		pageCreateRepository.deconnexion();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}
