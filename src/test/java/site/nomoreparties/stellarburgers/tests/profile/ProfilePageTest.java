package site.nomoreparties.stellarburgers.tests.profile;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.EnvConfig;
import site.nomoreparties.stellarburgers.pages.login.LoginPage;
import site.nomoreparties.stellarburgers.pages.main.MainPage;
import site.nomoreparties.stellarburgers.pages.profile.ProfilePage;
import site.nomoreparties.stellarburgers.tests.DriverRule;

public class ProfilePageTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Step("Выход из аккаунта по кнопке 'Выход'")
    @Test
    public void loginWithLoginBtnTest() {
        WebDriver driver = factory.getDriver();

        ProfilePage profilePage = new ProfilePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.openLoginPage();
        loginPage.fillLoginForm(EnvConfig.email, EnvConfig.password);
        loginPage.clickLoginBtn();

        mainPage.waitForPageLoaded();
        mainPage.clickAccountBtn();
        profilePage.clickExitBtn();

        // присутствие текста данной кнопки на странице говорит о том что выход из аккаунта совершен успешно
        Assert.assertEquals("Войти", driver.findElement(loginPage.loginBtn).getText());
        // проверка урла после выхода из аккаунта
        Assert.assertEquals(driver.getCurrentUrl(), EnvConfig.LOGIN_PAGE_URL);
    }
}
