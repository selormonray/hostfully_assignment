package pages;

import name.finsterwalder.fileutils.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SearchResultsPage {

    private WebDriver driver ;

    final By getFiveToFiveHotelSelector = By.xpath("//h2[normalize-space()='Five to Five Hotel']");
    final By getFiveToFiveHotelAmountSelector = By.xpath("//div[normalize-space()='$62']");
    final By getFullyFurnishedArenaSelector = By.xpath("//h2[contains(text(),'fully furnished apartment')]");
    final By getPropertyTextSelector = By.cssSelector(".uitk-text.uitk-type-start.uitk-type-200.uitk-type-medium.uitk-spacing.uitk-spacing-padding-blockend-one.uitk-text-default-theme");
    final By houseCheckboxSelector = By.id("popularFilter-0-VACATION_HOME");


    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public final String expectedFiveToFiveHotelText = "Five to Five Hotel";

    public String getFiveToFiveHotelText() {
        return driver.findElement(getFiveToFiveHotelSelector).getText();
    }

    public final String expectedFiveToFiveHotelAmountText = "$62";

    public String getFiveToFiveHotelAmountText() {
        return driver.findElement(getFiveToFiveHotelAmountSelector).getText();
    }

    public final String expectedNumberOfPropertyText = "447 properties";

    public String getNumberOfPropertyText() {
        return driver.findElement(getPropertyTextSelector).getText();
    }

    public final String expectedFullyFurnishedArenaText = "fully furnished apartment  better for families, near intare conference Arena";

    public String getFullyFurnishedArenaText() {
        return driver.findElement(getFullyFurnishedArenaSelector).getText();
    }

    public void selectHouseCheckBox() {
        driver.findElement(houseCheckboxSelector).click();
    }

    public void takesScreenshot() throws IOException {
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "PNG", new File("src/main/resources/snaps/img.png"));
    }




}
