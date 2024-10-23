package site.nomoreparties.stellarburgers.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import site.nomoreparties.stellarburgers.EnvConfig;

public class ProfilePage {
    WebDriver driver;

    private final By exitBtn = By.xpath("//*[contains(text(),'Выход')]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExitBtn() {
        new WebDriverWait(driver, EnvConfig.IMPLICIT_WAIT)
                .until(ExpectedConditions.visibilityOfElementLocated(exitBtn));
        driver.findElement(exitBtn).click();
    }

}




