package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C08GoogleSearchTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @Test
    public void searchMovies() throws InterruptedException {
        String[] movies = {"Green Mile", "Premonition", "The Curious Case of Benjamin Button"};

        for (String movie : movies) {
            // Find search box
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

            // Clear and enter movie name
            searchBox.clear();
            searchBox.sendKeys(movie);

            // Submit search
            searchBox.sendKeys(Keys.ENTER);
//driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click()
            Thread.sleep(2000);
            // Get and print result count
            WebElement resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'نتائج') or contains(text(),'results') or contains(text(),'About')]")
            ));
            System.out.println(movie + " → " + resultStats.getText());

            // Go back for next iteration
            driver.navigate().back();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
