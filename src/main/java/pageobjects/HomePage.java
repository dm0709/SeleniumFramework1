package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BaseMain {
    public String MySite = "https://test.my-fork.com/";
    public HomePage (ChromeDriver driver){
        super(driver);
    }

    private String LogBtn = "//div[@class='menu']/a[@class='menu-item log-in-button']";
    private String SignUpBtn = "//div[@class='menu']/a[@class='menu-item sign-in-button']";



    public void openSignIn() throws InterruptedException {
        driver.findElement(By.xpath(LogBtn)).click();
        Thread.sleep(3000);
    }
    public void openSignUP() throws InterruptedException {
        driver.findElement(By.xpath(SignUpBtn)).click();
        Thread.sleep(3000);
    }
    public void openMySite(){
        driver.get(MySite);
    }

}
