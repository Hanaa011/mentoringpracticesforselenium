package assignments.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

import static java.lang.Thread.sleep;

public class Task4 {
    public static void main(String[] args) {


        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

            // Open Google homepage
            driver.get("https://www.google.com/");

            // Maximize the window
            driver.manage().window().maximize();

            // Print current position and size
            Point position = driver.manage().window().getPosition();
            Dimension size = driver.manage().window().getSize();
            System.out.println("Maximized -> Position: " + position + " | Size: " + size);

            // Minimize the window
            driver.manage().window().minimize();
            System.out.println("Window minimized...");

            // Wait for 5 seconds in minimized state
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Maximize again
            driver.manage().window().maximize();
            Point newPosition = driver.manage().window().getPosition();
            Dimension newSize = driver.manage().window().getSize();
            System.out.println("After Re-Maximize -> Position: " + newPosition + " | Size: " + newSize);

            // Fullscreen mode
            driver.manage().window().fullscreen();
            Point fullPosition = driver.manage().window().getPosition();
            Dimension fullSize = driver.manage().window().getSize();
            System.out.println("Fullscreen -> Position: " + fullPosition + " | Size: " + fullSize);


            // Close the browser
            driver.quit();

    }
}