package assignments.Day03;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2 {

    WebDriver driver;

    // Absolute XPath (long and fragile)
    String absoluteUsernameXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input";
    String absolutePasswordXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[2]/div/div[2]/input";
    String absoluteLoginBtnXPath = "/html/body/div/div/div/div/div/div[2]/div[2]/form/div[3]/button";

    // Relative XPath (short and flexible)
    String relativeUsernameXPath = "//input[@name='username']";
    String relativePasswordXPath = "//input[@name='password']";
    String relativeLoginBtnXPath = "//button[@type='submit']";

    @BeforeEach
    void setUp() throws InterruptedException {
        // Launch Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(5000);
    }

    @Test
    void relativeXpathTest() throws InterruptedException {
        // Locate username field with relative XPath
        WebElement username = driver.findElement(By.xpath(relativeUsernameXPath));
        username.sendKeys("Admin");

        // Locate password field with relative XPath
        WebElement password = driver.findElement(By.xpath(relativePasswordXPath));
        password.sendKeys("admin123");

        // Locate login button with relative XPath
        WebElement loginBtn = driver.findElement(By.xpath(relativeLoginBtnXPath));
        loginBtn.click();

        Thread.sleep(5000);

        // Assert login is successful (URL contains "dashboard")
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @Test
    void absoluteXpathTest() throws InterruptedException {
        // Locate username field with absolute XPath
        WebElement username = driver.findElement(By.xpath(absoluteUsernameXPath));
        username.sendKeys("Admin");

        // Locate password field with absolute XPath
        WebElement password = driver.findElement(By.xpath(absolutePasswordXPath));
        password.sendKeys("admin123");

        // Locate login button with absolute XPath
        WebElement loginBtn = driver.findElement(By.xpath(absoluteLoginBtnXPath));
        loginBtn.click();

        Thread.sleep(5000);

        // Assert login is successful (URL contains "dashboard")
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
    }

    @AfterEach
    void tearDown() {
        // Close browser
        driver.quit();
    }

}
