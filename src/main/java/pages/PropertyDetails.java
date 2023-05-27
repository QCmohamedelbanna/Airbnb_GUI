package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class PropertyDetails {
    private  WebDriver driver ;
    private  WebDriverWait wait;
    public PropertyDetails(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    }

    private  By Close_Btn = By.xpath("//button[@aria-label='Close']");
    private  By showAllAmenitiesBtn= By.cssSelector("div[class='b9672i7 dir dir-ltr'] button");
    private By checkPool = By.xpath("//div[contains(text(),'Pool')]");



    public void changeWindow() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }
    public void closePopUpWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(Close_Btn));
        driver.findElement(Close_Btn).click();
    }
    public void clickOnShowAllAmenities(){
            wait.until(ExpectedConditions.elementToBeClickable(showAllAmenitiesBtn));
            driver.findElement(showAllAmenitiesBtn).click();
    }
    public Boolean checkPoolTxtIsDisplayed(){
      wait.until(ExpectedConditions.visibilityOfElementLocated(checkPool));
      return driver.findElement(checkPool).isDisplayed();
    }

}
