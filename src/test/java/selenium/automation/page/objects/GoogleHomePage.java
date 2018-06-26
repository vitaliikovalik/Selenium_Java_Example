package selenium.automation.page.objects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleHomePage extends BasePage {

    public GoogleHomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String pageUrl = "https://www.google.com/";

    public WebElement searchInput(){

        return driver.findElement(By.id("lst-ib"));
    }

    //region METHODS

    public GoogleSearchResultPage doSearchByGoogle(String searchValue){

        searchInput().sendKeys(searchValue + Keys.ENTER);

        wait.until(ExpectedConditions.titleContains(searchValue));
        waitForPageLoadByJs();

        return new GoogleSearchResultPage(driver, wait);
    }

    public void navigateToGooglePage(){

        driver.navigate().to(pageUrl);
        waitForPageLoadByJs();
        Assert.assertEquals("Title check failed!", "Google", driver.getTitle());
    }
    //endregion
}
