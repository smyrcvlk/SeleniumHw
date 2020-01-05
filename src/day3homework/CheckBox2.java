package day3homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox2 {
    // https://www.seleniumeasy.com/test/basic-checkbox-demo.html
    // Check the Multiple Checkbox and check the button message
    // When you check all the checkboxes, button message will change to 'Uncheck All'
    // When you uncheck at least one checkbox, button message will change to 'Check All'
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/basic-checkbox-demo.html" );

        List<WebElement> checkboxes = driver.findElements(By.className("cb1-element"));
        for (WebElement check : checkboxes) {
            check.click();
        }

        WebElement message = driver.findElement(By.id("check1"));
        String myMessage ="Uncheck All";
//        System.out.println(myMessage);
//        System.out.println(message.getText());

        if(message.getAttribute("value").equals(myMessage)){

            System.out.println("success!");
        }else{
            System.out.println("fail");
        }

            WebElement checkbox = driver.findElement( By.id( "check1" ) );
             checkbox.click();
        WebElement message2 =driver.findElement(By.id("check1"));
        String myMessage1 ="Check All";
        if(message2.getAttribute("value").equals(myMessage1)){
            System.out.println("success!");
        }else{
            System.out.println("fail");
        }
    }
//        WebElement checkbox = driver.findElement( By.id( "check1" ) );
//        checkbox.click();
//
//        WebElement message = driver.findElement( By.id( "isChkd" ) );
//        boolean Message = true;
//
//        if(message.getText().equals( Message )){
//
//            System.out.println("Failure!");
//        } else {
//            System.out.println("Success!");
//        }
    }
//        WebElement checkbox = driver.findElement( By.id( "check1" ) );
//        checkbox.click();
//
//        WebElement message = driver.findElement( By.id( "isChkd" ) );
//        String Message = "Uncheck all";
//
//       if(message.getAttribute("check1").equals( Message )){
//
//            System.out.println("Success!");
//        } else {
//            System.out.println("Failure!");
//        }
//



