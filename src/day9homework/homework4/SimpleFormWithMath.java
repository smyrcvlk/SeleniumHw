package day9homework.homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SimpleFormWithMath {
    /**
     * open "https://ultimateqa.com/filling-out-forms/"
     * fill in et_pb_contact_form_1 with some random data
     * solve math problem in et_pb_contact_captcha_question
     * and fill the answer in et_pb_contact_captcha_1
     * click on submit button of this form
     * check that text "Success" is displayed
     **/

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();

        String text = "Michel";
        String message = "This is the message.";


        for (int i = 0; i < 3; i++) {
            // inputs
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_name_1\"]")).sendKeys(text);

            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_message_1\"]")).sendKeys(message);

            // capta
            String inputPath = "//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/div/p/input";
            int first = Integer.parseInt(driver.findElement(By.xpath(inputPath)).getAttribute("data-first_digit"));
            int second = Integer.parseInt(driver.findElement(By.xpath(inputPath)).getAttribute("data-second_digit"));
            driver.findElement(By.xpath(inputPath)).sendKeys(Integer.toString(first + second));

            // submit button
            driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/button")).click();

       }
        // validate
        String formText = driver.findElement(By.xpath("//*[@id=\"et_pb_contact_form_1\"]/div[1]/p")).getText();

        if(formText.equals("Success")){
            System.out.println("succes message is displayed");
        }else {
            System.out.println("succes message is not displayed");
        }
    }
}
