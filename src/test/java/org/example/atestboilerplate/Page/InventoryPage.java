package org.example.atestboilerplate.Page;

import org.example.atestboilerplate.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{

    Select dropdown = new Select(findElement(By.id("product_sort_container"), 10));
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void sortByNameAZ(String text) {
        dropdown.selectByVisibleText(text);
    }

    public String getFirstItemName() {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }
}
