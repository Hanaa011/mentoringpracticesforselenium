package assignments.Day02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    WebDriver driver;

    // Setup
    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Test is running");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        System.out.println("Test finished");
    }

    // Test 1: Navigation back and forward
    @Test
    public void test1() {
        driver.navigate().to("https://www.wikipedia.org");
        System.out.println(driver.getTitle());
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.navigate().to("https://www.google.com");
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().back();
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Google"));

        driver.navigate().back();
        Assertions.assertTrue(driver.getTitle().contains("Wikipedia"));

        driver.navigate().forward();
        Assertions.assertTrue(driver.getTitle().contains("Google"));
    }

    // Test 2: Refresh on Google
    @Test
    public void test2() {
        driver.navigate().to("https://www.google.com");
        Assertions.assertTrue(driver.getTitle().contains("Google"));
        System.out.println("Page title contains Google");

        driver.navigate().refresh();
        Assertions.assertTrue(driver.getTitle().contains("Google"));
    }
}
