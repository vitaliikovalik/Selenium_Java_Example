package selenium.automation.tests;

import org.junit.Assert;
import org.junit.Test;
import selenium.automation.page.objects.GoogleHomePage;
import selenium.automation.page.objects.GoogleSearchResultPage;
import selenium.automation.page.objects.WikipediaPage;

public class ExampleTest extends BaseTest {

    @Test
    public void findWikiPageTest(){

        String starFirstName = "Michael";
        String starLastName = "Jordan";
        String starFullName = starFirstName + " " +starLastName;
        String wikipediaString = " - Wikipedia";

        GoogleHomePage googlePage = new GoogleHomePage(driver, wait);

        googlePage.navigateToGooglePage();
        GoogleSearchResultPage googleSearchResult = googlePage.doSearchByGoogle(starFullName);

        //NOTE: Regex for Finding link that contain all three keys - Michael, Jordan, wikipedia
        WikipediaPage wikiPage = googleSearchResult.clickOnCorrespondentLink("^(?=.*?("+ starFirstName +"))(?=.*?("+ starLastName +"))(?=.*?(wikipedia)).*$");

        Assert.assertEquals("Title check failed!", new StringBuilder().append(starFullName).append(wikipediaString).toString(), driver.getTitle());
        Assert.assertEquals("Head of page is not correct:", starFullName, wikiPage.firstHeadingElement().getText());
    }
}
