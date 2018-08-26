package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;


import java.util.List;



/* This class should contain generic way of handling selenium actions */
public class ActionWrapper extends BasePage {


    public  ActionWrapper(WebDriver driver){
        super(driver);
    }

    public void waitUntilPageLoad(){
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(pageLoadCondition);

    }

    public void clickWebElement(WebElement e)
    {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(e),
                ExpectedConditions.visibilityOf(e)
                )
        ) ;
        e.click();
    }

    public void waitUntilElementNotAvailable(List<WebElement> e) {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.invisibilityOfAllElements(e));
    }
    public void waitUntilElementAvailable(WebElement e) {
        WebDriverWait wait =  new WebDriverWait(driver,  Long.parseLong(ConfigHandler.getConfigValue("timeoutInSeconds")));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

}
