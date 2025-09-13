package assignments.Day07;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task4 {


        static WebDriver driver;
        static Actions actions;

        @BeforeAll
        public static void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            actions = new Actions(driver);
        }

        @Test
        public void drawTriangleAndReset() throws InterruptedException {
            // 1. Open Draw page
            driver.get("https://claruswaysda.github.io/Draw.html");
            System.out.println("Opened Draw page");

            // 2. Draw a triangle on canvas
            WebElement canvas = driver.findElement(By.id("myCanvas"));

            // Coordinates for the triangle
            int startX = 100, startY = 100;
            int midX = 200, midY = 100;
            int endX = 150, endY = 200;

            actions.moveToElement(canvas, startX, startY)
                    .clickAndHold()
                    .moveByOffset(midX - startX, midY - startY)
                    .moveByOffset(endX - midX, endY - midY)
                    .moveByOffset(startX - endX, startY - endY)
                    .release()
                    .perform();

            System.out.println("Triangle drawn");

            Thread.sleep(1000); // wait to see the drawing

            // 3. Click Reset button
            WebElement resetBtn = driver.findElement(By.id("resetButton"));
            resetBtn.click();

            System.out.println("Canvas reset");
            Thread.sleep(1000); // wait to see the reset
        }

        @AfterAll
        public static void tearDown() {
            driver.quit();
            System.out.println("Browser closed");
        }
    }


