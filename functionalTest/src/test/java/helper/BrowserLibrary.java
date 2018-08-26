package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/* Browser definition */
public class BrowserLibrary {
    public WebDriver getbrowser()  {
        WebDriver driver;
        String browserPath;
        switch(ConfigHandler.getConfigValue("browser")){
                case "chrome":
                browserPath =BrowserLibrary.class.getClassLoader().getResource("chromedriver").getPath();
                    System.setProperty("webdriver.chrome.driver", browserPath);

                driver = new ChromeDriver();
                break;

                case "ff":
                browserPath =BrowserLibrary.class.getClassLoader().getResource("geckodriver").getPath();
                System.setProperty("webdriver.gecko.driver", browserPath);
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("marionette", true);
                driver = new FirefoxDriver(capabilities);
                break;

                default:
                System.setProperty("webdriver.chrome.driver", ConfigHandler.getConfigValue("chromePath"));
                driver = new ChromeDriver();
                break;
        }

        return driver;
    }

}
