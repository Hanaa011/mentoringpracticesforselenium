package assignments.Day04;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class Task1 {


        @Test
        public void testCheckboxes() {
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/checkboxes");

            // Locate both checkboxes
            WebElement checkbox1 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
            WebElement checkbox2 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(1);

            // Check and select if not already selected
            if (!checkbox1.isSelected()) {
                checkbox1.click();
            }
            if (!checkbox2.isSelected()) {
                checkbox2.click();
            }

            // Verify both are selected
            assertTrue(checkbox1.isSelected(), "Checkbox 1 should be selected");
            assertTrue(checkbox2.isSelected(), "Checkbox 2 should be selected");

            // Print status
            System.out.println("Checkbox 1 selected: " + checkbox1.isSelected());
            System.out.println("Checkbox 2 selected: " + checkbox2.isSelected());

            driver.quit();
        }


}
