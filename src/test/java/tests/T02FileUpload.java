package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Path;

public class T02FileUpload extends TestBase {
    /*
Go to https://claruswaysda.github.io/downloadUpload.html
Upload a PDF using single upload button
Verify that 'Files uploaded successfully!'
Do negative test (No file or other than PDF)
Verify that 'Please upload at least one PDF file. Only PDF files are allowed!'
Test multiple PDFs as well
*/

    // ملفاتك الثلاثة
    String fileName1 = "java revison.pdf";
    String fileName2 = "HW3.pdf";
    String fileName3 = "Lab5.pdf";

    Path path1 = Path.of("D:\\مستندات", fileName1);
    Path path2 = Path.of("D:\\مستندات", fileName2);
    Path path3 = Path.of("D:\\مستندات", fileName3);

    @Test
    void testFileUpload() throws InterruptedException {

        driver.get("https://claruswaysda.github.io/downloadUpload.html");

        // رفع ملف واحد
        driver.findElement(By.id("uploadInput")).sendKeys(path1.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
        System.out.println("Single file uploaded successfully!");

        // Negative test: لا ملف يتم رفعه
        driver.navigate().refresh();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("alertBox")).isDisplayed());
        System.out.println("Negative test passed: No file uploaded!");

        // رفع ملفات متعددة
        driver.findElement(By.id("multiUploadInput"))
                .sendKeys(path1.toString() + "\n" + path2.toString() + "\n" + path3.toString());
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Assertions.assertTrue(driver.findElement(By.id("successBox")).isDisplayed());
        System.out.println("All three PDF files uploaded successfully!");
    }
}
