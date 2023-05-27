package baseTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.Home;
import pages.PropertyDetails;
import pages.SearchResults;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected Home home;
    protected SearchResults searchResults;
    protected PropertyDetails propertyDetails;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\MyWorkSpace\\Technical_Assessment\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        driver.get("https://www.airbnb.com/");
        driver.manage().window().maximize();

        home = new Home(driver);
        searchResults = new SearchResults(driver);
        propertyDetails = new PropertyDetails(driver);
    }
    @AfterClass
    public void tearDown(){
        //driver.quit();
    }

}
