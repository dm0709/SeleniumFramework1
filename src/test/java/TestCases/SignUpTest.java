package TestCases;

import org.testng.annotations.Test;

public class SignUpTest extends BaseTest{

    @Test
    public void DDmenuTest () throws InterruptedException {
        homePage.openMySite();
        homePage.openSignUP();
        signUpPage.dropDownCheck1();

    }

}
