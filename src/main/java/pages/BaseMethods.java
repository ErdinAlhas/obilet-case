package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseMethods {
    protected WebDriver driver;
    protected Actions actions;

    public BaseMethods(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void click(By byElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).click();
    }

    public void sendKeys(By byElement, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(byElement)).sendKeys(text);
    }

    public void threadSleep(int milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
