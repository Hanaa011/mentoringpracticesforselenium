package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class T03RadioButtonSelection {

    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/radio-button");
    }

    @Test
    public void testRadioButtons() throws InterruptedException {


        WebElement yesLabel = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        yesLabel.click();
        Thread.sleep(1000);
        WebElement resultYes = driver.findElement(By.className("text-success"));
        assertTrue(resultYes.getText().contains("Yes"));
        System.out.println("Yes radio button selected successfully!");


        WebElement impressiveLabel = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        impressiveLabel.click();
        Thread.sleep(1000);
        WebElement resultImpressive = driver.findElement(By.className("text-success"));
        assertTrue(resultImpressive.getText().contains("Impressive"));
        System.out.println("Impressive radio button selected successfully!");


        WebElement noLabel = driver.findElement(By.cssSelector("label[for='noRadio']"));
        noLabel.click();
        Thread.sleep(1000);
        System.out.println("Tried clicking No radio button (may be disabled).");
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
