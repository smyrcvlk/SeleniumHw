package day9homework.homework4;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class WaitForElementVisibilityWithError {
    /**
     * Open "http://the-internet.herokuapp.com/dynamic_controls"
     *
     * click on "Remove" button
     * wait for checkbox to disappear within 2 seconds
     * if checkbox does not disappear print failure
     * if test fails take a screenshot and store inside homework4 folder
     *
     **/
    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-example > input[type=text]:not([disabled])")));
            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Failure!");

        }
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile //method
            FileUtils.copyFile(src, new File("src/day9/homework/homework4/error_screenshot2.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}

