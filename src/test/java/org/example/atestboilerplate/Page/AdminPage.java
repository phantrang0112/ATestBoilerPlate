package org.example.atestboilerplate.Page;

import org.example.atestboilerplate.Base.BasePage;
import org.example.atestboilerplate.Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    WebElement adminTab = findElement(By.xpath("//span[text()='Admin']"),5);
    WebElement searchUsername = findElement(By.xpath("//label[text()='Username']/following::input[1]"),5);
    WebElement userRoleDropdown = findElement(By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-wrapper']"),5);
    WebElement statusDropdown = findElement(By.xpath("//label[text()='Status']/following::div[@class='oxd-select-wrapper']"),5);
    WebElement searchButton = findElement(By.xpath("//button[@type='submit']"),5);
    WebElement editButton = findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']"),5);
    WebElement saveButton = findElement(By.xpath("//button[@type='submit']"),5);

    public void goToAdminTab() {
        adminTab.click();
    }

    public void searchUser(String username) {
        searchUsername.sendKeys(username);
        searchButton.click();
    }

    public void filterByUserRole(String role) {
        userRoleDropdown.click();
        findElement(By.xpath("//span[text()='" + role + "']"), 5).click();
        searchButton.click();
    }

    public void filterByStatus(String status) {
        statusDropdown.click();
        findElement(By.xpath("//span[text()='" + status + "']"), 5).click();
        searchButton.click();
    }

    public void editFirstUser() {
        editButton.click();
        saveButton.click();
    }

    public boolean isResultDisplayed(String text) {
        return driver.getPageSource().contains(text);
    }
}
