package org.example.atestboilerplate.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Custom assertion method to verify if a condition matches the expected result (true or false).
     * This method will throw an AssertionError with a custom message if the condition does not match the expected boolean value.
     * @param actual The actual condition to be checked.
     * @param expected The expected boolean value (true or false).
     * @param message The message to be displayed if the assertion fails.
     */
    public void assertCondition(boolean actual, boolean expected, String message) {
        if (actual != expected) {
            System.err.println("Assertion failed: " + message);
            throw new AssertionError(message + " (Expected: " + expected + ", but got: " + actual + ")");
        }
    }
}
