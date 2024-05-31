package drivers;

import data.BrowserNameData;
import drivers.impl.ChromeWebDriver;
import exceptions.DriverNotSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class WebDriverFactory implements IDriverFactory {
    private String browserName = System.getProperty("browser.name", "chrome");
    private String remoteGridUrl = System.getProperty("remote.url", "https://193.104.57.173/wd/hub");
    private final static String version = System.getProperty("browser.version", "124.0");
    private final static Logger logger = LogManager.getLogManager().getLogger(String.valueOf(WebDriverFactory.class));

    public WebDriverFactory() {
    }

    public WebDriver create() throws DriverNotSupportedException, MalformedURLException {
        BrowserNameData browserNameData = BrowserNameData.valueOf(browserName.toUpperCase(Locale.ROOT));
        switch (browserNameData) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) (new ChromeWebDriver()).settings());
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case REMOTE:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, "version");
                Map<String, Object> selenoidOptions = new HashMap<>();
                selenoidOptions.put("enableVNC", true);
                selenoidOptions.put("enableVideo", false);
                chromeOptions.setCapability("selenoid:options", selenoidOptions);
                return new RemoteWebDriver(new URL(remoteGridUrl), chromeOptions);
            default:
                throw new DriverNotSupportedException(browserName);
        }
    }

    public WebDriver getDriver() throws DriverNotSupportedException {
        return null;
    }
}
