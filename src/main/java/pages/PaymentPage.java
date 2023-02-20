package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage extends BaseMethods {

    private final By destinationFlightCode = By.xpath("//*[@id='journey-contact-info']/div/table/tbody[1]/tr[2]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/strong");
    private final By departureFlightCode = By.xpath("//*[@id='journey-contact-info']/div/table/tbody[2]/tr[3]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/strong");
    private String destinationFlightCodeText = driver.findElement(destinationFlightCode).getText();
    private String departureFlightCodeText = driver.findElement(departureFlightCode).getText();
    
    public PaymentPage(WebDriver driver) {
        super(driver);
    }


    public String getDestinationFlightCodeText() {
        return destinationFlightCodeText;
    }

    public String getDepartureFlightCodeText() {
        return departureFlightCodeText;
    }

}
