package assignments.Day03;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task1 {

        WebDriver driver;

        @BeforeEach
        public void setUp() {
            // Launch Chrome browser
            driver = new ChromeDriver();
            // Maximize the browser window
            driver.manage().window().maximize();
        }

        @Test
        public void testHerokuAppNavigation() throws InterruptedException {
            // Navigate to main test page
            driver.get("https://testpages.herokuapp.com/styled/index.html");

            // Click on "Locators - Find By Playground Test Page"
            WebElement locatorsLink = driver.findElement(By.linkText("Locators - Find By Playground Test Page"));
            locatorsLink.click();
            Thread.sleep(1000); // wait for navigation

            // Print current URL
            System.out.println("Current URL after Locators click: " + driver.getCurrentUrl());

            // Navigate back
            driver.navigate().back();
            Thread.sleep(1000);

            // Print URL after going back
            System.out.println("URL after going back: " + driver.getCurrentUrl());

            // Click on "WebDriver Example Page"
            WebElement webDriverExampleLink = driver.findElement(By.linkText("WebDriver Example Page"));
            webDriverExampleLink.click();
            Thread.sleep(1000);

            // Print current URL
            System.out.println("Current URL after WebDriver Example click: " + driver.getCurrentUrl());

            // Enter value 20 in number input
            WebElement numberInput = driver.findElement(By.id("numentry"));
            numberInput.sendKeys("20");
            Thread.sleep(1000);

            // Click "Submit" button
            WebElement submitBtn = driver.findElement(By.id("submit-to-server"));
            submitBtn.click();
            Thread.sleep(1000);

            // Verify the result message contains "two, zero"
            WebElement resultMsg = driver.findElement(By.id("message"));
            String msgText = resultMsg.getText();
            System.out.println("Result Message: " + msgText);

            assertTrue(msgText.contains("two, zero")); // check if correct message is shown
        }

        @AfterEach
        public void tearDown() {
            // Close the browser after each test
            driver.quit();
        }


}
