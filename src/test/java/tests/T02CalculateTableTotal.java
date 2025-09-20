package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase2;

import java.util.List;
import java.util.logging.Logger;

public class T02CalculateTableTotal extends TestBase2 {
    /*
    Go to https://claruswaysda.github.io/webTable.html
    Calculate and assert the total price in Table 2.
    */

    // Create Logger
    private static final Logger logger = Logger.getLogger(T02CalculateTableTotal.class.getName());

    @Test
    void test(){
        // Go to the page
        driver.get("https://claruswaysda.github.io/webTable.html");
        logger.info("Opened the web page.");

        // Get all prices in Table 2 (3rd column)
        List<WebElement> priceList = driver.findElements(By.xpath("//table[2]//tr/td[3]"));
        logger.info("Found " + priceList.size() + " prices in Table 2.");

        int total = 0;
        for (WebElement price : priceList) {
            int priceNum = Integer.parseInt(price.getText().substring(1)); // remove $
            total += priceNum;

            // Log each price and running total
            logger.info("Added: " + priceNum + " | Running total: " + total);
        }

        // Final total log
        logger.info("Final Total = " + total);

        // Assert total
        Assertions.assertEquals(2275, total);
        logger.info("✅ Assertion passed: Total price is correct.");
    }
}
