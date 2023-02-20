package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BaseMethods {

    public SignUpPage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    private final By myAccountBtn = By.xpath("//*[text()='Hesabım']");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public Boolean waitUntilOpenAccountPage() {
        return wait.until(ExpectedConditions.elementToBeClickable(myAccountBtn)).isDisplayed();
    }
}
