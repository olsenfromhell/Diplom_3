package site.nomoreparties.stellarburgers.tests.register;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.EnvConfig;
import site.nomoreparties.stellarburgers.FakerData;
import site.nomoreparties.stellarburgers.api.UserAPI;
import site.nomoreparties.stellarburgers.pages.main.MainPage;
import site.nomoreparties.stellarburgers.pages.login.LoginPage;
import site.nomoreparties.stellarburgers.pages.register.RegistrationPage;
import site.nomoreparties.stellarburgers.tests.DriverRule;

public class RegistrationPageTest {

    private String accessToken;

    @Rule
    public DriverRule factory = new DriverRule();

    @Step("Успешная регистрация пользователя")
    @Test
    public void successfulRegistrationTest() {
        WebDriver driver = factory.getDriver();

        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        UserAPI userAPI = new UserAPI();

        // создаем нового пользователя через API и получаем токен
        accessToken = userAPI.createUser(FakerData.name, FakerData.email, FakerData.password);

        // логинимся с только что созданным юзером
        loginPage.openLoginPage();
        loginPage.fillLoginForm(FakerData.email, FakerData.password);
        loginPage.clickLoginBtn();

        // присутствие текста данной кнопки на странице говорит о том что логин совершен успешно и пользователь действительно создан
        Assert.assertEquals("Оформить заказ", driver.findElement(mainPage.orderBtn).getText());

        // удаляем пользователя после теста
        userAPI.deleteUser(accessToken);
    }

    @Step("Проверка ошибки при коротком пароле")
    @Test
    public void registrationWithShortPasswordTest() {
        WebDriver driver = factory.getDriver();

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.openRegistrationPage();
        registrationPage.fillRegistrationForm(FakerData.name, FakerData.email, "123");
        registrationPage.clickRegisterBtn();

        // проверка хинта при коротком пароле
        Assert.assertEquals("Некорректный пароль", driver.findElement(registrationPage.passwordHint).getText());
    }

    @Step("Вход через кнопку 'Войти' на странице регистрации")
    @Test
    public void loginWithLoginBtnOnRegistrationPageTest() {
        WebDriver driver = factory.getDriver();

        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        MainPage mainPage = new MainPage(driver);

        registrationPage.openRegistrationPage();
        registrationPage.clickLoginBtn();
        loginPage.fillLoginForm(EnvConfig.email, EnvConfig.password);
        loginPage.clickLoginBtn();

        // присутствие текста данной кнопки на странице говорит о том что логин совершен успешно
        Assert.assertEquals("Оформить заказ", driver.findElement(mainPage.orderBtn).getText());
    }
}
