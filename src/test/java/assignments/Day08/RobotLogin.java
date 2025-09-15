package assignments.Day08;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RobotLogin {

    @Test
    void robotLoginTest() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open the demo login page
        driver.get("https://the-internet.herokuapp.com/login");

        // 2. Click into the username field
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.click();

        // 3. Type the username using sendKeys
        usernameField.sendKeys("tomsmith");

        // 4. Use Robot class
        Robot robot = new Robot();
        robot.setAutoDelay(500);

        // Press TAB to move to password field
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        // 5. Type the password using sendKeys
        WebElement passwordField = driver.switchTo().activeElement();
        passwordField.sendKeys("SuperSecretPassword!");

        // Press ENTER to submit
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // 6. Verify login success or error message
        Thread.sleep(2000); // small wait to see result
        WebElement flashMessage = driver.findElement(By.id("flash"));
        String messageText = flashMessage.getText();
        System.out.println("Login message: " + messageText);

        assertTrue(messageText.contains("You logged into a secure area!"));

        driver.quit();
    }
}
