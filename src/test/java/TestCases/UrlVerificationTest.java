package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class UrlVerificationTest extends BaseTest{


    public void urlVerification(String site){
        homePage.openMySite(site);
        List<Integer> codes = homePage.urlVerification();
        SoftAssert softAssert = new SoftAssert();
        Integer expected = 200;
        for (Integer code: codes) {
            softAssert.assertEquals(code, expected);
        }
        softAssert.assertAll();
    }
    @Test
    public void urlVerification_1(){
        urlVerification("https://www.mymealorder.com/");
    }
    @Test
    public void urlVerification_2(){
        urlVerification("https://getipass.com/");
    }
    @Test
    public void urlVerification_3(){
        urlVerification("https://www.blogger.com/");
    }
}
