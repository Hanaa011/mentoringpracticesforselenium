package assignments.Day08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClickAllButtonsTest {

    @Test
    void clickAllButtons() {
        // Launch browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/");

        // Find all buttons
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        // Expected number of buttons
        int expectedCount = buttons.size();

        // Click all buttons one by one
        int clickedCount = 0;
        for (WebElement button : buttons) {
            button.click();
            clickedCount++;
        }

        // Assertion: make sure all buttons were clicked
        assertEquals(expectedCount, clickedCount, "Not all buttons were clicked!");
        System.out.println("All buttons were clicked successfully!");

        // Close browser
        driver.quit();
    }
}
