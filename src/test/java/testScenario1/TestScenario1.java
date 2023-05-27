package testScenario1;

import baseTests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenario1 extends BaseTests {

    @Test
    public void verify_results_match_search_criteria() throws InterruptedException {
        home.closePopupWindow();
        home.selectLocation();
        home.getLocationText();
        home.setCheckInDate();
        String actualCheckInTxt = home.getCheckInDateTxt();
        home.setCheckOutDate();
        home.getCheckoutText();
        home.selectNumberOfGuests();
        String actualNumberOfGuests = home.actualNoOfGuests();
        home.search();
        String expectCheckInAndOutDate = searchResults.expectedDatesTxt();
        Thread.sleep(3000);
        assert home.getLocationText().contains(searchResults.expectedLocationTxt());
        Assert.assertEquals(actualNumberOfGuests,searchResults.expectedNoOfGuests());
        assert actualCheckInTxt.contains(expectCheckInAndOutDate);
    }
}
