package day4homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homework1 {
    // go to URL: https://www.seleniumeasy.com/test/
    // click on each link of class="board-inner"
    // and validate that class="tab-content" has
    // correct text for "h3" tag and adjacent "p" tag in active div
    // after you click associated link above

    // there should be at least 5 test of "h3" tag and adjacent "p" tag
    public static void main(String[] args) throws InterruptedException {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/" );

        List<WebElement> links = driver.findElements( By.cssSelector( ".board-inner a" ) );
        for(WebElement link : links) {
            link.click();
            Thread.sleep( 1000 );
            WebElement h3Tag = driver.findElement( By.cssSelector( ".tab-content .active h3" ) );
            String h3 = "WELCOME TO SELENIUM EASY DEMO";
            final boolean h3Validation = h3Tag.getText().equals( h3 );

            WebElement pTag = driver.findElement( By.cssSelector( ".tab-content .active h3 + p" ) );
            String p = "We have listed most of the components that are used by developers to build web applications.";
            final boolean pValidation = pTag.getText().equals( p );

            if(h3Validation && pValidation) {
                System.out.println("Success!");
            } else {
                System.out.println("Failure!");
            }
        }




//        WebElement message = driver.findElement(By.id("home"));
//        String myMessage ="Welcome to Selenium Easy";
//
//        if(!message.getCssValue("home").equals(myMessage)){
//
//            System.out.println("success!");
//        }else{
//            System.out.println("fail");
//        }
    }
}
