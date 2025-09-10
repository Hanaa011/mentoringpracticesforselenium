package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class deleteCart{

    @Test
    void delete() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/deleteChars.html");


        driver.findElement(By.id("inputText")).sendKeys("John Doe");
        driver.findElement(By.id("enterButton")).click();


        for (int i = 0; i < 8; i++) {
            driver.findElement(By.id("deleteButton")).click();
        }


        String deletedMessage = driver.findElement(By.id("displayText")).getText();
        System.out.println("the message " + deletedMessage);

        if (deletedMessage.equals("Deleted")) {
            System.out.println("Test Passed: The message is 'Deleted'");
        } else {
            System.out.println("Test Failed: The message is not 'Deleted'");
        }


        driver.quit();
    }
}
