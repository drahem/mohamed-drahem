package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchResultPage {

    WebDriver driver;
    public searchResultPage(WebDriver driver){
        this.driver = driver;
    }

    private By resultStatus = By.id("result-stats");
    private By firstResultURL = By.xpath("//*[@class='iUh30 tjvcx']");
    private By pagination = By.className("d6cvqb");
    private By paginationNext = By.id("pnnext");

    public boolean checkIfResultStatusExist(){
        boolean status = driver.findElements(resultStatus).size() > 0;
        return status;
    }

    public String getResultStatus(){
        return driver.findElement(resultStatus).getAttribute("innerHTML");
    }

    public String getFirstResultUrl(){
        return driver.findElement(firstResultURL).getAttribute("innerHTML");
    }

    public void clickOnFirstResult(){
        driver.findElement(firstResultURL).click();
    }

    public boolean checkPaginationSectionExists(){
        boolean status = driver.findElements(pagination).size() > 0;
        return status;
    }

    public void clickOnNextPageBtn(){
        driver.findElement(paginationNext).click();
    }

}
