package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {
    SoftAssert softAssert = new SoftAssert();
    public ChromeDriver driver;
    public Logger log;
    public BaseMain (ChromeDriver driver, Logger logger){
        this.driver = driver;
        this.log = logger;
    }
    public void handleTab(int tab){
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    public void scrollPage(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+")", "");
    }

    public void hardUrlCheck (String serviceName, String message){
        String loadedUrl = driver.getCurrentUrl();
        Assert.assertTrue(loadedUrl.contains(serviceName),message);
    }
    public void hardTitleCheck (String titleName){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,titleName);
    }
    public void assertAllfunction(){
        softAssert.assertAll();
    }
    public void softUrlCheck(String serviceName, String message){
        String loadedUrl = driver.getCurrentUrl();
        softAssert.assertTrue(loadedUrl.contains(serviceName),message);
    }
    public void softTitleCheck (String titleName){
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle,titleName);
    }
    public void softListCheck1(int qq){
        softAssert.assertEquals(qq,13);
    }
    public void softItemFromListCheck(String qq){
        softAssert.assertEquals(qq,"Junior level Develope");
    }

    public void clickUsingXpath (By xpath,String elementName){
        driver.findElement(xpath).click();
        log.info("Element: "+ elementName +" was clicked");
    }
    public void clickUsingXpath (String xpath,String elementName){
        driver.findElement(By.xpath(xpath)).click();
        log.info("Element: "+ elementName +" was clicked");
    }
    public void typeUsingXpath (String xpath,String elementName,String value){
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value: "+ value + " was entered into " + elementName + " element");
    }
    public void validateStringWithAssertEqual (List a,List b){

        log.info("verification " +a+ " and " +b);
        Assert.assertEquals(a,b);
        log.info("Verification successful!");
    }
    public String getHeaderTextUsingXpath (By xpath, String element){
        String text= driver.findElement(xpath).getText();
        log.info("Getting text from element: " +element);
        return text;
    }




}










