package site.nomoreparties.stellarburgers.pages.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.EnvConfig;

public class MainPage {
    WebDriver driver;

    // приватные локаторы
    private final By loginBtn = By.xpath("//*[contains(text(),'Войти в аккаунт')]");
    private final By accountBtn = By.xpath("//*[contains(text(),'Личный Кабинет')]");

    // публичные локаторы (используются где-то еще)
    public final By bunsTab = By.xpath("//*[contains(text(),'Булки')]");
    public final By saucesTab = By.xpath("//*[contains(text(),'Соусы')]");
    public final By fillingsTab = By.xpath("//*[contains(text(),'Начинки')]");
    public final By constructorBtn = By.xpath("//*[contains(text(),'Конструктор')]");
    public final By logo = By.xpath("//*[contains(@class,'logo')]");
    public final By createBurgerText = By.xpath("//*[contains(text(),'Соберите бургер')]");
    public final By orderBtn = By.xpath("//*[contains(text(),'Оформить заказ')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage() {

    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    public void waitForPageLoaded() {
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("root")));
    }

    public void clickLoginBtn() {
        WebElement element = new WebDriverWait(driver, EnvConfig.EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(loginBtn));

        element.click();
    }

    public void clickOnLogo() {
        WebElement element = new WebDriverWait(driver, EnvConfig.EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(loginBtn));

        element.click();
    }

    public void clickAccountBtn() {
        WebElement element = new WebDriverWait(driver, EnvConfig.EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(accountBtn));

        element.click();
    }

    public void clickConstructorBtn() {
        driver.findElement(constructorBtn).click();
    }

    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }


}




