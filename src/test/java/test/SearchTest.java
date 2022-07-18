package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTest extends BaseTest {
    private WebDriver driver;

    @Test
    public void searchCity() throws IOException {
        homePage.setGoingToDestination("Kigali");

        SearchResultsPage searchResultsPage = homePage.clickSearch();
        assertEquals(searchResultsPage.expectedFiveToFiveHotelText, searchResultsPage.getFiveToFiveHotelText());
        assertEquals(searchResultsPage.expectedFiveToFiveHotelAmountText, searchResultsPage.getFiveToFiveHotelAmountText());
        assertEquals(searchResultsPage.expectedNumberOfPropertyText, searchResultsPage.getNumberOfPropertyText());
        searchResultsPage.takesScreenshot();


    }
}
