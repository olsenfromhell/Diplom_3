package site.nomoreparties.stellarburgers.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.EnvConfig;
import site.nomoreparties.stellarburgers.pages.main.MainPage;


public class LoginPage extends MainPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
    }

    // поля
    protected String userEmail;
    protected String userPassword;

    // локаторы
    private final By emailInput = By.xpath("//*[contains(@name,'name')]");
    private final By passwordInput = By.xpath("//*[contains(@name,'Пароль')]");
    public final By loginBtn = By.xpath("//*[contains(text(),'Войти')]");


    public void openLoginPage() {
        driver.get(EnvConfig.LOGIN_PAGE_URL);
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    public void waitForPageLoaded() {
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    @Override
    public void clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
    }

    @Override
    public void clickOnLogo() {
        driver.findElement(logo).click();
    }

    public void fillLoginForm(String userEmail, String userPassword) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(userEmail);
        driver.findElement(passwordInput).click();
        driver.findElement(passwordInput).sendKeys(userPassword);

    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

}
