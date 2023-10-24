package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {
    SoftAssert softAssert = new SoftAssert();
    public RemoteWebDriver driver;
    public Logger log;
    public BaseMain (RemoteWebDriver driver, Logger logger){
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

    public List<Integer> verifyLinkActive(){

        List<WebElement> linkElements = driver.findElements(By.xpath("//a")); //collect all links from page
        List<String> collectedURLs = new ArrayList<>(); //this List will have actual URLs
        List<Integer> codes = new ArrayList<>(); //this List will have codes that each URL will return
        int resultCode; //initialize variable for a resulting code value and providing default value

        for (WebElement linkElement: linkElements){ //this loop takes each element from LinkElements and takes href attribute (since each item is a link it will have it)
            collectedURLs.add(linkElement.getAttribute("href"));
        }


        for(String collectedURL: collectedURLs) { // this loop will execute actions below to fill up codes List with actual values
            System.out.println("Starting verification of " + collectedURL);
            try { //making sure that exception won't fail the execution to carry execution on
                URL url = new URL(collectedURL); //initializes URL instance for provided URL
                HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection(); //initialize HTTP Connection
                httpURLConnect.setConnectTimeout(3000); //set timeout value
                httpURLConnect.connect(); //establish connection to provided URL to execute a call
                resultCode = httpURLConnect.getResponseCode(); //providing actual value into a value of a variable to be returned
                System.out.println(resultCode);
                codes.add(resultCode); //writing the result in resultCode array to return it
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return codes; //a return of a list with codes for further verification
    }



}










