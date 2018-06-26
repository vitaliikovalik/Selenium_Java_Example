package selenium.automation.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void waitForPageLoadByJs() {

        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
        }
}

