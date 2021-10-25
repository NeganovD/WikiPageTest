import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GooglePage {
    private final WebDriver driver;
    private final WebElement searchInputElement;
    private final WebElement searchButton;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.searchInputElement = driver.findElement(By.cssSelector("input[name='q']"));
        this.searchButton = driver.findElements(By.name("btnK")).get(1);
    }

    public void setSearchText(String text) {
        this.searchInputElement.sendKeys(text);
    }

    public void clickToSearch() {
        this.searchButton.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
