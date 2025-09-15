package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class cookies {

    @Test
    void cookiesTask() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://claruswaysda.github.io/CookiesWait.html");

        // Accept alert if present
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (Exception e) {
            System.out.println("No alert present.");
        }

        // Print cookies before deletion
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies before deletion: " + cookies.size());
        for (Cookie cookie : cookies) {
            System.out.println(" - " + cookie.getName() + " = " + cookie.getValue());
        }

        // Delete all cookies
        driver.manage().deleteAllCookies();

        // Assert cookies are deleted
        assertEquals(0, driver.manage().getCookies().size());
        System.out.println("Cookies after deletion: " + driver.manage().getCookies().size());

        driver.quit();
    }
}
