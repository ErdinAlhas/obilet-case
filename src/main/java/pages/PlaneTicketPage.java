package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

public class PlaneTicketPage extends BaseMethods {

    private final By whereBtn = By.id("origin-input");
    private final By destinationBtn = By.id("destination-input");
    private final By departureDateBtn = By.id("departure-input");
    private final By boxFlightCheck = By.xpath("//*[@class='check active']");
    private final By searchPlaneTicketBtn = By.id("search-button");
    private final By selectDepartureDate = By.xpath("//*[@data-date='2023-02-28']");
    private final By selectDestinationDate = By.xpath("//*[@data-date='2023-03-07']");
    private final By closePopUpButton = By.xpath("//*[@class='cookies-policy']/div/a");
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public PlaneTicketPage(WebDriver driver) {
        super(driver);
    }

    public void listTickets() {
        wait.until(ExpectedConditions.elementToBeClickable((whereBtn))).click();
        sendKeys(whereBtn, "İstanbul Anadolu");
        threadSleep(1000);
        driver.findElement(whereBtn).sendKeys(ENTER);

        wait.until(ExpectedConditions.elementToBeClickable((destinationBtn))).click();
        sendKeys(destinationBtn, "Çanakkale");
        threadSleep(1000);
        driver.findElement(destinationBtn).sendKeys(ENTER);

        driver.findElement(closePopUpButton).click();

        driver.findElement(departureDateBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable((selectDepartureDate))).click();

        driver.findElement(boxFlightCheck).click();
        threadSleep(1000);
        driver.findElement(selectDestinationDate).click();

        driver.findElement(searchPlaneTicketBtn).click();
    }

}
