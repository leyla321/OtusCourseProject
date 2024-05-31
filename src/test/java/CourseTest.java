import components.CardComponent;
import components.CoursesComponent;
import drivers.WebDriverFactory;
import exceptions.DriverNotSupportedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.EventsPage;
import pages.MainPage;

import java.net.MalformedURLException;
import java.util.Locale;

public class CourseTest {

    private WebDriver driver = null;
    private final String browserName = System.getProperty("browser", "chrome").toLowerCase(Locale.ROOT);

    @BeforeEach
    public void init() throws DriverNotSupportedException, MalformedURLException {
        driver = (new WebDriverFactory()).create();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMainMenuClickCourseItem() {
        new MainPage(driver)
                .open("/");

        new CoursesComponent(driver)
                .selectTestingElement()
                .checkCoursesNamesAndCount();
    }

    @Test
    public void clickCourseAndDisplayData() {
        goToCards();
        new CardComponent(driver)
                .clickFirstCourse().
                checkName().
                checkDescription().
                checkDuration().
                checkFormat();
    }

    @Test
    public void validationOfDateOfEvent() {
        goToEvents();
        new EventsPage(driver)
                .eventsCard();
    }

    @Test
    public void viewEventsByType() {
        goToEvents();
        new EventsPage(driver)
                .viewOfEventsByType().
                checkDisplayOfTheEvents().
                eventsDateIsEqualOrGreaterThanTheCurrentDate();
    }

    public void goToCards() {
        new MainPage(driver)
                .open("/catalog/courses?categories=testing");
    }

    public void goToEvents() {
        new MainPage(driver)
                .open("/events/near/");
    }
}
