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

public class Task2 {

    static WebDriver driver;
    static Actions actions;
    static WebDriverWait wait;

    @BeforeAll

    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testAllActions() {

        driver.get("https://claruswaysda.github.io/submit-button.html");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
        submitBtn.click();
        System.out.println("Submit button clicked successfully");


        driver.get("https://claruswaysda.github.io/actionsClickDrag.html");
        System.out.println("Navigated to actionsClickDrag page");

        // 3. Drag and Drop
        WebElement drag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drag1")));
        WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drop1")));
        actions.dragAndDrop(drag, drop).perform();
        System.out.println("Drag and Drop performed successfully");

        // 4. Right Click
        WebElement rightClickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showSuccessButton")));
        actions.contextClick(rightClickBtn).perform();
        System.out.println("Right Click performed successfully");

        // 5. Double Click
        WebElement doubleClickBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickButton")));
        actions.doubleClick(doubleClickBtn).perform();
        System.out.println("Double Click performed successfully");

        // 6. Hover over element
        WebElement hoverBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hoverButton")));
        actions.moveToElement(hoverBtn).perform();
        System.out.println("Hover over element performed successfully");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
