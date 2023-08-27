package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends BaseMain {

    public HomePage (ChromeDriver driver){
        super(driver);
    }

    private String LogBtn = "//div[@class='menu']/a[@class='menu-item log-in-button']";
    public void openSignIn() throws InterruptedException {
        driver.findElement(By.xpath(LogBtn)).click();
        Thread.sleep(3000);
    }


}
