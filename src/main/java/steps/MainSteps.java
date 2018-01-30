package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps extends BaseSteps{


        @Step("Выбран пункт меню {0}")
        public void selectElement(String menuItem)
        {
            new MainPage().selectToElement(menuItem);
        }


        @Step("Выбран пункт меню {0}")
        public void clickToElement(String name){
            new MainPage().clickTo(name);
        }

        @Step("Ожидание элемента {0}")
        public void waitElements(String name){
            new MainPage().waitElement(name);
        }


    }