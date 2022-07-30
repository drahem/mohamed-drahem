package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;


public class testBase {

    public WebDriver driver;

    public WebDriver getDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB"); // set chrome language to be english
        return new ChromeDriver(options);
    }

    @BeforeClass
    public void initializeSelenium(){
        driver = getDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }


}
