package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {
    protected PageFactory pageFactory;
    WebDriver driver;

    public void setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/TestData/Data.properties");
        Properties data = new Properties();
        data.load(reader);
        String url = data.getProperty("url");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(url);
        pageFactory = new PageFactory(driver);
    }

    public void close_browser() {
        driver.close();
    }
}