package day15homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day7hw2 {
    private WebDriver driver;
    private WebDriverWait wait;
    @BeforeClass
    public void init(){
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver" );
        driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html" );
        driver.manage().window().maximize();
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test(dataProvider = "buttonProvider")
    public void clickButton(String button){
        driver.findElement(By.id("autoclosable-btn-" +button)).click();
        wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("alert-autocloseable-success")));

        } catch (Exception e) {
            Assert.fail("failure", e );
        }
    }

    @DataProvider
    public Object[][] buttonProvider(){
        return new Object[][]{
                {"success"},
                {"info"},
                {"warning"},
                {"danger"},
        };
    }
}








