package assignments.Day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2 {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Open Chrome browser and maximize window
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(" Browser is opened and maximized.");
    }

    @Test
    public void testSeleniumPageSource() {
        // Navigate to Selenium website
        driver.get("https://www.selenium.dev");
        System.out.println(" Navigated to Selenium.dev");

        // Get page source and check if it contains "WebDriver"
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("WebDriver"),
                "Page source does not contain expected text: WebDriver");

        // Print success message if assertion passes
        System.out.println("Selenium page contains 'WebDriver'");
    }

    @Test
    public void testPythonPageSource() {
        // Navigate to Python website
        driver.get("https://www.python.org");
        System.out.println(" Navigated to Python.org");

        // Get page source and check if it contains "Python"
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Python"),
                "Page source does not contain expected text: Python");

        // Print success message if assertion passes
        System.out.println(" Python page contains 'Python'");
    }

    @AfterEach
    public void tearDown() {
        // Close browser after each test
        if (driver != null) {
            driver.quit();
            System.out.println(" Browser closed.\n");
        }
    }
}
