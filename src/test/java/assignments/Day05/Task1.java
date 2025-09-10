package assignments.Day05;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task1 {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
    }

    @Test
    public void testMultiSelectActions() {
        // Locate the multi-select element by ID
        WebElement multiSelectElement = driver.findElement(By.id("cars"));
        Select multiSelect = new Select(multiSelectElement);

        // Verify it's a multi-select
        Assertions.assertTrue(multiSelect.isMultiple(), "Element should support multiple selections");

        // Select 'Opel' using index (index 2)
        multiSelect.selectByIndex(2);
        // Deselect 'Opel' using index
        multiSelect.deselectByIndex(2);

        // Select 'Saab' using value
        multiSelect.selectByValue("saab");
        // Deselect 'Saab' using value
        multiSelect.deselectByValue("saab");

        // Deselect all options
        multiSelect.deselectAll();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
