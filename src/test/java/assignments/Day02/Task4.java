package assignments.Day02;


import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Needed to use @BeforeEach with @AfterAll
public class Task4 {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Launch Chrome browser and maximize window
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println(" Browser launched and maximized.");
    }

    @Test
    public void testNavigationTitles() {
        // Navigate to Google
        driver.get("https://www.google.com");
        System.out.println("Navigated to Google");
        assertTrue(driver.getTitle().contains("Google"),
                "Title does not contain 'Google'");

        // Navigate to YouTube
        driver.get("https://www.youtube.com");
        System.out.println("Navigated to YouTube");
        assertTrue(driver.getTitle().contains("YouTube"),
                "Title does not contain 'YouTube'");

        // Navigate to LinkedIn
        driver.get("https://www.linkedin.com");
        System.out.println("Navigated to LinkedIn");
        assertTrue(driver.getTitle().contains("LinkedIn"),
                "Title does not contain 'LinkedIn'");

        System.out.println(" All page titles verified.");
    }

    @Test
    public void testBackAndForwardNavigation() {
        // Navigate to Google → YouTube → LinkedIn
        driver.get("https://www.google.com");
        driver.get("https://www.youtube.com");
        driver.get("https://www.linkedin.com");

        // Navigate back twice → should return to Google
        driver.navigate().back();
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("google"),
                "Did not return to Google!");
        System.out.println("Successfully navigated back to Google: " + currentUrl);

        // Navigate forward twice → should go to LinkedIn
        driver.navigate().forward();
        driver.navigate().forward();
        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("linkedin"),
                "Did not go forward to LinkedIn!");
        System.out.println("Successfully navigated forward to LinkedIn: " + currentUrl);
    }

    @AfterAll
    public void tearDown() {
        // Quit the browser after all tests are done
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed (after all tests).\n");
        }
    }
}

