import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.ArrayList;
import java.util.HashMap;

public class MyTestForAllureReport extends BaseSteps {


     @Test
     @Title("Страхование")
     public void testInsurence() {
         MainSteps mainSteps = new MainSteps();
         StrahovanieSteps strahovanieSteps = new  StrahovanieSteps();
         ViborSteps viborSteps = new ViborSteps();
         SendAppSteps sendAppSteps = new SendAppSteps();

         HashMap<String, String> testData = new HashMap<>();
         testData.put("Фамилия застрахованного", "Petrov");
         testData.put("Имя застрахованного", "Petr");
         testData.put("Дата рождения застрахованного", "01.01.1988");
         testData.put("Фамилия", "Иванов");
         testData.put("Имя", "Иван");
         testData.put("Отчество", "Петрович");
         testData.put("Дата рождения", "");
         testData.put("Серия", "1900");
         testData.put("Номер", "555555");
         testData.put("Дата выдачи", "01.01.2008");
         testData.put("Кем выдан", "Там");


         mainSteps.selectElement("Застраховать себя");
         mainSteps.waitElements("Страхование путешественников");
         mainSteps.clickToElement("Страхование путешественников");

         strahovanieSteps.checkPageTitle("Страхование путешественников");
         strahovanieSteps.stepsSendButton();
         ArrayList<String> NewTab = new ArrayList<String>(driver.getWindowHandles());
         driver.switchTo().window(NewTab.get(1));

         viborSteps.stepVibor("Минимальная");

         sendAppSteps.fillFields(testData);
         sendAppSteps.checkFillFields(testData);

         sendAppSteps.clickIssue();
         sendAppSteps.checkErrorMessage("Заполнены не все обязательные поля");


     }
}
