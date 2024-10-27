package site.nomoreparties.stellarburgers.tests.forgotpassword;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.EnvConfig;
import site.nomoreparties.stellarburgers.pages.login.LoginPage;
import site.nomoreparties.stellarburgers.pages.main.MainPage;
import site.nomoreparties.stellarburgers.pages.forgotpassword.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.tests.DriverRule;

public class ForgotPasswordPageTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Step("Вход через кнопку 'Войти' на странице восстановления пароля")
    @Test
    public void loginWithLoginBtnOnResetPasswordPageTest() {
        WebDriver driver = factory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);
        ForgotPasswordPage resetPasswordPage = new ForgotPasswordPage(driver);

        resetPasswordPage.openForgotPasswordPage();
        resetPasswordPage.clickLoginBtn();
        loginPage.fillLoginForm(EnvConfig.email, EnvConfig.password);
        loginPage.clickLoginBtn();

        // присутствие текста данной кнопки на странице говорит о том что логин совершен успешно
        Assert.assertEquals("Оформить заказ", driver.findElement(mainPage.orderBtn).getText());
    }
}
