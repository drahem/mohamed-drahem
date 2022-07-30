package testCases;

import Pages.searchPage;
import Pages.searchResultPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.testBase;

public class testGoogleSearch extends testBase {

    @Test(priority = 0)
    public void testSearchBarExists(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        // check if the search bar exists in the page
        Assert.assertTrue(search.checkSearchBarExistance(), "search bar does not exist in the page");
    }

    @Test(priority = 1)
    public void testGoogleLogoExists(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        Assert.assertFalse(search.getLogoImageStatus(), "logo image is broken");
    }

    @Test(priority = 2)
    public void testAddTextInSearchBar() {
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("instabug");
        // validate the first search suggest is equal to the search data
        Assert.assertEquals(search.getFirstSuggestedSearchText(), "Instabug" , "the first suggested search is not the same as the entered text");
    }

    @Test(priority = 3)
    public void testClearTextInSearchBar(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("test search data");

        Assert.assertTrue(search.getClearSearchIconStatus());
        search.clearDataInSearchBar();
        Assert.assertFalse(search.getClearSearchIconStatus());
    }

    @Test(priority = 4)
    public void testSearchSuggestionsList() {
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("test input ");
        Assert.assertTrue(search.checkSuggestionListVisibility(), "suggestions list did not appear");
    }

    @Test(priority = 5)
    public void testSearchForInstaBug(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("instabug");
        search.clickSearchIcon();

        searchResultPage result = new searchResultPage(driver);
        // assert URL of the first result
        Assert.assertEquals(result.getFirstResultUrl(), "https://www.instabug.com", "the first search result is not instabug website");
    }

    @Test(priority = 6)
    public void testSearchWithEmptyData(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("        ");
        search.clickSearchIcon();
        Assert.assertEquals(driver.getCurrentUrl(), search.baseUrl, "empty search redirected to another page");
    }

    @DataProvider(name = "searchData")
    public Object[][] searchData(){

        return new Object[][]{
                {"%"},{"test%"},{"%test"},{"*test"},{"test*"},{"&test"},{"test&"},
                {"123"},{"!@#$"},{"fijlvnenvreoj"},{"qqqqqqqqqqqqqqqqqqqqqqqqqqqqq"},
                {"enter a very long search statments that exceed is limit of google search max length, enter a very long search statments that exceed is limit of google search max length, enter a very long search statments that exceed is limit of google search max length"},
                {"a"},{"."},{"instabug"},{"3+4"}, {"5*9"}
        };

    }

    @Test(dataProvider = "searchData", priority = 7)
    public void testResultStatusDisplayed(String data){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData(data);
        search.clickSearchIcon();

        searchResultPage result = new searchResultPage(driver);
        Assert.assertTrue(result.checkIfResultStatusExist());

    }

    @Test(priority = 8)
    public void testPaginationDisplayed(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("pagination test");
        search.clickSearchIcon();

        searchResultPage result = new searchResultPage(driver);
        Assert.assertTrue(result.checkPaginationSectionExists(), "pagination does not exist");
    }

    @Test(priority = 9)
    public void testPaginationFunctionality(){
        searchPage search = new searchPage(driver);
        search.openSearchPage();
        search.enterSearchData("pagination test");
        search.clickSearchIcon();

        searchResultPage result = new searchResultPage(driver);
        result.clickOnNextPageBtn();

        Assert.assertEquals(result.getResultStatus().substring(0,6),"Page 2", "pagination didn't work correctly");
    }



}
