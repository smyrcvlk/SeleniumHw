package day9homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;

public class WaitForElementVisibility {
    /**
     * Open "http://the-internet.herokuapp.com/dynamic_controls"
     *
     * click on "Remove" button
     * wait for checkbox to disappear within 5 seconds
     * if checkbox disappears print success
     * verify that <p> with id="message"  is visible and has text "It's gone!"
     *
     * click on "Add" button
     * wait for checkbox to appear within 5 seconds
     * if checkbox appears print success
     * verify that <p> with id="message"  is visible and has text "It's back!"
     *
     **/

    public static void main(String[] args)  {

        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        // click on "Remove" button
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();

        // wait for checkbox to disappear within 5 seconds
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //if checkbox disappears
        try {
            wait.until( ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[type=\"checkbox\"]")));
            System.out.println("checkbox disappears is success!");
        } catch(Exception e) {
            System.out.println("checkbox disappears is Failure!");
        }

        // verify that <p> with id="message"  is visible and has text "It's gone!"
        try {
            ExpectedConditions.textToBe(By.cssSelector("#message"), "It's gone!");
            System.out.println("\"It's gone!\" message is displayed");
        } catch(Exception e) {
            System.out.println("\"It's gone!\" message is not displayed");
        }

        // click on "Add" button
        driver.findElement(By.xpath("//*[@id=\"checkbox-example\"]/button")).click();

        // wait for checkbox to appear within 5 seconds
        WebDriverWait wait2 = new WebDriverWait(driver, 5);

        //if checkbox appears
        try {
            wait2.until( ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type=\"checkbox\"]")));
            System.out.println("checkbox appears is success!");
        } catch(Exception e) {
            System.out.println("checkbox appears is Failure!");
        }

        // verify that message is visible and has text "It's back!"
        try {
            ExpectedConditions.textToBe(By.cssSelector("#message"), "It's gone!");
            System.out.println("\"It's back!\" message is displayed");
        } catch(Exception e) {
            System.out.println("\"It's back!\" message is not displayed");
        }

//        String message2= driver.findElement(By.cssSelector("#message")).getText();
//
//        if(message2.equals("It's back!")){
//            System.out.println("\"It's back!\" message is displayed");
//        } else {
//            System.out.println("\"It's back!\" message is not displayed");
//        }
    }
}