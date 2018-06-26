package selenium.automation.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setup () {
        //TODO: Create driver factory, to run test in any browser
        //Create a Firefox driver.
        driver = new FirefoxDriver();

        //Create a wait. All test and page classes use this wait.
        wait = new WebDriverWait(driver,15);

        //TODO: Set other driver capabilities
        //Maximize Window
        driver.manage().window().maximize();
    }

    @After
    public void teardown () {

        //close browser
        driver.quit();
    }
}
