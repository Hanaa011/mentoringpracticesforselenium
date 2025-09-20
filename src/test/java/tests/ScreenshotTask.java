package tests;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.Duration;

public class ScreenshotTask extends TestBase {

    @Test
    void userRegistrationAndScreenshots() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // 1. Go to form page
        driver.get("https://claruswaysda.github.io/form.html");
        System.out.println("Navigated to registration form page.");

        // 2. Fill all fields
        driver.findElement(By.name("ssn")).sendKeys("123-45-6789");
        driver.findElement(By.name("first-name")).sendKeys("lara");
        driver.findElement(By.name("last-name")).sendKeys("moiad");
        driver.findElement(By.name("address")).sendKeys("123 Main St, City, Country");
        driver.findElement(By.name("phone")).sendKeys("0501234567");
        driver.findElement(By.name("username")).sendKeys("lara123");
        driver.findElement(By.name("email")).sendKeys("lara@test.com");
        driver.findElement(By.name("password")).sendKeys("Test1234!");
        driver.findElement(By.name("confirm-password")).sendKeys("Test1234!");
        System.out.println("All form fields filled.");

        // Screenshot after filling form
        takeScreenshot("registration_filled.png");
        System.out.println("Screenshot taken after filling registration form.");

        // 3. Submit registration
        WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        submitBtn.click();
        System.out.println("Registration form submitted.");

        // 4. Wait for login page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        WebElement loginUsername = driver.findElement(By.id("username"));
        WebElement loginPassword = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

        // 5. Fill login
        loginUsername.sendKeys("lara123");
        loginPassword.sendKeys("Test1234!");
        Thread.sleep(1000);
        takeScreenshot("before_login.png");
        System.out.println("Screenshot taken before login.");

        // 6. Click login
        loginBtn.click();
        System.out.println("Login button clicked.");

        // 7. Wait for userIcon to appear after login
        Thread.sleep(1000);
        takeScreenshot("after_login.png");
        System.out.println("Login successful! Screenshot taken after login.");

        // 8. Optional celebration (change background)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.backgroundColor = 'lightgreen'");
        System.out.println("Celebration done: background changed to light green.");
    }

    private void takeScreenshot(String fileName) throws IOException {

            // أخذ السكرين شوت
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // تحديد المسار (داخل مجلد screenshots)
            Path path = Path.of(System.getProperty("user.dir"), "screenshots", fileName);

            // إنشاء المجلد إذا مو موجود
            File directory = path.getParent().toFile();
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // نسخ الملف
            FileUtils.copyFile(screenshot, path.toFile());

            System.out.println("Screenshot saved: " + path.toAbsolutePath());
        }
}
