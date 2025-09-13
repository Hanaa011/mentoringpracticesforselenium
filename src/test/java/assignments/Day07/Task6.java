package assignments.Day07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task6 {

    @Test
    void dropdownsTest() {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize browser window
        driver.get("https://claruswaysda.github.io/Dropdowns.html"); // Open the target URL

        // Create WebDriverWait with 10 seconds timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // 1. Traditional Dropdown
        // Click the dropdown to expand options
        driver.findElement(By.id("carSelect")).click();
        // Select the 'Ford' option from the dropdown
        driver.findElement(By.xpath("//select[@id='carSelect']/option[text()='Ford']")).click();

        // 2. Multi-Select Dropdown
        // Click the multi-select dropdown
        driver.findElement(By.id("multiCarSelect")).click();
        // Select the 'Mercedes' option
        driver.findElement(By.xpath("//select[@id='multiCarSelect']/option[text()='Mercedes']")).click();

        // 3. Custom Dropdown
        // Click the custom dropdown button to show options
        WebElement customBtn = driver.findElement(By.id("customDropdown"));
        customBtn.click();

        // Wait until the BMW option is present, then click it using JavaScript
        WebElement bmwOption = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@id='customDropdown']//a[text()='BMW']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bmwOption);

        // 4. Static Auto-Suggest
        // Type 'Tesla Model 3' in the static input field and click it
        WebElement staticInput = driver.findElement(By.id("staticInput"));
        staticInput.sendKeys("Tesla Model 3");
        staticInput.click();

        // 5. Dynamic Auto-Suggest
        // Type 'Toyota' in the dynamic input field (options appear dynamically)
        WebElement dynamicInput = driver.findElement(By.id("dynamicInput"));
        dynamicInput.sendKeys("Toyota");

        // Close the browser
        driver.quit();
    }
}
