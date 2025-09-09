package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T01ChromeOptionsConfigurationTest {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");      // maximize the window
        options.addArguments("--disable-extensions");   // disable extentions
        options.addArguments("--incognito");            //  incognito mode
        options.addArguments("disable-infobars");       // disable infobars

        driver = new ChromeDriver(options);
    }

    @Test
    public void testOpenExampleWebsite() throws InterruptedException {
        driver.get("https://www.example.com");
        Thread.sleep(5000);

        //
        String title = driver.getTitle();
        assertTrue(title.contains("Example"), "Title should contain 'Example'");
        Thread.sleep(5000);
    }

    @AfterAll
    public static void tearDown() {
            driver.quit();
    }
}
