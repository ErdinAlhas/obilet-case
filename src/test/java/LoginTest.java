import org.testng.annotations.Test;
import pages.*;
import user.User;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void shouldCreateAccountSuccessfully() {

        //Given
        User user = new User();
        takeEmail(user);
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        assertEquals(driver.getCurrentUrl(), "https://www.obilet.com/");

        //When
        homePage.goToSignUpPage();
        assertEquals(driver.getCurrentUrl(), "https://www.obilet.com/?kayit");
        homePage.signUp(user.getEmail(), user.getPassword());
        SignUpPage signUpPage = new SignUpPage(driver);

        //Then
        assertTrue(signUpPage.waitUntilOpenAccountPage());
    }

    @Test
    public void shouldSelectPlaneTicketAndGoToPaymentPageSuccessfully() {

        //Given
        createAccount();
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.waitUntilOpenAccountPage();

        //When
        HomePage homePage = new HomePage(driver);
        homePage.clickPlaneTicket();
        assertEquals(driver.getCurrentUrl(), "https://www.obilet.com/ucak-bileti");

        PlaneTicketPage planeTicketPage = new PlaneTicketPage(driver);
        planeTicketPage.listTickets();
        assertTrue(driver.getCurrentUrl().contains("https://www.obilet.com/ucuslar"));

        FlightPage flightPage = new FlightPage(driver);
        flightPage.chooseFlight();
        assertTrue(driver.getCurrentUrl().contains("https://www.obilet.com/ucak-bileti/odeme"));

        PaymentPage paymentPage = new PaymentPage(driver);

        //Then
        assertTrue(driver.getCurrentUrl().contains("https://www.obilet.com/ucak-bileti/odeme"));
        assertTrue(paymentPage.getDestinationFlightCodeText().contains(flightPage.getDestinationFlightCodeText()));
        assertTrue(paymentPage.getDepartureFlightCodeText().contains(flightPage.getDepartureFlightCodeText()));
    }

}
