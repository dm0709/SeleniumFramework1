package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void StartDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("");
    }

    @Test
    public void openWebsite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
    }

    @Test
    public void SignInPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
    }

    @Test
    public void fillEmailAndPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1");
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

    }
    @Test
    public void fillEmailAndPasswordAndPressEnter() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
    }
    @Test
    public void fillEmailAndPasswordAndValidateError() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("email1@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("pass1");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//div[@aria-label='Error']")).isDisplayed());
    }
    @Test
    public void fillEmailAndPasswordAndValidateCheckBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        System.out.println(driver.findElement(By.id("cia-remember-me")).isSelected());
    }
    @Test
    public void verifyCheckBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://bestbuy.com");
        driver.findElement(By.xpath("//span[text()='Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        System.out.println(driver.findElement(By.xpath("//label[@for='cia-remember-me']")).getText());
    }
    @Test
    public void isEnabled() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG");

        driver.findElement(By.xpath("//h3[text()='Everyday Banking']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//button[text()='Cancel' and @href='javascript:void(0);']")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//button[@id='nextBtnSubTopic']")).isEnabled());

    }








}