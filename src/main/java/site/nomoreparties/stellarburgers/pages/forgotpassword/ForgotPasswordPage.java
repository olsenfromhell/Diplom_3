package site.nomoreparties.stellarburgers.pages.forgotpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.EnvConfig;

public class ForgotPasswordPage {
    WebDriver driver;

    // поля
    private final By emailInput = By.xpath("//*[contains(text(), 'Email')]/following-sibling::input");

    // кнопки
    private final By resetPasswordBtn = By.xpath("//*[contains(text(),'Восстановить')]");
    private final By loginBtn = By.xpath("//*[contains(text(),'Войти')]");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForgotPasswordForm(String name, String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickForgotPasswordBtn() {
        driver.findElement(resetPasswordBtn).click();
    }

    public void openForgotPasswordPage() {
        driver.get(EnvConfig.RESET_PASSWORD_URL);
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}
