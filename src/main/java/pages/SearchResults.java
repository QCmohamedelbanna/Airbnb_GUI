package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchResults {
    private WebDriver driver;
    private WebDriverWait wait;
    public SearchResults(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofMinutes(1));
    }
    Pattern pattern = Pattern.compile("\\d+");

    private By locationTxt = By.xpath("//div[@role='search']//button[@data-index='0']//div");
    private By expectedTxtCheckInAndOutDate = By.xpath("//div[@role='search']//button[2]//div");
    private By expectedNoOfGuests = By.xpath("//div[@role='search']//button[3]//div[1]");
    private By filterBtn = By.xpath("//button[@type='button']//span[text()='Filters']");
    private By bedrooms = By.xpath("//div[@aria-label='Bedrooms']//div[6]");
    private By bedroomTxt = By.xpath("(//span[text()='5'])[1]");
    private By showMore = By.xpath("(//button[@type='button']//span[text()='Show more'])[1]");
    private By selectPool = By.xpath("//div[text()='Pool']");
    private By showStays =By.xpath("//footer[@class='f1b2no8f dir dir-ltr']//a");
    private By expectBedroomsTxt = By.xpath("//div[@class='g1qv1ctd cb4nyux dir dir-ltr']//div[3]//span[2]//span[3]");
    private By firstProperty = By.xpath("(//div[@data-testid='card-container'])[1]");




    public String expectedLocationTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locationTxt));
        return driver.findElement(locationTxt).getText();
    }
    public String expectedNoOfGuests(){
        return driver.findElement(expectedNoOfGuests).getText();
    }
    public String expectedDatesTxt(){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(expectedTxtCheckInAndOutDate));
        return driver.findElement(expectedTxtCheckInAndOutDate).getText();
    }
    public void clickOnFilters(){
        wait.until(ExpectedConditions.elementToBeClickable(filterBtn));
        driver.findElement(filterBtn).click();
    }
    public void selectNumberOfBedrooms(){
       wait.until(ExpectedConditions.elementToBeClickable(bedrooms));
       driver.findElement(bedrooms).click();
    }
    public Integer actualBedroomsTxt(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(bedroomTxt));
        return Integer.valueOf(driver.findElement(bedroomTxt).getText());
    }
    public void selectPool(){
        wait.until(ExpectedConditions.elementToBeClickable(showMore));
        driver.findElement(showMore).click();

        wait.until(ExpectedConditions.elementToBeClickable(selectPool));
        driver.findElement(selectPool).click();
    }
    public void clickOnShowStays(){
        wait.until(ExpectedConditions.elementToBeClickable(showStays));
        driver.findElement(showStays).click();
    }
    public String expectedBedroomsNo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectBedroomsTxt));
        return driver.findElement(expectBedroomsTxt).getText();
    }
    public Integer getNumberFromText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(expectBedroomsTxt));
        Matcher matcher = pattern.matcher(expectedBedroomsNo());
        if (matcher.find()) {
            // Get the matched number
            String number = matcher.group();
            return Integer.valueOf(number);
        } else {
            // No number found in the text
            System.out.println("No number found");
        }
        return null;
    }
    public void clickOnFirstProperty(){
        wait.until(ExpectedConditions.elementToBeClickable(firstProperty));
        driver.findElement(firstProperty).click();
    }






}
