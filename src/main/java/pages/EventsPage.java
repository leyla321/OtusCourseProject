package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class EventsPage extends AbsBasePage {

    String eventCarts = ".dod_new-events__list.js-dod_new_events";
    String openWebinar = ".dod_new-type__text";
    By eventsDateLocator = By.cssSelector(".dod_new-event__date-text");
    WebElement typeDropdown = driver.findElement(By.cssSelector(".dod_new-events-dropdown__input-arrow"));
    WebElement eventType = driver.findElement(By.cssSelector(".dod_new-events-dropdown__list > a[title=\"Открытый вебинар\"]"));

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    public EventsPage viewOfEventsByType() {
        typeDropdown.click();
        eventType.click();
        return this;
    }

    public EventsPage eventsCard() {
        List<WebElement> eventList = driver.findElements(By.cssSelector(eventCarts));
        for (WebElement events : eventList) {
            String names = events.getText();
            System.out.println(names);
            assertThat(eventList.iterator().hasNext());
        }
        return this;
    }

    public EventsPage checkDisplayOfTheEvents() {
        List<WebElement> eventDisplayNames = driver.findElements(By.cssSelector(eventCarts));
        for (WebElement events : eventDisplayNames) {
            String names = events.getText();
            System.out.println(names);
        }
        return this;
    }

    public EventsPage assertThatOpenWebinarIsDisplayed() {
        List<WebElement> webinarOpen = driver.findElements(By.cssSelector(openWebinar));
        for (WebElement openWebinarList : webinarOpen) {
            String webinarName = openWebinarList.getText();
            System.out.println(webinarName);
            assertThat(webinarOpen).isEqualTo("Открытый вебинар");
        }
        return this;
    }

    public EventsPage eventsDateIsEqualOrGreaterThanTheCurrentDate() {
        waiters.waitForElementToBeVisible(eventsDateLocator);

        List<WebElement> eventsDate = driver.findElements(eventsDateLocator);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM");

        LocalDateTime currentDateTime = LocalDateTime.now();

        for (WebElement dateElement : eventsDate) {
            waiters.waitForElementToBeVisible(eventsDateLocator);

            String dateText = dateElement.getText();

            try {
                LocalDateTime eventDateTime = LocalDateTime.parse(dateText + " 2024", formatter);
                assertThat(eventDateTime).isAfterOrEqualTo(currentDateTime);
                System.out.println("Event date " + dateText + " is valid.");
            } catch (DateTimeParseException e) {
                System.err.println("Failed to parse date: " + dateText);
            }
        }
        return this;
    }
}
