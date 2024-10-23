package site.nomoreparties.stellarburgers.pages.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.EnvConfig;

public class RegistrationPage {
    WebDriver driver;

    // поля
    private final By nameInput = By.xpath("//*[@type='text' and @name='name']");
    private final By emailInput = By.xpath("//*[contains(text(), 'Email')]/following-sibling::input");
    private final By passwordInput = By.xpath("//*[@type='password' and @name='Пароль']");

    // кнопки
    private final By registerBtn = By.xpath("//*[contains(text(),'Зарегистрироваться')]");
    private final By loginBtn = By.xpath("//*[contains(text(),'Войти')]");

    // хинты
    public final By passwordHint = By.xpath("//*[contains(text(),'Некорректный пароль')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRegistrationForm(String name, String email, String password) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegisterBtn() {
        driver.findElement(registerBtn).click();
    }

    public void openRegistrationPage() {
        driver.get(EnvConfig.REGISTER_URL);
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}
