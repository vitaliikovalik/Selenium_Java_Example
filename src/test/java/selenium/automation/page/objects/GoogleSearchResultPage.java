package selenium.automation.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GoogleSearchResultPage extends BasePage {

    public GoogleSearchResultPage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public List<WebElement> searchResultBoxes()
    {

        return driver.findElements(By.cssSelector("div.g .r > a"));
    }

    //region METHODS
    public WikipediaPage clickOnCorrespondentLink(String regex){

        WebElement correspondentLink = null;

        for (WebElement row : searchResultBoxes()) {
            if (row.getAttribute("href").matches(regex)){
                correspondentLink = row;
                break;
            }
        }

        correspondentLink.click();
        waitForPageLoadByJs();

        return new WikipediaPage(driver, wait);
    }
    //region
}
