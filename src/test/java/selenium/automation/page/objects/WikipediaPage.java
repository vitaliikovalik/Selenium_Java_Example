package selenium.automation.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaPage extends BasePage {

    public WikipediaPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement firstHeadingElement(){

        return driver.findElement(By.id("firstHeading"));
    }
}
