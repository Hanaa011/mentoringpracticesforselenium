package assignments.Day06;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task1 {

    @Test
    void emojiTask() {
        // 1. Open the browser and maximize the window
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

        // 2. Switch to the iframe
        WebElement iframe = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iframe);

        // 3. Click on the second emoji tab
        WebElement secondEmojiTab = driver.findElement(By.xpath("//a[@href='#nature']"));
        secondEmojiTab.click();

        // 4. Click all items under the second emoji tab
        List<WebElement> emojiItems = driver.findElements(By.xpath("//div[@id='nature']//img"));
        for (WebElement emoji : emojiItems) {
            emoji.click();
        }

        // 5. Switch back to the parent frame
        driver.switchTo().defaultContent();

        // 6. Fill out the form
        driver.findElement(By.id("text")).sendKeys("Hanaa");
        driver.findElement(By.id("smiles")).sendKeys("Smile");
        driver.findElement(By.id("nature")).sendKeys("Nature");
        driver.findElement(By.id("food")).sendKeys("Pizza");
        driver.findElement(By.id("activities")).sendKeys("Football");
        driver.findElement(By.id("places")).sendKeys("Beach");
        driver.findElement(By.id("objects")).sendKeys("Laptop");
        driver.findElement(By.id("symbols")).sendKeys("Heart");
        driver.findElement(By.id("flags")).sendKeys("Saudi Arabia");

        // 7. Click the Apply button
        driver.findElement(By.id("send")).click();

        // 8. Close the browser (optional)
        driver.quit();
    }
}
