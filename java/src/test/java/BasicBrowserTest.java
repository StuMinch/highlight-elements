import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

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
        browserOptions.setBrowserVersion("latest");
        //browserOptions.setCapability("se:cdpEnabled", false);

        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", System.getenv("SAUCE_USERNAME"));
        sauceOptions.setCapability("accessKey", System.getenv("SAUCE_ACCESS_KEY"));
        sauceOptions.setCapability("tunnelName", System.getenv("SAUCE_TUNNEL"));
        sauceOptions.setCapability("se:name", "Highlight Browser Elements using Highlighter Method");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com/wd/hub");

        driver = new RemoteWebDriver(url, browserOptions);

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
        WebElement lnXdpd = driver.findElement(By.className("lnXdpd"));

        // Highlight Google Logo element
        highLighterMethod(driver, lnXdpd);

        driver.quit();
    }
}
