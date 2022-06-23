import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalGridTest {

    public RemoteWebDriver driver;

    // Create the Highlighter function
    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid orange'", element);
    }

    // Configure caps and Sauce connectivity
    @Before
    public void setup() throws MalformedURLException {


        FirefoxOptions firefox = new FirefoxOptions();
        firefox.setCapability("platformName", "LINUX");
        firefox.setCapability("browserName", "firefox");
        firefox.setCapability("se:cdpEnabled", false);


        ChromeOptions chrome = new ChromeOptions();
        chrome.setCapability("platformName", "LINUX");
        chrome.setCapability("browserName", "chrome");
        chrome.setCapability("se:cdpEnabled", false);


        URL url = new URL("http://localhost:4444");

        driver = new RemoteWebDriver(url, firefox);

    }

    // JSExecutor example of highlighting an element
    @Test
    public void highlighter() {
        // Browse to google.com
        driver.navigate().to("https://www.google.com");

        // Find Google Search Bar element
        WebElement q = driver.findElement(By.name("q"));

        // Highlight Google Search Bar element
        highLighterMethod(driver, q);

        // Find Google Logo element
        WebElement lnXdpd = driver.findElement(By.className("lnXdpd"));

        // Highlight Google Logo element
        highLighterMethod(driver, lnXdpd);

        driver.quit();
    }
}