package drivers.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public class ChromeWebDriver implements IBrowserSettings {
    public ChromeWebDriver() {
    }

    public AbstractDriverOptions settings() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (isBrowserMode.equals("fullscreen")) {
            chromeOptions.addArguments("--start-maximized");
        } else if (isBrowserMode.equals("kiosk")) {
            chromeOptions.addArguments("--kiosk");
        }
        return chromeOptions;
    }
}
