package TestCases;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    @Test (groups = { "smoke"})
    public void DDmenuTest () throws InterruptedException {
        homePage.openMySite();
        homePage.openSignUP();
        signUpPage.dropDownCheck1();
        System.out.println("test4");
    }

    @Test
    public void hardAssertTesting() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignUP();
        signUpPage.hardAssert1();
        signUpPage.hardAssert2();
        signUpPage.hardAssert3();
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.hardCheckRemeberMe();
    }
    @Test
    public void softAssertTesting() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignUP();
        signUpPage.softAssert1();
        signUpPage.softAssert2();
        signUpPage.softAssert3();
        signUpPage.assertAll();

    }
}
