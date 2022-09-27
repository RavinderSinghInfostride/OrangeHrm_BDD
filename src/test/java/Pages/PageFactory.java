package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    private LoginPage loginPage;
    private EmployeeTrackerPage employeeTrackerPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public EmployeeTrackerPage getEmployeeTrackerPage() {
        if (employeeTrackerPage == null) {
            employeeTrackerPage = new EmployeeTrackerPage(driver);
        }
        return employeeTrackerPage;
    }
}