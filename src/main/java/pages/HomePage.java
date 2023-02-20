package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseMethods {
    Actions actions;

    private final String homePageUrl = "https://www.obilet.com/";
    private final By loginButtonBy = By.className("login");
    private final By signUpButtonBy = By.xpath("//*[@class='sign-up login-to-register']");

    private final By mailField = By.xpath("//*[@placeholder='E-posta Adresi']");
    private final By passwordField = By.xpath("//*[@placeholder='Parola']");
    private final By signUpBtn = By.xpath("//*[@class='register register-button']");

    private final By planeBtn = By.xpath("//*[@class='menu left']/li[@class='']");

    WebDriverWait wait = new WebDriverWait(driver, 10);

    public HomePage(WebDriver driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public void goToHomePage() {
        driver.get(homePageUrl);
    }

    public void goToSignUpPage() {
        click(loginButtonBy, 5);
        click(signUpButtonBy, 5);
    }

    public void signUp(String mail, String password) {
        threadSleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable((mailField))).sendKeys(mail);
        wait.until(ExpectedConditions.attributeToBe(mailField, "value", mail));
        wait.until(ExpectedConditions.elementToBeClickable((passwordField))).sendKeys(password);
        wait.until(ExpectedConditions.attributeToBe(passwordField, "value", password));
        click(signUpBtn, 5);
    }

    public void clickPlaneTicket() {
        click(planeBtn, 3);

    }

}