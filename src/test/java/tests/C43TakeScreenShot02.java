package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.JavaScriptUtils;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Path;

public class C43TakeScreenShot02 extends TestBase {
    /*
    Go to Linkedin
    Take homepage's screenshot
    Take logo's screenshot
*/

    @Test
    public void screenShotWithTestBaseTest() throws InterruptedException {
        driver.get("https://www.linkedin.com");
        Thread.sleep(3000);

        TakesScreenshot ss =(TakesScreenshot) driver;
        File screenShot = ss.getScreenshotAs(OutputType.FILE);
        String screenShotsName = "";
        Path screenShotPath = Path.of(System.getProperty("user.dir"), "Target","test-output", "screenshots","linkedinHomePage.png");

    }
}