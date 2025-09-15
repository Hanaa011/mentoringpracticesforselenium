package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class C37DownloadFile extends TestBase {
    /*
Go to URL: https://the-internet.herokuapp.com/download
    Download selenium-login_exeption.png
    Verify if the file downloaded successfully.
*/

    @Test
    public void FileDownLoadTest() throws InterruptedException, IOException {
        By seleniumSnapLinkText = By.linkText("selenium-snapshot.png");

        //Go to URL: https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        //Download selenium-snapshot.png

        driver.findElement(seleniumSnapLinkText).click();
        Thread.sleep(2000);

        //Verify if the file downloaded successfully
        String filePath = "/Users/hanaa/Downloads/selenium-snapshot.png";
        Assertions.assertTrue(Files.exists(Path.of(filePath)));

        Files.deleteIfExists(Path.of(filePath));

    }
}