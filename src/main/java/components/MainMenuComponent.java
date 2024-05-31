package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainMenuComponent extends AbsBaseComponent {

    public MainMenuComponent(WebDriver driver) {
        super(driver);
    }

    private String containerSelector = ".sc-pzx9cw-0.eulnpU.sc-10izyea-1.eBgqta";
    WebElement container = driver.findElement(By.cssSelector(containerSelector));

    public MainMenuComponent selectTestingElement() {

        List<WebElement> items = container.findElements(By.cssSelector(".sc-yfk21i-0.jeFZmS"));

        for (WebElement item : items) {
            if (item.getText().equals("Тестирование")) {
                item.click();
                break;
            }
        }
        return null;
    }

}
