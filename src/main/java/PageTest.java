import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PageTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

        DesiredCapabilities capabilites = DesiredCapabilities.firefox();
        capabilites.setCapability("marionette", true);

        WebDriver driver = new FirefoxDriver(capabilites);
        driver.manage()
                .window()
                .maximize();
        try {

            driver.navigate().to("https://www.google.com/");

            WebElement searchInputElement = driver.findElement(By.cssSelector("input[name='q']"));
            searchInputElement.sendKeys("Hello Selenium");

            WebElement searchButton = driver.findElements(By.name("btnK")).get(1);
            searchButton.click();

        }
        catch (WebDriverException e) {
            e.printStackTrace();
        }
        finally {
            driver.quit();
        }
        }
    }
