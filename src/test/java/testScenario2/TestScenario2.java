package testScenario2;

import baseTests.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestScenario2 extends BaseTests {

    @Test
    public void verify_results_match_extra_filters() throws InterruptedException {
        home.closePopupWindow();
        home.selectLocation();
        home.setCheckInDate();
        home.setCheckOutDate();
        home.selectNumberOfGuests();
        home.search();
        searchResults.clickOnFilters();
        searchResults.selectNumberOfBedrooms();
        Integer actualBedroomsNo = searchResults.actualBedroomsTxt();
        searchResults.selectPool();
        searchResults.clickOnShowStays();
        Integer expectedBedroomsNo = searchResults.getNumberFromText();
        System.out.println(expectedBedroomsNo);
        System.out.println(actualBedroomsNo);
        Assert.assertTrue(expectedBedroomsNo >= actualBedroomsNo,"");
        Thread.sleep(3000);
        searchResults.clickOnFirstProperty();
        propertyDetails.changeWindow();
        propertyDetails.closePopUpWindow();
        propertyDetails.clickOnShowAllAmenities();
        boolean expectedPoolTxt = propertyDetails.checkPoolTxtIsDisplayed();
        Assert.assertTrue(expectedPoolTxt);
    }
}
