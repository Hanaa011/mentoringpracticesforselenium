package assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {

    @Test
    void windowHandleTest() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Go to the main page
        driver.get("https://claruswaysda.github.io/");

        // Save the original window
        String originalWindow = driver.getWindowHandle();

        // Click on 'Window Handle'
        driver.findElement(By.linkText("Window Handle")).click();

        // Switch to the new tab (Window Handle page)
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Click on 'Open Index Page' button
        WebElement linkButton = driver.findElement(By.id("openIndex"));
        linkButton.click();

        // Save the current (Window Handle) tab
        String windowHandlePage = driver.getWindowHandle();

        // Switch to the new tab (Index page)
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow) && !window.equals(windowHandlePage)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Verify the URL of the new window
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://claruswaysda.github.io/index.html", currentUrl, "URL verification failed!");

        // Close all windows
        driver.quit();
    }
}
