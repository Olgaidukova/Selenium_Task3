package pages;


import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SendAppPage  {

    @FindBy(xpath = "//span[text()='Продолжить']")
    WebElement button;

    @FindBy(xpath = "//input[@name = 'insured0_surname']")
    public WebElement insuredSurName;

    @FindBy(xpath = "//input[@name = 'insured0_name']")
    public WebElement insuredName;

    @FindBy(xpath = "//input[@name = 'insured0_birthDate']")
    public WebElement insuredBirthDate;

    @FindBy(name = "surname")
    public WebElement surname;

    @FindBy(name = "name")
    public WebElement name;

    @FindBy(name = "middlename")
    public WebElement middlename;

    @FindBy(name = "birthDate")
    public WebElement birthDate;

    @FindBy(name = "female")
    public WebElement female;

    @FindBy(name = "male")
    public WebElement male;

    @FindBy(name = "passport_series")
    public WebElement passportSeries;

    @FindBy(name = "passport_number")
    public WebElement passportNumber;

    @FindBy(name = "issueDate")
    public WebElement issueDate;

    @FindBy(name = "issuePlace")
    public WebElement issuePlace;

    @FindBy(xpath = "//div[@ng-show='tryNext && myForm.$invalid']")
    public WebElement error;

    public SendAppPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного": fillElement(insuredSurName, value);
                break;
            case "Имя застрахованного": fillElement(insuredName, value);
                break;
            case "Дата рождения застрахованного": fillElement(insuredBirthDate, value);
                break;
            case "Фамилия": fillElement(surname, value);
                break;
            case "Имя": fillElement(name, value);
                break;
            case "Отчество": fillElement(middlename, value);
                break;
            case "Дата рождения": fillElement(birthDate, value);
                break;
            case "Серия": fillElement(passportSeries, value);
                break;
            case "Номер": fillElement(passportNumber, value);
                break;
            case "Дата выдачи": fillElement(issueDate, value);
                break;
            case "Кем выдан": fillElement(issuePlace, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' отсутствует на странице");
        }
    }

    public void sex(String value) {
        switch (value) {
            case "мужской":
                male.click();
                break;
            case "женский":
                female.click();
                break;
            default:
                throw new AssertionError("Поле '" + value + "' отсутствует на странице");
        }
    }

    public String getfillField(String fieldName) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                return insuredSurName.getAttribute("value");
            case "Имя застрахованного":
                return insuredName.getAttribute("value");
            case "Дата рождения застрахованного":
                return insuredBirthDate.getAttribute("value");
            case "Фамилия":
                return surname.getAttribute("value");
            case "Имя":
                return name.getAttribute("value");
            case "Отчество":
                return middlename.getAttribute("value");
            case "Дата рождения":
                return birthDate.getAttribute("value");
            case "Серия":
                return passportSeries.getAttribute("value");
            case "Номер":
                return passportNumber.getAttribute("value");
            case "Дата выдачи":
                return issueDate.getAttribute("value");
            case "Кем выдан":
                return issuePlace.getAttribute("value");
            default:
                throw new AssertionError("Поле '" + fieldName + "' отсутствует на странице");
        }
    }
    protected void fillElement(WebElement element, String value)
    {
        element.clear();
        element.sendKeys(value);
    }
    public void continueClick() {
        button.click();
    }

    public void checkError(String stringError) {
        String actualValue = error.getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидаем [%s]", actualValue, stringError),
                actualValue.contains(stringError));


    }



}
