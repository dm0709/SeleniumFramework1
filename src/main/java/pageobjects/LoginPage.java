package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BaseMain{

    public LoginPage (ChromeDriver driver){
        super(driver);
    }
    private String MyEmail = "qas@gmail.com";
    private String MyPass = "qwerty";
    private String mailFld = "//input[@id='email']";
    private String passFld = "//input[@id='password']";
    private String LogBtn2 = "//button[text()='Log In']";
    private String errorFld = "//div[@class='test-login-errors']/p[text()='Error: email is incorrect']";
    private String rememberChck = "//input[@type='checkbox']";

    public void fillingFldsAndLog() throws InterruptedException {
        driver.findElement(By.xpath(mailFld)).sendKeys(MyEmail);
        driver.findElement(By.xpath(passFld)).sendKeys(MyPass);
        driver.findElement(By.xpath(LogBtn2)).click();
        Thread.sleep(5000);
    }

    public void checkIfDisplayed (){
        System.out.println(driver.findElement(By.xpath(mailFld)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(passFld)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(LogBtn2)).isDisplayed());
    }

    public void checkErrorDisplyed (){
        System.out.println(driver.findElement(By.xpath(errorFld)).isDisplayed());
    }

    public void checkRemeberMe(){
        System.out.println(driver.findElement(By.xpath(rememberChck)).isSelected());
    }


}
