package assignments.Day02;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task3 {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Open Chrome browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Browser is opened and maximized.");
    }

    @Test
    public void testBrowserSize() {
        // Navigate to BBC website
        driver.get("https://www.bbc.com");
        System.out.println("Navigated to BBC.com");

        // Set browser size to 800x600
        Dimension size = new Dimension(800, 600);
        driver.manage().window().setSize(size);

        // Assert the window size
        Dimension currentSize = driver.manage().window().getSize();
        assertEquals(800, currentSize.getWidth(), "Width is not correct!");
        assertEquals(600, currentSize.getHeight(), "Height is not correct!");

        System.out.println("Browser size is 800x600");
    }

    @Test
    public void testBrowserPosition() {
        // Move the window to position (100, 100)
        Point position = new Point(100, 100);
        driver.manage().window().setPosition(position);

        // Assert the window position
        Point currentPosition = driver.manage().window().getPosition();
        assertEquals(100, currentPosition.getX(), "X position is not correct!");
        assertEquals(100, currentPosition.getY(), "Y position is not correct!");

        System.out.println("Browser moved to position (100, 100)");
    }

    @AfterEach
    public void tearDown() {
        // Close browser after each test
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed.\n");
        }
    }
}

