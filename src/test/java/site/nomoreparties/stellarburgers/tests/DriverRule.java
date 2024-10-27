package site.nomoreparties.stellarburgers.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import site.nomoreparties.stellarburgers.EnvConfig;

import java.util.concurrent.TimeUnit;

/*
    Класс с настройками запуска
 */

public class DriverRule extends ExternalResource {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            startFirefox();
        } else {
            startChrome();
        }
    }

    public void startFirefox() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(EnvConfig.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }


    public void startChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(EnvConfig.IMPLICIT_WAIT, TimeUnit.SECONDS);
    }
}