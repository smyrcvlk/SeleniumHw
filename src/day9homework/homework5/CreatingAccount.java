package day9homework.homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatingAccount {
    /**
     * Part 1:
     * Open "https://courses.ultimateqa.com/users/sign_up"
     * create random and valid first name, last name, email and password, store for later validating
     * fill in account submission form with data above
     * Click on checkbox with id="user[terms]" to agree with terms and conditions
     * click on "Sign up" button
     * go to https://courses.ultimateqa.com/account
     * validate that first name, last name and email you provided earlier is correct
     * <p>
     * Part 2 (Optional)
     * sign out of the website
     * go to "https://courses.ultimateqa.com/users/sign_in"
     * fill in sign in form with your stored email and password
     * click on "Sign in" button
     * validate that message "Signed in successfully." is displayed
     **/
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://courses.ultimateqa.com/users/sign_up");
        driver.manage().window().maximize();

        WebElement firstname=driver.findElement(By.id("user[first_name]"));
        firstname.sendKeys("sumeyra");
        WebElement lastname=driver.findElement(By.id("user[last_name]"));
        lastname.sendKeys("civelek");
        WebElement email=driver.findElement(By.id("user[email]"));
        email.sendKeys("smyrcvlk@gmail.com");
        WebElement password=driver.findElement(By.xpath("//*[@id=\"user[password]\"]"));
        password.sendKeys("0000000");
        driver.findElement(By.id("user[terms]")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();




    }
}