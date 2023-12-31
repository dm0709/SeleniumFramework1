package TestCases;

import org.testng.annotations.Test;

public class End2End_Test extends BaseTest{

    @Test
    public void scenario1()  {
        log.info("Beginning 1st scenario");
        homePage.openMySite();
        homePage.openCourseGallery();
        quizPage.checkHistoryButtonFalse();
        homePage.openMySite();
        homePage.openSignIn();
        loginPage.loginAs("testing@my-fork.com","Password");
        homePage.openCourseGallery();
        quizPage.checkHistoryButtonTrue();
    }
    @Test
    public void scenario2(){
        log.info("Beginning 2nd scenario");
        homePage.openMySite();
        homePage.openCourseGallery();
        quizPage.quizTabVerification(quizPage.quizTabs());
    }
    @Test
    public void scenario3()  {
        log.info("Beginning 3rd scenario");
        homePage.openMySite();
        homePage.openCourseGallery();
        quizPage.startQuiz();

        double numOfquestions = quizPage.numberOfQuestions();
        homePage.handleTab(1);

        for (int i = 1; i <= numOfquestions ; i++) {
        quizPage.click1Answer();
        double firstAnswer = quizPage.checkingProgressValue(i,numOfquestions);
        quizPage.clickNext();
        System.out.println("pressing next, step "+i);
        double valueAfterNextPressing = quizPage.getProgressValue();
        quizPage.checkProgressAfterNextPressin(firstAnswer,valueAfterNextPressing);
        log.info("Progress Bar Verification successful!");
        }

    }


}
