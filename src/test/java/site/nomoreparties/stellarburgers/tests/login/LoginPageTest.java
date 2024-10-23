package site.nomoreparties.stellarburgers.tests.login;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.EnvConfig;
import site.nomoreparties.stellarburgers.pages.login.LoginPage;
import site.nomoreparties.stellarburgers.pages.main.MainPage;
import site.nomoreparties.stellarburgers.tests.DriverRule;

public class LoginPageTest {

    @Rule
    public DriverRule factory = new DriverRule();

    @Step("Переход из Личного кабинета в Конструктор")
    @Test
    public void accountBtnTransitionTest() {
        WebDriver driver = factory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.openLoginPage();
        loginPage.clickConstructorBtn();

        mainPage.waitForPageLoaded();

        // присутствие текста данной кнопки на странице говорит о том что переход совершен успешно
        Assert.assertEquals("Соберите бургер", driver.findElement(mainPage.createBurgerText).getText());
        // проверка урла после перехода
        Assert.assertEquals(driver.getCurrentUrl(), EnvConfig.BASE_URL + "/");
    }

    @Step("Переход из Личного кабинета на главную страницу по клику на лого")
    @Test
    public void logoTransitionTest() {
        WebDriver driver = factory.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        loginPage.openLoginPage();
        loginPage.clickOnLogo();

        mainPage.waitForPageLoaded();

        // присутствие текста данной кнопки на странице говорит о том что переход совершен успешно
        Assert.assertEquals("Соберите бургер", driver.findElement(mainPage.createBurgerText).getText());
        // проверка урла после перехода
        Assert.assertEquals(driver.getCurrentUrl(), EnvConfig.BASE_URL + "/");
    }

    @Step("Вход через кнопку 'Войти в аккаунт' на главной странице под существующим пользователем")
    @Test
    public void loginWithLoginBtnTest() {
        WebDriver driver = factory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.clickLoginBtn();

        loginPage.waitForPageLoaded();
        loginPage.fillLoginForm(EnvConfig.email, EnvConfig.password);
        loginPage.clickLoginBtn();

        // присутствие текста данной кнопки на странице говорит о том что логин совершен успешно
        Assert.assertEquals("Оформить заказ", driver.findElement(mainPage.orderBtn).getText());
    }
}
