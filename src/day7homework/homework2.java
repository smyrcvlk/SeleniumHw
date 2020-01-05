package day7homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homework2 {
    // repeat Task 4 for all the buttons. Success, warning, danger and info buttons.

    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Autocloseable success message" button
    // then validate that "I'm an autocloseable success  message. I will hide in 5 seconds."
    // disappears, wait at least 10 seconds for it to disappear
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html" );
        driver.manage().window().maximize();
        System.out.println("--------------------autocloseable success message-------------------------------------");
        driver.findElement( By.id("autoclosable-btn-success") ).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until( ExpectedConditions.invisibilityOfElementLocated(By.className( "alert-autocloseable-success" )));
            System.out.println("Success!");
        } catch(Exception e) {
            System.out.println("Failure!");
        }
        System.out.println("--------------------autocloseable warning message-------------------------------------");
        driver.findElement( By.id("autoclosable-btn-warning") ).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        try {
            wait2.until( ExpectedConditions.invisibilityOfElementLocated(By.className( "alert-autocloseable-warning" )));
            System.out.println("Success!");
        } catch(Exception e) {
            System.out.println("Failure!");
        }
        System.out.println("--------------------autocloseable danger message-------------------------------------");
        driver.findElement( By.id("autoclosable-btn-danger") ).click();
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        try {
            wait3.until( ExpectedConditions.invisibilityOfElementLocated(By.className( "alert-autocloseable-danger" )));
            System.out.println("Success!");
        } catch(Exception e) {
            System.out.println("Failure!");
        }
        System.out.println("--------------------autocloseable info message-------------------------------------");
        driver.findElement( By.id("autoclosable-btn-info") ).click();
        WebDriverWait wait4 = new WebDriverWait(driver, 10);
        try {
            wait4.until( ExpectedConditions.invisibilityOfElementLocated(By.className( "alert-autocloseable-info" )));
            System.out.println("Success!");
        } catch(Exception e) {
            System.out.println("Failure!");
        }
        driver.quit();
    }
}
