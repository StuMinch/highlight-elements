import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class BasicBrowserTest {

    public RemoteWebDriver driver;

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
        browserOptions.setCapability("se:cdpEnabled", true);

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("name", "Highlight Browser Elements using Highlighter Method");
        sauceOptions.setCapability("browserVersion", "latest");
        sauceOptions.setCapability("seleniumVersion", "4.2.0");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, browserOptions);
        /*
        driver = RemoteWebDriver.builder()
                .oneOf(browserOptions)
                .config(url)
                .build();
         */

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