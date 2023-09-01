package TestCases;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validateFields() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.checkIfDisplayed();
    }

    @Test
    public void fillingFieldsAndLogin() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.fillingFldsAndLog();
    }

    @Test
    public void validateError() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.fillingFldsAndLog();
        loginPage.checkErrorDisplyed();
    }

    @Test
    public void remebermeChecked() throws InterruptedException {
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.checkRemeberMe();
    }



}
