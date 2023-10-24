package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;
import java.util.logging.Logger;

public class HomePage extends BaseMain {
    public String MySite = "https://test.my-fork.com/";
    public HomePage (RemoteWebDriver driver, Logger log){
        super((RemoteWebDriver) driver,log);
    }

    private String LogBtn = "//div[@class='menu']/a[@class='menu-item log-in-button']";
    private String SignUpBtn = "//div[@class='menu']/a[@class='menu-item sign-in-button']";

    By courseGalleryButton = By.xpath("//div[text()='Course Gallery']");

    BaseMain baseMain;
    public void openCourseGallery() {
        clickUsingXpath(courseGalleryButton,"Course Button");
    }

    public void openSignIn()  {
        clickUsingXpath(LogBtn,"Sign In button");

//        Thread.sleep(3000);
    }
    public void openSignUP() throws InterruptedException {
        driver.findElement(By.xpath(SignUpBtn)).click();
//        Thread.sleep(3000);
    }
    public void openMySite() {
        driver.get(MySite);
    }
    public void openMySite( String site) {
        driver.get(site);
    }

    public void openMySite1(){
        driver.get(MySite);
        driver.switchTo().newWindow(WindowType.TAB);
        handleTab(0);
        scrollPage(500);
    }
    public List<Integer> urlVerification(){
        return verifyLinkActive();
    }


}
