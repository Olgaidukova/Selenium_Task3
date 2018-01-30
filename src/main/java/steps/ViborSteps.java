package steps;

import pages.Vibor;
import ru.yandex.qatools.allure.annotations.Step;



public class ViborSteps extends BaseSteps {
    @Step("Выбрать минимальную сумму страхования {0}")
    public void stepVibor(String menuItem){
        Vibor choice = new Vibor(driver);
        choice.selectSum(menuItem);
        choice.selectIssueButton();
    }
}