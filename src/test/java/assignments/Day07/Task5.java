package assignments.Day07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task5 {


        static WebDriver driver;
        static WebDriverWait wait;

        @BeforeAll
        public static void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        // Method to flash an element
        public void flashElement(WebElement element) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String originalColor = element.getCssValue("backgroundColor");
            for (int i = 0; i < 3; i++) {
                js.executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
                sleep(200);
                js.executeScript("arguments[0].style.backgroundColor = '" + originalColor + "'", element);
                sleep(200);
            }
        }

        public void sleep(int millis) {
            try { Thread.sleep(millis); } catch (InterruptedException e) { }
        }

        @Test
        public void testRegisterAndLogin() {
            // 1. Go to form page
            driver.get("https://claruswaysda.github.io/form.html");

            // 2. Fill all fields with flash
            WebElement snn = driver.findElement(By.name("ssn"));
            flashElement(snn);
            snn.sendKeys("123-45-6789");

            WebElement firstName = driver.findElement(By.name("first-name"));
            flashElement(firstName);
            firstName.sendKeys("lara");

            WebElement lastName = driver.findElement(By.name("last-name"));
            flashElement(lastName);
            lastName.sendKeys("moiad");

            WebElement address = driver.findElement(By.name("address"));
            flashElement(address);
            address.sendKeys("123 Main St, City, Country");


            WebElement phone = driver.findElement(By.name("phone"));
            flashElement(phone);
            phone.sendKeys("0501234567");

            WebElement user = driver.findElement(By.name("username"));
            flashElement(user);
            phone.sendKeys("lara123");


            WebElement email = driver.findElement(By.name("email"));
            flashElement(email);
            email.sendKeys("lara@test.com");



            WebElement password = driver.findElement(By.name("password"));
            flashElement(password);
            password.sendKeys("Test1234!");

            WebElement Cpassword = driver.findElement(By.name("confirm-password"));
            flashElement(Cpassword);
            Cpassword.sendKeys("Test1234!");




            // 3. Submit registration
            WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            flashElement(submitBtn);
            submitBtn.click();

            // 4. Login after registration
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            WebElement loginEmail = driver.findElement(By.id("username"));
            flashElement(loginEmail);
            loginEmail.sendKeys("lara123");

            WebElement loginPassword = driver.findElement(By.id("password"));
            flashElement(loginPassword);
            loginPassword.sendKeys("Test1234!");

            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']")); // type="submit"
            flashElement(loginBtn);
            loginBtn.click();

            // 5. Celebrate login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.backgroundColor = 'lightgreen'");
            System.out.println("Login successful! Celebration done.");
        }

        @AfterAll
        public static void tearDown() {
            sleepStatic(2000); // let celebration show
            driver.quit();
        }

        public static void sleepStatic(int millis) {
            try { Thread.sleep(millis); } catch (InterruptedException e) { }
        }
    }


