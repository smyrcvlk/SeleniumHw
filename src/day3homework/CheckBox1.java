package day3homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox1 {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Single Checkbox and check the message bellow it
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );

            WebElement checkbox = driver.findElement( By.id( "isAgeSelected" ) );
            checkbox.click();

            WebElement message = driver.findElement( By.id( "txtAge" ) );
            String myMessage = "Success - Check box is checked";

            if(message.getText().equals( myMessage )){
                System.out.println("Success!");
            } else {
                System.out.println("Failure!");
            }
        }
    }

