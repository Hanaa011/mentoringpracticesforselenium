package assignments.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task2 {
    public static void main(String[] args) {

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Navigate to YouTube homepage
        driver.get("https://www.youtube.com/");

        // Capture the page title
        String pageTitle = driver.getTitle();
        System.out.println("Page Title is: " + pageTitle);

        // Verify if the title contains the word "video"
        if (pageTitle.toLowerCase().contains("video")) {
            System.out.println("Test Passed: Title contains 'video'");
        } else {
            System.out.println("Test Failed: Title does NOT contain 'video'");
        }

        // Close the browser and end the session
        driver.quit();
    }
}