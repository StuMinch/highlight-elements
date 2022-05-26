import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class BasicBrowserTest {

    public RemoteWebDriver driver;
    public WebDriverWait webDriverWait;

    // Create the Highlighter function
    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid orange'", element);
    }

    // Configure caps and Sauce connectivity
    @Before
    public void setup() throws MalformedURLException {

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("name", "Highlight Browser Elements using Highlighter Method");
        sauceOptions.setCapability("browserVersion", "latest");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, browserOptions);

    }

    // JSExecutor example of highlighting an element
    @Test
    public void highlighter() {
        // Browse to google.com
        driver.navigate().to("https://www.google.com");

        // Find Search and Logo elements
        WebElement q = driver.findElement(By.name("q"));
        WebElement lnXdpd = driver.findElement(By.className("lnXdpd"));

        // Highlight Google Search Bar element
        highLighterMethod(driver, q);

        // Highlight Google logo element
        highLighterMethod(driver, lnXdpd);

        driver.quit();
    }
}