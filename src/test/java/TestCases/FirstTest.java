package TestCases;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void StartDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\dm070\\OneDrive\\Desktop\\TestProject1\\src\\test\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://mvnrepository.com/open-source/logging-frameworks");

    }
}
