package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightPage extends BaseMethods {
    private final By chooseDestinationPlane = By.xpath("//*[@id='outbound-journeys']/li[1]");
    private final By chooseDeparturePlane = By.xpath("//*[@id='return-journeys']/li[1]");
    private final By destinationEconomyBtn = By.xpath("//*[@id='outbound-journeys']/li[1]/div[3]/ul/li/ul/li[1]/div/div/div[1]/div/span");
    private final By destinationDetailBtn = By.xpath("//*[@id='outbound-journeys']/li[1]/div/div[1]/button");
    private final By departureEconomyBtn = By.xpath("//*[@id='return-journeys']/li[1]/div[3]/ul/li/ul/li[1]/div/div/div[1]/div/span");
    private final By departureDetailBtn = By.xpath("//*[@id='return-journeys']/li[1]/div/div[1]/button");
    private final By closePopupButton = By.xpath("//*[@class='ob-modal normal pop details-modal active open']/div/button");
    private final By flightCode = By.xpath("//*[@class='flight']/ul/li[1]/div[6]/strong");
    private String destinationFlightCodeText;
    private String departureFlightCodeText;
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public FlightPage(WebDriver driver) {
        super(driver);
    }

    public void chooseFlight() {
        threadSleep(1000);
        chooseDestinationFlight();
        threadSleep(1000);
        chooseDepartureFlight();
    }

    public void chooseDestinationFlight() {
        wait.until(ExpectedConditions.elementToBeClickable((destinationDetailBtn))).click();
        threadSleep(1000);
        destinationFlightCodeText = driver.findElement(flightCode).getText();
        wait.until(ExpectedConditions.elementToBeClickable((closePopupButton))).click();
        wait.until(ExpectedConditions.elementToBeClickable((chooseDestinationPlane))).click();
        if (!driver.getCurrentUrl().contains("all?flight")) {
            wait.until(ExpectedConditions.elementToBeClickable((destinationEconomyBtn))).click();
        }
    }

    public void chooseDepartureFlight() {
        wait.until(ExpectedConditions.elementToBeClickable((departureDetailBtn))).click();
        threadSleep(1000);
        departureFlightCodeText = driver.findElement(flightCode).getText();
        wait.until(ExpectedConditions.elementToBeClickable((closePopupButton))).click();
        wait.until(ExpectedConditions.elementToBeClickable((chooseDeparturePlane))).click();
        if (driver.getCurrentUrl().contains("all?flight")) {
            wait.until(ExpectedConditions.elementToBeClickable((departureEconomyBtn))).click();
        }
    }

    public String getDestinationFlightCodeText() {
        return destinationFlightCodeText;
    }

    public String getDepartureFlightCodeText() {
        return departureFlightCodeText;
    }
}
