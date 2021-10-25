import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;


public class GooglePageTest {
    private final String url = "https://www.google.com/";
    private WebDriver driver;

    @BeforeClass
    public static void initProperties() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    }

    @Before
    public void initWebDriver() {
        DesiredCapabilities capabilites = DesiredCapabilities.firefox();
        capabilites.setCapability("marionette", true);

        WebDriver driver = new FirefoxDriver(capabilites);
        driver.manage()
                .window()
                .maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(3, TimeUnit.SECONDS);

        driver.navigate().to(url);
    }

    @Test
    public void test() {
        GooglePage page = new GooglePage(driver);

        page.setSearchText("hello selenium");
        page.clickToSearch();

        assertNotEquals(url, page.getCurrentUrl());
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
