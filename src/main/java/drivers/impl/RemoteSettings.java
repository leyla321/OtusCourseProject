package drivers.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.CapabilityType;

public class RemoteSettings implements IBrowserSettings {
    @Override
    public AbstractDriverOptions settings() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, "version");

        return chromeOptions;
    }
}
