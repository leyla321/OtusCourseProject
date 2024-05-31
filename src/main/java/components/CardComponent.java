package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardComponent extends AbsBaseComponent {
    List<WebElement> courses = driver.findElements(By.cssSelector(".sc-zzdkm7-0.hHWAES"));

    public CardComponent(WebDriver driver) {
        super(driver);
    }

    public CardComponent clickFirstCourse() {
        if (!courses.isEmpty()) {
            WebElement firstCourse = courses.get(0);
            firstCourse.click();
        } else {
            System.out.println("No courses found with the specified selector.");
        }
        return this;
    }

    public CardComponent checkName() {
        WebElement courseName = driver.findElement(By.xpath("//h1"));
        assertThat(courseName.isDisplayed()).isTrue();
        assertThat(courseName.getText()).isNotEmpty();
        return this;
    }

    public CardComponent checkDescription() {
        WebElement courseDescription = driver.findElement(By.cssSelector(".sc-1og4wiw-0.sc-pyhrzd-0.gcChXs.jpjhPZ"));
        assertThat(courseDescription.isDisplayed()).isTrue();
        assertThat(courseDescription.getText()).isNotEmpty();
        return this;
    }

    public CardComponent checkDuration() {
        WebElement courseDuration = driver.findElement(By.xpath("//div/p[contains(text(), '4 месяца')]"));
        assertThat(courseDuration.isDisplayed()).isTrue();
        assertThat(courseDuration.getText()).isNotEmpty();
        return this;
    }

    public CardComponent checkFormat() {
        WebElement courseFormat = driver.findElement(By.xpath("//div/p[contains(text(), 'Онлайн')]"));
        assertThat(courseFormat.isDisplayed()).isTrue();
        assertThat(courseFormat.getText()).isNotEmpty();
        return this;
    }
}
