package org.example.atestboilerplate.Page;

import org.example.atestboilerplate.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    WebElement usernameField = findElement(By.name("username"),10);
    WebElement passwordField = findElement(By.name("password"),10);
    WebElement loginButton = findElement(By.cssSelector("button[type='submit']"),10);

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
