package TestCases;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class BaseTest {

    public ChromeDriver driver;
    public String MySite = "https://test.my-fork.com/";
    HomePage  homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void startdrvOpenSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        driver.get(MySite);
    }

    @AfterMethod
    public void drvQuit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}