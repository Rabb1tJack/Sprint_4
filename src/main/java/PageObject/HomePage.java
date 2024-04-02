package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void chooseQuestion (int id) {
        driver.findElement(By.id("accordion__heading-" + id)).click();
        new WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("accordion__panel-" + id)));
    }
    public String getAnswer(int id) {
        return driver.findElement(By.id("accordion__panel-" + id)).getText();
    }

}