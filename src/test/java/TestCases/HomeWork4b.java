package TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HomeWork4b {
    @Test
    public void openSite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
    }

    @Test
    public void openSignInPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='menu']/a[@class='menu-item log-in-button']")).click();
    }

    @Test
    public void validateFields() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='menu']/a[@class='menu-item log-in-button']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//button[text()='Log In']")).isDisplayed());
    }

    @Test
    public void fillingFieldsAndLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='menu']/a[@class='menu-item log-in-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("qas@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qas@gmail.com");
        driver.findElement(By.xpath("//button[text()='Log In']")).click();
    }
    @Test
    public void validateError() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='menu']/a[@class='menu-item log-in-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("qas@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qas@gmail.com");
        driver.findElement(By.xpath("//button[text()='Log In']")).click();
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//div[@class='test-login-errors']/p[text()='Error: email is incorrect']")).isDisplayed());
    }
    @Test
    public void remebermeChecked() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dm070\\OneDrive\\Desktop\\SeleniumFramework1\\target\\test-classes\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@class='menu']/a[@class='menu-item log-in-button']")).click();
        System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected());
    }













}
