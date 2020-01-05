package day14homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task3Solution {
    // https://www.seleniumeasy.com/test/bootstrap-alert-messages-demo.html
    // click on the "Normal success message" button then validate
    // that message is equal "I'm a normal success message. To close use the appropriate button."
    // then click on X button on the message
    // validate the the message is invisible or not present

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
    public void clickButton(){
        driver.findElement( By.id( "normal-btn-success" ) ).click();
        String text = driver.findElement( By.className( "alert-normal-success" ) ).getText();
        String buttonText = driver.findElement( By.cssSelector( ".alert-normal-success > button" ) ).getText();
        String textWithoutButton = text.replaceAll( buttonText, "" );
        String textWithoutButtonAndExtraSpace = textWithoutButton.trim();
        Assert.assertEquals( textWithoutButtonAndExtraSpace, "I'm a normal success message. To close use the appropriate button." );
    }

    @Test
    public void hideTheMessage(){
        driver.findElement( By.id( "normal-btn-success" ) ).click();

        driver.findElement( By.cssSelector( ".alert-normal-success > button" ) ).click();
        WebElement message = driver.findElement( By.className( "alert-normal-success" ) );

        Assert.assertFalse( message.isDisplayed() );
    }
}
