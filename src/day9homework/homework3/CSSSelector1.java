package day9homework.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CSSSelector1 {
    /**
     * Open "https://ultimateqa.com/complicated-page/"
     * find "Skills Improved:" using css selectors and validate text
     * find "How to deal with a large page that has many elements and divisions?" using css selector and validate it
     * find "Properly structuring your page objects" using css selector and validate it
     */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ultimateqa.com/complicated-page/");
        driver.manage().window().maximize();
        System.out.println(" -------------------Skills validate------------------");
        WebElement element = driver.findElement(By.cssSelector("span#Skills_Improved"));

        if(element.getText().equals("Skills Improved:")) {
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        System.out.println("---------------------li1 validate--------------------");
        WebElement elementli1 = driver.findElement(By.cssSelector(".et_pb_text_inner ul li:first-child"));
        String li1 = "How to deal with a large page that has many elements and divisions?";
        if(elementli1.getText().equals(li1)){
            System.out.println("success");
        }else{
            System.out.println("fail");

        }
        System.out.println("---------------------li2 validate---------------------");
        WebElement elementli2 = driver.findElement(By.cssSelector(".et_pb_text_inner ul li:nth-child(2)"));
        String li2="Properly structuring your page objects";
        if(elementli2.getText().equals(li2)){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }


       //driver.quit();
    }

}