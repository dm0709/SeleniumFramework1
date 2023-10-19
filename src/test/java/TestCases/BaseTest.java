package TestCases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.QuizPage;
import pageobjects.SignUpPage;

import java.io.IOException;
import java.time.Duration;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    public ChromeDriver driver;
    public Logger log;

    HomePage  homePage;
    LoginPage loginPage;
    SignUpPage signUpPage;
    QuizPage quizPage;



    @BeforeMethod (groups = "smoke,regression", alwaysRun = true)
    public void startdrvOpenSite() throws IOException {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");//windows
        System.setProperty("webdriver.chrome.driver", "/home/orange/Documents/chromedriver");//linux
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");//linux only
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
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
//        FileHandler fileHandler = new FileHandler("C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\MyLog.log");//windows
        FileHandler fileHandler = new FileHandler("/home/orange/Documents/SeleniumFramework1/MyLog");//linux
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("Starting of log file");
    }

}
