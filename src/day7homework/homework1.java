package day7homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class homework1 {
    // repeat Task 3 for all the buttons. Success, warning, danger and info buttons.

    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Normal success message" button then validate
    // that message is equal "I'm a normal success message. To close use the appropriate button."
    // then click on X button on the message
    // validate the the message is invisible or not present
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.get( "https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html" );
        driver.manage().window().maximize();

        System.out.println("----------------normal  button-----------------------------");
        driver.findElement( By.id( "normal-btn-success" ) ).click();
        WebElement message = driver.findElement( By.cssSelector( ".alert-normal-success" ) );
        WebElement button = driver.findElement( By.cssSelector( ".alert-normal-success > button" ) );
        String text = message.getText().replace( button.getText(), "" ).trim();
        String test = "I'm a normal success message. To close use the appropriate button.";
        System.out.println( test.equals( text ) ? "Success!" : "Failure!" );
        button.click();
        System.out.println( !message.isDisplayed() ? "Success!" : "Failure" );

        System.out.println("------------------warning button-----------------------------");

        driver.findElement( By.id( "normal-btn-warning" ) ).click();
        WebElement message2 = driver.findElement( By.cssSelector( ".alert-normal-warning" ) );
        WebElement button2 = driver.findElement( By.cssSelector( ".alert-normal-warning > button" ) );
        String text2 = message2.getText().replace( button2.getText(), "" ).trim();
        String test2 = "I'm a normal warning message. To close use the appropriate button.";
        System.out.println( test2.equals( text2 ) ? "Success!" : "Failure!" );
        button2.click();
        System.out.println( !message2.isDisplayed() ? "Success!" : "Failure" );

        System.out.println("------------------danger button-------------------------------");

        driver.findElement( By.id( "normal-btn-danger" ) ).click();
        WebElement message3 = driver.findElement( By.cssSelector( ".alert-normal-danger" ) );
        WebElement button3 = driver.findElement( By.cssSelector( ".alert-normal-danger > button" ) );
        String text3 = message3.getText().replace( button3.getText(), "" ).trim();
        String test3 = "I'm a normal danger message. To close use the appropriate button.";
        System.out.println( test3.equals( text3 ) ? "Success!" : "Failure!" );
        button3.click();
        System.out.println( !message3.isDisplayed() ? "Success!" : "Failure" );

        System.out.println("-----------------info button---------------------------------");

        driver.findElement( By.id( "normal-btn-info" ) ).click();
        WebElement message4 = driver.findElement( By.cssSelector( ".alert-normal-info" ) );
        WebElement button4 = driver.findElement( By.cssSelector( ".alert-normal-info > button" ) );
        String text4 = message4.getText().replace( button4.getText(), "" ).trim();
        String test4 = "I'm a normal info message. To close use the appropriate button.";
        System.out.println( test4.equals( text4 ) ? "Success!" : "Failure!" );
        button4.click();
        System.out.println( !message4.isDisplayed() ? "Success!" : "Failure" );

    }


}


