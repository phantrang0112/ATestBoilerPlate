package org.example.atestboilerplate.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Finds an element with a custom timeout.
     * @param locator The locator of the element.
     * @param time Timeout in seconds.
     * @return WebElement after waiting.
     */
    protected WebElement findElement(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Finds multiple elements with a custom timeout.
     * Waits until at least one is visible.
     *
     * @param locator The locator of the elements.
     * @param time Timeout in seconds.
     * @return List of WebElements after waiting.
     */
    protected List<WebElement> findElements(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator); // Return all matching elements
    }
}
