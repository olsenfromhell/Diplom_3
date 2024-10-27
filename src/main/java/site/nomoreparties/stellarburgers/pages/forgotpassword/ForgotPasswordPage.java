package site.nomoreparties.stellarburgers.pages.forgotpassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.EnvConfig;

public class ForgotPasswordPage {
    WebDriver driver;

    // кнопки
    private final By loginBtn = By.xpath("//*[contains(text(),'Войти')]");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openForgotPasswordPage() {
        driver.get(EnvConfig.RESET_PASSWORD_URL);
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    public void clickLoginBtn() {
        WebElement element = new WebDriverWait(driver, EnvConfig.EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(loginBtn));

        element.click();
    }
}
