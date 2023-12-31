package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.logging.Logger;

public class LoginPage extends BaseMain{

    BaseMain baseMain;
    public LoginPage (ChromeDriver driver, Logger log){
        super(driver,log);
    }
    private String MyEmail = "qas@gmail.com";
    private String MyPass = "qwerty";

    private String mailFld = "//input[@id='email']";
    private String passFld = "//input[@id='password']";
    private String LogBtn2 = "//button[text()='Log In']";
    private String errorFld = "//div[@class='test-login-errors']/p[text()='Error: email is incorrect']";
    private String rememberChck = "//input[@type='checkbox']";

    public void fillingFldsAndLog()  {

        driver.findElement(By.xpath(mailFld)).sendKeys(MyEmail);
        driver.findElement(By.xpath(passFld)).sendKeys(MyPass);
        driver.findElement(By.xpath(LogBtn2)).click();
//        Thread.sleep(5000);
    }
    public void loginAs(String email,String pass)  {
        typeUsingXpath (mailFld,"mailField", email);
        typeUsingXpath (passFld,"passwordField", pass);
        clickUsingXpath(LogBtn2,"LogIn button");

//        Thread.sleep(5000);

    }

    public void checkIfDisplayed (){
        System.out.println(driver.findElement(By.xpath(mailFld)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(passFld)).isDisplayed());
        System.out.println(driver.findElement(By.xpath(LogBtn2)).isDisplayed());
    }

    public void checkErrorDisplyed (){
        WebDriverWait waitForError = new WebDriverWait(driver, Duration.ofSeconds(22));
        waitForError.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorFld)));
        System.out.println(driver.findElement(By.xpath(errorFld)).isDisplayed());
    }

    public void checkRemeberMe(){

        System.out.println(driver.findElement(By.xpath(rememberChck)).isSelected());
    }

    public void hardCheckRemeberMe(){

        Assert.assertFalse(driver.findElement(By.xpath(rememberChck)).isSelected());
    }



}
