package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class C01NavigateBackAndForward {
    public static void main(String[] args) throws InterruptedException {
        /*
         TC - 01

 Invoke Chrome Browser 
 Navigate to URL: https://www.w3schools.com/ 
 Navigate to URL: https://stackoverflow.com/ 
Come back to the w3schools using the back command. 
 Again go back to the stackoverflow website using forward command 
Refresh the Browser using refresh command. 
 Close the Browser.

         */

        //invoke chrome
        WebDriver driver = new ChromeDriver();

        //navigate to url
        driver.navigate().to("https://www.w3schools.com/");

        //navigate to url
        driver.navigate().to("https://stackoverflow.com/");

        //Come back to the w3schools using the back command.
        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(1000);


        //close the browser
        driver.close(); // -> close the current tab
        driver.quit();  // -> close all tabs + end the session
    }
}
