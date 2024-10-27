package site.nomoreparties.stellarburgers.tests.main;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.EnvConfig;
import site.nomoreparties.stellarburgers.pages.login.LoginPage;
import site.nomoreparties.stellarburgers.pages.main.MainPage;
import site.nomoreparties.stellarburgers.tests.DriverRule;


public class MainPageTest {

    @Rule
    public DriverRule factory = new DriverRule();

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

    @Step("Вход через кнопку 'Личный кабинет' на главной странице")
    @Test
    public void loginWithAccountBtnTest() {
        WebDriver driver = factory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.clickAccountBtn();
        loginPage.waitForPageLoaded();
        loginPage.fillLoginForm(EnvConfig.email, EnvConfig.password);
        loginPage.clickLoginBtn();

        // присутствие текста данной кнопки на странице говорит о том что логин совершен успешно
        Assert.assertEquals("Оформить заказ", driver.findElement(mainPage.orderBtn).getText());
    }

    @Step("Переход по клику на 'Личный кабинет'")
    @Test
    public void accountBtnTransitionTest() {
        WebDriver driver = factory.getDriver();
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.openMainPage();
        mainPage.clickAccountBtn();
        loginPage.waitForPageLoaded();

        // присутствие текста данной кнопки на странице говорит о том что переход совершен успешно
        Assert.assertEquals("Войти", driver.findElement(loginPage.loginBtn).getText());
        // проверка урла после перехода
        Assert.assertEquals(driver.getCurrentUrl(), EnvConfig.LOGIN_PAGE_URL);
    }

    @Test
    public void switchTabsTest() {
        WebDriver driver = factory.getDriver();
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();

        mainPage.clickFillingsTab();
        Assert.assertTrue("Раздел 'Начинки' не выбран", driver.findElement(mainPage.fillingsTab).isEnabled());

        mainPage.clickSaucesTab();
        Assert.assertTrue("Раздел 'Соусы' не выбран", driver.findElement(mainPage.saucesTab).isEnabled());

        mainPage.clickBunsTab();
        Assert.assertTrue("Раздел 'Булочки' не выбран", driver.findElement(mainPage.bunsTab).isEnabled());
    }
}
