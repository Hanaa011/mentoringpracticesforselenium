package assignments.Day05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task2{

    @Test
    public void testSelectMenu() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");

        // Select Old Style Select Menu using element id
        WebElement oldStyleMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleMenu);

        // Print all dropdown options
        System.out.println("Dropdown options:");
        for (WebElement option : select.getOptions()) {
            System.out.println("- " + option.getText());
        }

        // Select 'Purple' using index
        select.selectByIndex(4);
        System.out.println("Selected by index: Purple");

        // Select 'Magenta' using visible text
        select.selectByVisibleText("Magenta");
        System.out.println("Selected by visible text: Magenta");

        // Select 'Yellow' using value
        select.selectByValue("3");
        System.out.println("Selected by value: Yellow");

        // Close browser
        driver.quit();
    }
}
