package assignments.Day07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task3 {

    static WebDriver driver;
    static Actions actions;
    static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // انتظار حتى 10 ثواني
    }

    @Test
    public void testDragAndDrop() {
        // 1. Open drag and drop page
        driver.get("https://claruswaysda.github.io/dragAndDrop.html");
        System.out.println("Opened dragAndDrop page");

        // 2. Drag each item to its correct place
        WebElement drag1 = driver.findElement(By.id("piece1"));
        WebElement drop1 = driver.findElement(By.id("slot1"));
        actions.dragAndDrop(drag1, drop1).perform();
        System.out.println("Drag1 dropped");

        WebElement drag2 = driver.findElement(By.id("piece2"));
        WebElement drop2 = driver.findElement(By.id("slot2"));
        actions.dragAndDrop(drag2, drop2).perform();
        System.out.println("Drag2 dropped");

        WebElement drag3 = driver.findElement(By.id("piece3"));
        WebElement drop3 = driver.findElement(By.id("slot3"));
        actions.dragAndDrop(drag3, drop3).perform();
        System.out.println("Drag3 dropped");

        // 3. Assert success message with explicit wait
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("celebrate")));
        assertTrue(successMsg.isDisplayed(), "Success message is not displayed!");
        System.out.println("Success message displayed: " + successMsg.getText());
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
