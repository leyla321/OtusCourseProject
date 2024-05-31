package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoursesCountComponent extends AbsBaseComponent {

    private String coursesName = ".sc-18q05a6-1.bwGwUO > a";

    public CoursesCountComponent(WebDriver driver) {
        super(driver);
    }

    public CoursesCountComponent checkCoursesNames() {
        List<WebElement> courseNames = driver.findElements(By.cssSelector(coursesName));
        for (WebElement courses : courseNames) {
            String names = courses.getText();
            System.out.println(names);
            assertThat(courseNames.size()).isEqualTo(10);
        }
        return this;
    }
}
