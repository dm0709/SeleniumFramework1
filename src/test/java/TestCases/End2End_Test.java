package TestCases;

import org.testng.annotations.Test;

public class End2End_Test extends BaseTest{

    @Test
    public void scenario1()  {
        homePage.openMySite();
        homePage.openCourseGallery();
        quizPage.checkHistoryButtonFalse();
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.fillingFldsAndLog2();
        homePage.openCourseGallery();
        quizPage.checkHistoryButtonTrue();
    }
    @Test
    public void scenario2(){
        homePage.openMySite();
        homePage.openCourseGallery();
        quizPage.quizTabVerification(quizPage.quizTabs());
    }
    @Test
    public void scenario3()  {
        homePage.openMySite();
        homePage.openCourseGallery();
        quizPage.startQuiz();
        homePage.handleTab(1);
        quizPage.click1Answer();
        double firstAnswer = quizPage.checkingProgressValue(1);
        quizPage.clickNext();
        double valueAfterNextPressing = quizPage.getProgressValue();
        quizPage.checkProgressAfterNextPressin(firstAnswer,valueAfterNextPressing);
        quizPage.click1Answer();
        double valueAfterNextPressing2 = quizPage.getProgressValue();
        quizPage.checkProgressAfterNextPressin2(valueAfterNextPressing,valueAfterNextPressing2);
        quizPage.checkingProgressValue(2);


    }


}
