package Pages;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

public class searchPage {

    WebDriver driver;
    public String baseUrl = "https://www.google.com/";

    // page locators
    private By searchBar = By.name("q");
    private By clearSearchBarIcon = By.className("ExCKkf");
    private By suggestionList = By.className("erkvQe");
    private By firstSuggestedSearch = By.xpath("//*[@class='wM6W7d']/span[1]");
    private By googleLogo = By.className("lnXdpd");


    public boolean getLogoImageStatus(){
        // check if the logo has a broken or valid image
        if (driver.findElement(googleLogo).getAttribute("naturalWidth").equals(0))
        {
            return true;
        }
        else {
            return false;
        }
    }

    public searchPage(WebDriver driver){
        this.driver = driver;
    }

    public void openSearchPage(){
        driver.get(baseUrl);
    }

    public boolean checkSearchBarExistance(){
        boolean status = driver.findElements(searchBar).size() > 0;
        return status;
    }

    public void enterSearchData(String searchData){
        driver.findElement(searchBar).sendKeys(searchData);
    }

    public void clickSearchIcon(){
        /*
         google does not have a clickable search icon in search page
         so, this action will be done by clicking enter
         */
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }

    public boolean getClearSearchIconStatus(){
        By clearIcon = By.xpath("//div[@class='vOY7J']");
        boolean status = driver.findElements(clearIcon).size() <= 0;
        return status;
    }

    public void clearDataInSearchBar(){
        driver.findElement(clearSearchBarIcon).click();
    }

    public String getFirstSuggestedSearchText(){
        // explicit wait till elements loads
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        w.until(ExpectedConditions.visibilityOfElementLocated(firstSuggestedSearch));
        // get text of element and print
        return driver.findElement(firstSuggestedSearch).getAttribute("innerHTML");
    }

    public boolean checkSuggestionListVisibility(){
        // this action speed depends on the network speed, that's why a wait is required here
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOfElementLocated(suggestionList));
        return driver.findElement(suggestionList).isDisplayed();
    }
}
