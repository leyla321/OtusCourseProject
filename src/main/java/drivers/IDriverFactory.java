package drivers;

import exceptions.DriverNotSupportedException;
import org.openqa.selenium.WebDriver;

public interface IDriverFactory {
    WebDriver getDriver() throws DriverNotSupportedException;
}
