package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By usernameInput = By.xpath("//input[@name='username']");
    By passwordInput = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//button[contains(@class,'orangehrm-login-button')]");
    By landingPageVerifyAfterLogin = By.xpath("//h6[contains(@class,'oxd-topbar-header-breadcrumb-module')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() throws IOException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(@class,'orangehrm-login-title')]")));
        FileReader reader = new FileReader("src/test/java/TestData/Data.properties");
        Properties data = new Properties();
        data.load(reader);
        String username = data.getProperty("username");
        String password = data.getProperty("password");
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void landingPageVerifyAfterLogin()
    {
        String isLandingPageCorrect = driver.findElement(landingPageVerifyAfterLogin).getText();
        Assert.assertEquals("PIM",isLandingPageCorrect);
    }
}