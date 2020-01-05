package day9homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpFormSubmissionParsing {
    /**
     * open SignUpForm.html
     * fill in your data inside the all input elements
     * submit the form
     * get URL
     * parse values that was submitted and print them out
     *
     *
     */
    public static void main(String[] args) {
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver" );
        WebDriver driver = new ChromeDriver();
        driver.get( "file:/Users/sumeyracivelek/IdeaProjects/selenium/src/day9/homework/homework1/SignUpForm.html");
        String myText= "text";
        WebElement text = driver.findElement( By.name(myText) );
        text.sendKeys( "sumeyra" );
        WebElement password = driver.findElement( By.name( "password" ) );

        password.sendKeys( "Password" );
        WebElement passwordrepeat = driver.findElement( By.name( "password repeat" ) );
        passwordrepeat.sendKeys( "Password" );
        WebElement textarea = driver.findElement( By.name( "textarea" ) );
        textarea.sendKeys( "172 meriline ave" );
        List<WebElement> radio = driver.findElements( By.name( "radio" ) );
        WebElement secondElementOfRadio = radio.get( 1 );// [0, 1, 2].click
        secondElementOfRadio.click();
        WebElement select = driver.findElement( By.name( "select" ) );
        Select dropdown = new Select( select );
        List<WebElement> option = dropdown.getOptions();
        for(WebElement element : option) {
            if(element.getText().equals( "opt2" ))
                dropdown.selectByVisibleText( "opt2" );
        }
        WebElement checkbox = driver.findElement( By.name( "checkbox" ) );
        checkbox.click();
        WebElement submitButton = driver.findElement( By.name( "submit" ) );

        submitButton.click();
        String url=driver.getCurrentUrl();
        String[] arrOfStr = url.split("&");
        for (String a: arrOfStr)
            System.out.println(a);

    }
}
