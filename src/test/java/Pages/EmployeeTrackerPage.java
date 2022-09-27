package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EmployeeTrackerPage {
    WebDriver driver;
    WebDriverWait wait;

    By performanceSideMenuItem = By.xpath("(//a[@class='oxd-main-menu-item']//span)[6]");
    By employeeTrackerNavMenuOption = By.xpath("//a[contains(text(),'Employee Trackers')]");
    By employeeNameInputBox = By.xpath("//div[contains(@class,'oxd-autocomplete-text-input')]//input");
    By employeeName = By.xpath("//*[contains(text(),'Anthony  Nolan')]");
    By searchButton = By.xpath("//button[@type='submit']");
    By viewButton = By.xpath("//button[@name='view']");
    By addLogButton = By.xpath("//button[contains(@class,'oxd-button')]");
    By logInputBox = By.xpath("//div[contains(@class,'oxd-input-group')]//input[contains(@class,'oxd-input')]");
    By logPositiveRatingButton = By.xpath("(//button[contains(@class,'orangehrm-tracker-rating-button')])[1]");
    By logCommentInputBox = By.xpath("//textarea[contains(@class,'oxd-textarea--active')]");
    By saveLogButton = By.xpath("//button[@type='submit']");
    By logAddedVerify = By.xpath("//h6[contains(@class,'orangehrm-employee-tracker-log-title-text')]");
    By usernameDropdown = By.xpath("//p[@class='oxd-userdropdown-name']");
    By logoutUserDropdownOption = By.xpath("//a[contains(text(),'Logout')]");

    public EmployeeTrackerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToEmployeeTracker() {
        driver.findElement(performanceSideMenuItem).click();
        driver.findElement(employeeTrackerNavMenuOption).click();
    }

    public void searchEmployeeTrackerReport() {
        driver.findElement(employeeNameInputBox).sendKeys("Anthony");
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName));
        driver.findElement(employeeName).click();
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(viewButton));
        driver.findElement(viewButton).click();
    }

    public void addLogToEmployeeTrackReport() {
        driver.findElement(addLogButton).click();
        driver.findElement(logInputBox).sendKeys("Nice");
        driver.findElement(logPositiveRatingButton).click();
        driver.findElement(logCommentInputBox).sendKeys("Nice");
        driver.findElement(saveLogButton).click();
    }

    public void verifyLogIsAdded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(logAddedVerify));
        String isLogAdded = driver.findElement(logAddedVerify).getText();
        Assert.assertEquals("Nice", isLogAdded);
    }

    public void logout() {
        driver.findElement(usernameDropdown).click();
        driver.findElement(logoutUserDropdownOption).click();
    }
}