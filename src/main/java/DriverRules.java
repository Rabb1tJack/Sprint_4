import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverRules extends ExternalResource {

    private WebDriver driver;
    @Override
        protected void before() throws Throwable {
            startDriver();
            driver.get("https://qa-scooter.praktikum-services.ru/");
            new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.id("rcc-confirm-button"))));
            driver.findElement(By.id("rcc-confirm-button")).click();
    }
    @Override
        protected void after() {
        driver.quit();
    }
    public void startDriver(){
        if ("firefox".equals(System.getProperty("browser"))){
            startFirefox();
        }
        else {
            startChrome();
        }
}
    private void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    private void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
