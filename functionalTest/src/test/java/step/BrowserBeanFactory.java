package step;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.ActionWrapper;
import helper.BrowserLibrary;
import helper.ConfigHandler;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/* this class contains the driver manipulation methods.*/
public class BrowserBeanFactory {


   public static WebDriver driver;

    @Before
    public  WebDriver getDriver() {
        BrowserLibrary b= new BrowserLibrary();
        driver = b.getbrowser();
        driver.manage().timeouts().implicitlyWait( Long.parseLong( ConfigHandler.getConfigValue("timeoutInSeconds")),TimeUnit.SECONDS);
        ActionWrapper a = new ActionWrapper(driver);
        a.waitUntilPageLoad();
        return driver;
    }

    @After
    public  void closeDown(){
        driver.quit();
    }


}
