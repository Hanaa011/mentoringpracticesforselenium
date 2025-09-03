package assignments.Day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task1 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

            // Navigate to Google homepage
            driver.get("https://www.google.com");

            // Get and print page title
            String pageTitle = driver.getTitle();
            System.out.println("Page Title: " + pageTitle);

            // Get and print current URL
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);

            // Simple validation
            if (currentUrl.contains("google")) {
                System.out.println("Test Passed: Google homepage loaded.");
            } else {
                System.out.println("Test Failed: Not Google.");
            }

            // Close all browser windows and end the session
            driver.quit();

    }
}