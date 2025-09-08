package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07Locators {
    static WebDriver driver;

    static String url ="https://www.linkedin.com/login";
    @BeforeAll
    public static void setUp() {
// TODO: Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
// TODO: Navigate to LinkedIn
        driver.get(url);
    }
    @Test
    public void testLoginElements() {
// TODO: Locate email field using By.id
// TODO: Locate password field using By.name
// TODO: Locate sign-in button using By.xpath
// TODO: Enter test credentials
// TODO: Verify elements are displayed
    }
    @AfterAll
    public static void tearDown() {
// TODO: Close driver
    }
}

