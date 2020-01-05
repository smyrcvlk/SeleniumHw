package day14homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task4Solution {
    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Autocloseable success message" button
    // then validate that "I'm an autocloseable success  message. I will hide in 5 seconds."
    // disappears, wait at least 10 seconds for it to disappear

    WebDriver driver;
    @BeforeClass
     public void clickwebsite() {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html");
     }
    @AfterClass
    public void quit() {
        driver.quit();
    }

    @Test
    public void test(){
        driver.findElement( By.id( "autoclosable-btn-success" ) ).click();
        WebDriverWait wait = new WebDriverWait( driver, 4 );
        try {
            wait.until( ExpectedConditions.invisibilityOfElementLocated( By.className( "alert-autocloseable-success" ) ) );
        } catch(Exception e) {
            Assert.fail( "The element did not disappear in 4 seconds", e );
        }

    }
}
