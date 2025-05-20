package org.example.atestboilerplate.Test;

import org.example.atestboilerplate.Base.BaseTest;
import org.example.atestboilerplate.Page.AdminPage;
import org.example.atestboilerplate.Page.InventoryPage;
import org.example.atestboilerplate.Page.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public  static  final String SORT_A_Z="Name (A to Z)";
    @Test
    public void TC01_LoginWithValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        assertCondition(driver.getCurrentUrl().contains("dashboard"), true, "Login failed with valid credentials");
    }
    @Test
    public void TC02_SearchUserInAdmin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdminTab();
        adminPage.searchUser("Admin");

        assertCondition(adminPage.isResultDisplayed("Admin"), true, "Search failed to find expected user");
    }

    @Test
    public void TC03_FilterByUserRole() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdminTab();
        adminPage.filterByUserRole("Admin");

        assertCondition(adminPage.isResultDisplayed("Admin"), true, "Filtering by user role failed.");
    }
    @Test
    public void TC04_FilterByStatus() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdminTab();
        adminPage.filterByStatus("Enabled");

        assertCondition(adminPage.isResultDisplayed("Enabled"), true, "Filtering by status failed.");
    }
    @Test
    public void TC05_EditUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        AdminPage adminPage = new AdminPage(driver);
        adminPage.goToAdminTab();
        adminPage.searchUser("Admin");

        adminPage.editFirstUser();

        assertCondition(driver.getPageSource().contains("Successfully Updated") || driver.getCurrentUrl().contains("viewSystemUsers"), true, "Edit user failed.");
    }


}
