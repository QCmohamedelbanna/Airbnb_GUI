package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.PanelUI;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Home {
    private WebDriver driver;
    private  WebDriverWait wait ;

    public Home(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofMinutes(1));
    }
    private  By Close_Btn = By.xpath("//button[@aria-label='Close']");
    private By Anywhere_Btn = By.xpath("//div[@role='search']//button//div[text()='Anywhere']");
    private By Search_text = By.xpath("//div[@role='tabpanel']//input");
    private LocalDate currentDate = LocalDate.now();
    private LocalDate checkInDate = currentDate.plusWeeks(1);
    private LocalDate checkOutDate = checkInDate.plusWeeks(1);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private String formattedCheckInDate = checkInDate.format(formatter);
    private String formattedCheckOutDate = checkOutDate.format(formatter);
    private By checkInElement =
            By.xpath("//table[@class='_cvkwaj']//div[@data-testid='calendar-day-"+formattedCheckInDate +"']");
    private By checkInTxt = By.xpath("(//div[@role='button'])[1]//div[2]");
    private By checOutElement =
            By.xpath("//table[@class='_cvkwaj']//div[@data-testid='calendar-day-"+formattedCheckOutDate +"']");
    private By checkOutTxt = By.xpath("(//div[@role='button'])[2]//div[2]");
    private By addGuestsBtn = By.xpath("//div[@role='tabpanel']//div[text()='Who']");
    private By adultsBtn = By.xpath("//div[@id='stepper-adults']//button[2]");
    private By adultsText = By.xpath("//span[contains(text(),'Adults')]");
    private By childrenBtn = By.xpath("//div[@id='stepper-children']//button[2]");
    private By searchBtn = By.cssSelector("div[class='s1i622mb dir dir-ltr'] button");
    private By noOfGuests = By.xpath("(//div[@role='tabpanel']//div[@role='button'])[3]//div//div[2]");



    public void closePopupWindow(){
        wait.until(ExpectedConditions.elementToBeClickable(Close_Btn));
        driver.findElement(Close_Btn).click();
    }
    public void selectLocation() {
        wait.until(ExpectedConditions.elementToBeClickable(Anywhere_Btn));
        driver.findElement(Anywhere_Btn).click();

        wait.until(ExpectedConditions.elementToBeClickable(Search_text));
        driver.findElement(Search_text).sendKeys("Rome, Italy" + Keys.ENTER);

    }
    public String getLocationText(){
//      System.out.println(driver.findElement(Search_text).getAttribute("value"));
        return driver.findElement(Search_text).getAttribute("value");
    }
    public void setCheckInDate(){
        wait.until(ExpectedConditions.elementToBeClickable(checkInElement));
        driver.findElement(checkInElement).click();
    }
    public String getCheckInDateTxt(){
        return driver.findElement(checkInTxt).getText();
    }
    public void setCheckOutDate(){
        wait.until(ExpectedConditions.elementToBeClickable(checOutElement));
        driver.findElement(checOutElement).click();
    }
    public String getCheckoutText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutTxt));
        return driver.findElement(checkOutTxt).getText();
    }
    public void selectNumberOfGuests(){
        wait.until(ExpectedConditions.elementToBeClickable(addGuestsBtn));
        driver.findElement(addGuestsBtn).click();

        wait.until(ExpectedConditions.elementToBeClickable(addGuestsBtn));
        for (int i=0; i <= 2 ; i++){
            driver.findElement(adultsBtn).click();
            if (driver.findElement(adultsText).getText().equals("2 Adults")){
                break;
            }
        }

        wait.until(ExpectedConditions.elementToBeClickable(childrenBtn));
        driver.findElement(childrenBtn).click();
    }
    public String actualNoOfGuests(){
        return driver.findElement(noOfGuests).getText();
    }
    public void search(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        driver.findElement(searchBtn).click();
    }
}
