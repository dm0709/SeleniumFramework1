package TestCases;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void openSiteOnly() throws InterruptedException {
        homePage.openMySite1();
        Thread.sleep(9000);//just to check switching happened
    }
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
