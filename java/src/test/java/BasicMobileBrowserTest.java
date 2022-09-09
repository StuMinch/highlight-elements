import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicMobileBrowserTest {
    // Create driver
    //public AndroidDriver driver;

    private RemoteWebDriver driver;

    // Create the Highlighter function
    public void highLighterMethod(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid orange'", element);
    }

    // Configure caps and Sauce connectivity
    @Before
    public void setup() throws MalformedURLException {

        ChromeOptions browserOptions = new ChromeOptions();

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:deviceName", "Google Pixel 4a (5G) GoogleAPI Emulator");
        caps.setCapability("appium:platformVersion", "12.0");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "1.22.1");
        sauceOptions.setCapability("name", "Highlight elements on mobile browser");
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, caps);

    }

    // Use Highlighter method on the Google search bar
    @Test
    public void highlightGoogleSearch() {

        // Browse to google.com
        driver.navigate().to("https://www.google.com");

        // Find Google Search Bar element
        WebElement q = driver.findElement(By.name("q"));

        // Highlight Google Search Bar element
        highLighterMethod(driver, q);

        driver.quit();
    }

    // Use Highlighter method on the Google logo
    @Test
    public void highlightGoogleLogo() {
        // Browse to google.com
        driver.navigate().to("https://www.google.com");

        // Find Google Logo element
        WebElement hplogo = driver.findElement(By.id("hplogo"));

        // Highlight Google Logo element
        highLighterMethod(driver, hplogo);

        driver.quit();
    }
}