package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;


public class MainPage{

    Actions action;

    @FindBy(xpath = "//span[(text() = 'Застраховать себя ')]")
    public WebElement menuItems;

    @FindBy(xpath = "//div[contains(@class,'bp-area header-container')]//a[contains(text(),'Страхование путешественников')]")
    public WebElement subMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
        action = new Actions(BaseSteps.getDriver());
    }

    public void selectToElement(String name) {
        action.moveToElement(menuItems.findElement
                (By.xpath("//span[contains(@class,multiline)]/span[contains(text(),'" + name + "')]"))).build().perform();
    }

    public void clickTo(String name) {
        subMenu.click();
    }

    public void waitElement(String name){
        Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(subMenu));
    }
}
