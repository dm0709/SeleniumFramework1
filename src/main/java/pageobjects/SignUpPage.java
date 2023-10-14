package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class SignUpPage extends BaseMain {
    private String SignUppath = "job-title";
    public SignUpPage (ChromeDriver driver, Logger log){
        super(driver,log);
    }
    //BaseMain baseMain = new BaseMain(driver);
    BaseMain baseMain;
    public void dropDownCheck1(){
        String[] rolesOK = {"Junior level Developer", "Middle level Developer", "Senior level Developer",
                "Leading Developer", "QA Analyst", "Software Tester", "QA Engineer", "Senior QA Engineer",
                "Automation QA Engineer", "Test Lead", "Automation Test Lead", "Business Analyst",
                "Senior Business Analyst", "Designer"};
        List<String> rolesOKlist = Arrays.asList(rolesOK);
        List rolesTest = new ArrayList();
        WebElement DDmenu;
        DDmenu  = driver.findElement(By.id(SignUppath));
        Select dropMenu = new Select(DDmenu);
        List<WebElement> options2 = new ArrayList<>();
        options2 = dropMenu.getOptions();

        for (int i = 0; i < options2.size(); i++) {
            rolesTest.add(options2.get(i).getText());
         }
        if (rolesOKlist.equals(rolesTest)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
    }
    public void hardAssert1 (){
        baseMain.hardUrlCheck("register", "link is incorrect");
    }
    public void hardAssert2 () {
        List rolesTest = new ArrayList();
        WebElement DDmenu;
        DDmenu  = driver.findElement(By.id(SignUppath));
        Select dropMenu = new Select(DDmenu);
        List<WebElement> options2 = new ArrayList<>();
        options2 = dropMenu.getOptions();
        Assert.assertEquals(options2.size(),14);

    }
    public void assertAll(){
        baseMain.assertAllfunction();
    }
    public void hardAssert3 () {
        baseMain.hardTitleCheck("Sign Up");
    }
    public void softAssert1 (){
        baseMain.softUrlCheck("register", "link is incorrect");
    }
    public void softAssert2 () {
        baseMain.softTitleCheck("SignUp");
    }
    public void softAssert3 () {
        List rolesTest = new ArrayList();
        WebElement DDmenu;
        DDmenu  = driver.findElement(By.id(SignUppath));
        Select dropMenu = new Select(DDmenu);
        List<WebElement> options2 = new ArrayList<>();
        options2 = dropMenu.getOptions();
        baseMain.softListCheck1(options2.size());
        baseMain.softItemFromListCheck(options2.get(0).getText());

    }

}
