package TestCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.QuizPage;
import pageobjects.SignUpPage;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    RemoteWebDriver driver;
    Logger log;

    HomePage  homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    QuizPage quizPage;



    @BeforeMethod (groups = "smoke,regression", alwaysRun = true)
    public void startdrvOpenSite(@Optional("souceChrome") String browser) throws IOException {
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\geckodriver.exe");
            driver = new FirefoxDriver();
        } if (browser.equalsIgnoreCase("souceChrome")){
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-dm070975-98085");
            sauceOptions.put("accessKey", "deac0251-93d2-4ed1-ac1e-51058a196d8b");
            sauceOptions.put("build", "selenium-build-FRKUN");
            sauceOptions.put("name", "first souce test");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);

        } else {
            System.out.println("Browser name not found");
        }
        
        log = Logger.getLogger(getClass().getName());
        saveLogs(log);
        homePage = new HomePage(driver,log);
        loginPage = new LoginPage(driver,log);
        signUpPage = new SignUpPage(driver,log);
        quizPage = new QuizPage(driver,log);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(groups = "smoke,regression",alwaysRun = true)
    public void drvQuit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler = new FileHandler("C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\MyLog.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("Starting of log file");
    }

}
