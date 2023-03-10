import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.TakeMail;
import user.User;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    public void createAccount() {
        User user = new User();
        takeEmail(user);
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();
        homePage.goToSignUpPage();
        homePage.signUp(user.getEmail(), user.getPassword());
    }

    public void takeEmail(User user) {
        TakeMail takeMail = new TakeMail(driver);
        user.setEmail(takeMail.takeMail());
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
