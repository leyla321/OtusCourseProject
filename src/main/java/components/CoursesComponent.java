package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoursesComponent extends AbsBaseComponent {

    public CoursesComponent(WebDriver driver) {
        super(driver);
    }

    private String coursesName = ".sc-18q05a6-1.bwGwUO > a";

    private String containerSelector = ".sc-pzx9cw-0.eulnpU.sc-10izyea-1.eBgqta";
    WebElement container = driver.findElement(By.cssSelector(containerSelector));

    public CoursesComponent selectTestingElement() {

        List<WebElement> items = container.findElements(By.cssSelector(".sc-yfk21i-0.jeFZmS"));

        for (WebElement item : items) {
            if (item.getText().equals("Тестирование")) {
                item.click();
                break;
            }
        }
        return this;
    }

    public CoursesComponent checkCoursesNamesAndCount() {
        List<WebElement> courseNames = driver.findElements(By.cssSelector(coursesName));
        for (WebElement courses : courseNames) {
            String names = courses.getText();
            System.out.println(names);
            assertThat(courseNames.size()).isEqualTo(10);
        }
        return this;
    }
}
