package assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1 {

    @Test
    void windowHandleTest() {
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Go to the main page
        driver.get("https://claruswaysda.github.io/");

        // Click on 'Window Handle'
        driver.findElement(By.linkText("Window Handle")).click();

        // Click on 'Open Index Page' button
        WebElement linkButton = driver.findElement(By.cssSelector("a[href='index.html']"));
        linkButton.click();
        // Get the original window handle
        String originalWindow = driver.getWindowHandle();

        // Switch to the new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Verify the URL of the new window
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://claruswaysda.github.io/index.html", currentUrl, "URL verification failed!");

        // Close the new window and switch back to the original
        driver.close();
        driver.switchTo().window(originalWindow);

        // Close the original window
        driver.quit();
    }
}
