package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizPage extends BaseMain{
    BaseMain baseMain = new BaseMain(driver);
    public QuizPage(ChromeDriver driver) {
        super(driver);
    }
    public By quizTopicsTab = By.xpath("//div[contains(@class,'expertise-areas-item')]");
    public By startQuizButton = By.xpath("//a[@ href='/quiz/run/10']/div");
    public By progressValue = By.xpath("//div[@id='quiz-process-progress-data']");
    public By nextButton = By.xpath("//div[@class='quiz-process-navigations-block']/div[2]");

    public By selectFirstAnswer = By.xpath("//div[@class='quiz-process-question-block-answers-block']/div[1]/div[1]");
    public By numQuestions = By.xpath("//div[@id='area-quiz-select']/div[2]/div[@class='quiz-item-bottom-block']/div[@class='quiz-item-questions-count']");
    public List<String> expected = Arrays.asList("Development", "Testing","Business Analysis","Agile","Project Management");

    private String historyButton="//a[@class='quiz-section-history-button']";
    public void checkHistoryButtonFalse (){
        Assert.assertFalse(checkHistoryProcedure());
    }
    public void checkHistoryButtonTrue (){
        Assert.assertTrue(checkHistoryProcedure());
    }
    public boolean checkHistoryProcedure(){
        try{
        driver.findElement(By.xpath(historyButton));
        return true;
    }catch(NoSuchElementException e){
            return false;
        }
    }
    public List<String> quizTabs(){

        List <String> actual = new ArrayList<>();
        List<WebElement> tabElements = driver.findElements(quizTopicsTab);
        for (WebElement element: tabElements){
            actual.add(element.getText());
        }
        return actual;

    }
    public void quizTabVerification(List<String> actual){
        Assert.assertEquals(actual,expected);
    }


    public double numberOfQuestions(){
        String num = driver.findElement(numQuestions).getText();
        double numberQuestionsInt = Integer.parseInt(num.substring(num.indexOf("/")+2));
        return numberQuestionsInt;
    }
    public void startQuiz(){
        driver.findElement(startQuizButton).click();
    }
    public void click1Answer()  {
        driver.findElement(selectFirstAnswer).click();

    }

    public double getProgressValue(){
        String value = driver.findElement(progressValue).getText();
        double seenProgressValue = Integer.parseInt(value.substring(0,value.length()-1));
        return seenProgressValue;
    }
    public double checkingProgressValue(int step, double num) {

        double seenProgressValue = getProgressValue();
        double actualProgressValue = Math.floor(step/num*100);
        Assert.assertEquals(actualProgressValue,seenProgressValue);
        System.out.println(actualProgressValue +" / " +seenProgressValue);
        return seenProgressValue;

    }
    public void clickNext(){
        driver.findElement(nextButton).click();
    }
    public void checkProgressAfterNextPressin(double a,double b){
        Assert.assertEquals(a,b);
    }


}
