package TestCases;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void openSiteOnly() throws InterruptedException {
        homePage.openMySite1();
        System.out.println("test11");
        Thread.sleep(9000);//just to check switching happened
    }

    @Test(priority = 3, groups = { "smoke", "regression" })
    public void validateError() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.fillingFldsAndLog();
        loginPage.checkErrorDisplyed();
        System.out.println("test3");
    }

    @Test (priority = 2, groups = { "smoke"})
    public void fillingFieldsAndLogin() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.fillingFldsAndLog();
        System.out.println("test2");
    }

    @Test (priority = 1, groups = { "smoke"})
    public void validateFields() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.checkIfDisplayed();
        System.out.println("test1");
    }

    @Test (priority = 4, groups = { "regression"})
    public void remebermeChecked() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.checkRemeberMe();
        System.out.println("test5");

    }



}
