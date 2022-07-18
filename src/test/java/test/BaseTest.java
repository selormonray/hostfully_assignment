package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;
import pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;
    protected HomePage homePage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com/");
        // Delete all cookies
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
//        searchPage = new SearchPage(driver);

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
