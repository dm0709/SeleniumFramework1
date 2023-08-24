package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork4b2 {

    public ChromeDriver driver;
    public String MySite = "https://test.my-fork.com/";
    private String MyEmail = "qas@gmail.com";
    private String MyPass = "qwerty";
    private String LogBtn = "//div[@class='menu']/a[@class='menu-item log-in-button']";
    private String mailFld = "//input[@id='email']";
    private String passFld = "//input[@id='password']";
    private String LogBtn2 = "//button[text()='Log In']";
    private String errorFld = "//div[@class='test-login-errors']/p[text()='Error: email is incorrect']";
    private String rememberChck = "//input[@type='checkbox']";


    @BeforeMethod
    public void startdrvOpenSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get(MySite);
    }

    public void openSignIn(){
        driver.findElement(By.xpath(LogBtn)).click();
    }

    public void fillingFldsAndLog(){
        driver.findElement(By.xpath(mailFld)).sendKeys(MyEmail);
        driver.findElement(By.xpath(passFld)).sendKeys(MyPass);
        driver.findElement(By.xpath(LogBtn2)).click();
    }

    @Test
    public void openSite(){
    }

    @Test
    public void openSignInPage() {
        openSignIn();
    }

    @Test
    public void validateFields() throws InterruptedException {

        openSignIn();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath(mailFld)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(passFld)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(LogBtn2)).isDisplayed());
    }

    @Test
    public void fillingFieldsAndLogin() throws InterruptedException {

        openSignIn();
        Thread.sleep(1000);
        fillingFldsAndLog();
    }
    @Test
    public void validateError() throws InterruptedException {

        openSignIn();
        Thread.sleep(1000);
        fillingFldsAndLog();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath(errorFld)).isDisplayed());
    }
    @Test
    public void remebermeChecked() throws InterruptedException {

        openSignIn();
        System.out.println(driver.findElement(By.xpath(rememberChck)).isSelected());
    }

    @AfterMethod
    public void drvQuit() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }












}
