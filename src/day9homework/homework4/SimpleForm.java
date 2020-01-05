package day9homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class SimpleForm {
    /**
     * open "https://ultimateqa.com/filling-out-forms/"
     * fill in et_pb_contact_form_0 with some random data
     * click on submit button of this form
     * check that text "Form filled out successfully" is displayed
     **/
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();
        String text= "hgdfgfcjkhgjgf";
        String message="asds asd asda dadada dada ad";
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_name_0\"]")).sendKeys(text);
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_message_0\"]")).sendKeys(message);
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")).click();
            Thread.sleep(5000);
        }
        WebElement element = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[1]/p"));

        if(element.getText().equals("Form filled out successfully")){
            System.out.println("succes message is displayed");
        }else {
            System.out.println("succes message is not displayed");
        }
    }
}