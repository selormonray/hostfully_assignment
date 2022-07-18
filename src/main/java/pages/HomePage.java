package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private final By goingToSelector = By.cssSelector("button[aria-label='Going to']");
    private final By goingToAreaTextInput = By.cssSelector("#location-field-destination");
    private final By searchResultBtn = By.cssSelector("button[data-testid='submit-button']");

    final By getFiveToFiveHotelSelector = By.xpath("//h2[normalize-space()='Five to Five Hotel']");
    final By getFiveToFiveHotelAmountSelector = By.xpath("//div[normalize-space()='$62']");
    final By getFullyFurnishedArenaSelector = By.xpath("//h2[contains(text(),'fully furnished apartment')]");
    final By houseCheckboxSelector = By.id("popularFilter-0-VACATION_HOME");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void setGoingToDestination(String goingToDestination) {
        driver.findElement(goingToSelector).click();
        /*wait.until(ExpectedConditions.visibilityOfElementLocated(goingToAreaTextInput));
        wait.until(ExpectedConditions.presenceOfElementLocated(goingToAreaTextInput));*/
        driver.findElement(goingToAreaTextInput).sendKeys(goingToDestination);
        driver.findElement(goingToAreaTextInput).sendKeys(Keys.ENTER);
    }

    public SearchResultsPage clickSearch() {
        /*wait.until(ExpectedConditions.presenceOfElementLocated(searchResultBtn));
        wait.until(ExpectedConditions.elementToBeClickable(searchResultBtn));*/
        driver.findElement(searchResultBtn).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new SearchResultsPage(driver);
    }

    public final String expectedFiveToFiveHotelText = "Five to Five Hotel";

    public String getFiveToFiveHotelText() {
        return driver.findElement(getFiveToFiveHotelSelector).getText();
    }

    public final String expectedFiveToFiveHotelAmountText = "$62";

    public String getFiveToFiveHotelAmountText() {
        return driver.findElement(getFiveToFiveHotelAmountSelector).getText();
    }

    public final String expectedFullyFurnishedArenaText = "fully furnished apartment  better for families, near intare conference Arena";

    public String getFullyFurnishedArenaText() {
        return driver.findElement(getFullyFurnishedArenaSelector).getText();
    }

    public void selectHouseCheckBox() {
        driver.findElement(houseCheckboxSelector).click();
    }


}
