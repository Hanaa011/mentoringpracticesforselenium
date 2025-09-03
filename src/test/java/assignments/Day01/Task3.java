package assignments.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

public class Task3 {
    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

            // Navigate to Amazon homepage
            driver.get("https://www.amazon.com/");

            // Get current window position
            Point position = driver.manage().window().getPosition();
            System.out.println("Initial Position: " + position);

            // Get current window size
            Dimension size = driver.manage().window().getSize();
            System.out.println("Initial Size: " + size);

            // Set a new window position (x=100, y=150)
            driver.manage().window().setPosition(new Point(100, 150));

            // Set a new window size (width=1200, height=800)
            driver.manage().window().setSize(new Dimension(1200, 800));

            // Verify new position and size
            Point newPosition = driver.manage().window().getPosition();
            Dimension newSize = driver.manage().window().getSize();

            System.out.println("New Position: " + newPosition);
            System.out.println("New Size: " + newSize);

            // Simple validation
            if (newPosition.getX() == 100 && newPosition.getY() == 150 &&
                    newSize.getWidth() == 1200 && newSize.getHeight() == 800) {
                System.out.println("Test Passed: Window is in the correct position and size.");
            } else {
                System.out.println("Test Failed: Window position/size mismatch.");
            }


            // Close the browser
            driver.quit();

    }
}