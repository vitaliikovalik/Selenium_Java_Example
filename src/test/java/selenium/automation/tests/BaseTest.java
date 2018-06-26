package selenium.automation.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup () {

        String _browserType = System.getProperties().getProperty("browser", "firefox");

        //TODO: Replace to Driver factory pattern in future
        if (_browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(_browserType.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", getChromeDriverPath());
            driver = new ChromeDriver();
        }
        else {
            throw new ExceptionInInitializerError("Please set correct browser key.");
        }

        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver,15);

        //Maximize Window
        driver.manage().window().maximize();
    }

    @After
    public void teardown () {

        //close browser
        driver.quit();
    }

    private String getChromeDriverPath() {

        String platform = System.getProperties().getProperty("platform", "windows");
        String projectPath = System.getProperty("user.dir");

        if(platform.equalsIgnoreCase("ubuntu")) {
            return projectPath + "/drivers/ubuntu/chromedriver";
        }
        else if(platform.equalsIgnoreCase("windows")) {
            return projectPath + "/drivers/windows/chromedriver.exe";
        }
        else{
            throw new ExceptionInInitializerError("Please set correct platform key.");
        }
    }
}
