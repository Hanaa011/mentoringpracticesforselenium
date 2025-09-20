package assignments.Day09;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class Task2 extends TestBase {

    @Test
    public void findYoungestRecord() throws InterruptedException {
        // Open the web page
        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");

        Faker faker = new Faker();
        List<String> names = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();

        // Add 10 records
        for (int i = 0; i < 10; i++) {
            String firstName = faker.name().firstName();
            int age = faker.number().numberBetween(18, 60); // Age between 18 and 60

            names.add(firstName);
            ages.add(age);

            // Enter name and age
            driver.findElement(By.id("nameInput")).sendKeys(firstName);
            driver.findElement(By.id("ageInput")).sendKeys(String.valueOf(age));

            // Select a random country from the dropdown
            WebElement countryDropdown = driver.findElement(By.id("countrySelect"));
            Select select = new Select(countryDropdown);
            List<WebElement> options = select.getOptions();
            int randomIndex = faker.number().numberBetween(1, options.size());
            select.selectByIndex(randomIndex);

            // Click the Submit button
            WebElement submitButton = driver.findElement(By.xpath("//button[@onclick='addRecord()']"));
            submitButton.click();

            Thread.sleep(500);
        }

        // Find the youngest age
        int minAge = ages.get(0);
        int minIndex = 0;
        for (int i = 1; i < ages.size(); i++) {
            if (ages.get(i) < minAge) {
                minAge = ages.get(i);
                minIndex = i;
            }
        }

        // Print the youngest person's name and age in the console
        System.out.println("Youngest person is: " + names.get(minIndex) + " with age: " + minAge);

        // Close the browser
        driver.quit();
    }
}
