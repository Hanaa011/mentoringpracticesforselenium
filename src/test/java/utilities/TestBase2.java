package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBase2 {
    protected WebDriver driver;
    protected Logger logger;
    @BeforeEach
    void setUp() {
        logger= LogManager.getLogger(String.valueOf(TestBase2.class));
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger.info("chrome browser is initialized");
        driver.manage().window().maximize();
        ActionHelper actionHelper = new ActionHelper(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        logger.info("chrome browser is closed");
    }
}