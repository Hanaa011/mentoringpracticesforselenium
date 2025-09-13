package assignments.Day06;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task2 {

    static WebDriver driver;
    static Actions actions;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    public void testAllActions() {
        // 1. Open submit button page and click automatically
        driver.get("https://claruswaysda.github.io/submit-button.html");
        WebElement submitBtn = driver.findElement(By.id("submitButton"));
        submitBtn.click();
        System.out.println("Submit button clicked successfully");

        // 2. Navigate automatically to actions page
        driver.get("https://claruswaysda.github.io/actionsClickDrag.html");
        System.out.println("Navigated to actionsClickDrag page");

        // 3. Drag and Drop
        WebElement drag = driver.findElement(By.id("drag1"));
        WebElement drop = driver.findElement(By.id("drop1"));
        actions.dragAndDrop(drag, drop).perform();
        System.out.println("Drag and Drop performed successfully");

        // 4. Right Click
        WebElement rightClickBtn = driver.findElement(By.id("showSuccessButton"));
        actions.contextClick(rightClickBtn).perform();
        System.out.println("Right Click performed successfully");

        // 5. Double Click
        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickButton"));
        actions.doubleClick(doubleClickBtn).perform();
        System.out.println("Double Click performed successfully");

        // 6. Hover over element
        WebElement hoverBtn = driver.findElement(By.id("hoverButton"));
        actions.moveToElement(hoverBtn).perform();
        System.out.println("Hover over element performed successfully");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}
