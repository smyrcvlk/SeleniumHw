package day9homework.homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignUpFormSubmissionValidation {
    /**
     * open SignUpForm.html
     * store values that you will use inside some Strings
     * fill in your data inside the all input elements using Strings above
     * submit the form
     * get URL
     * parse values that was submitted
     * validate parsed values with stored values above
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:/Users/sumeyracivelek/IdeaProjects/selenium/src/day9/homework/homework1/SignUpForm.html");
        String myText = "sumeyra";
        WebElement text = driver.findElement(By.name("text"));
        text.sendKeys(myText);
        WebElement password = driver.findElement(By.name("password"));
        String myPassword = "Pasword";
        password.sendKeys(myPassword);
        WebElement passwordrepeat = driver.findElement(By.name("password repeat"));
        passwordrepeat.sendKeys(myPassword);
        String Adress1 = "172";
        String Adrees2 = "meriline";
        String Adress3 = "ave";
        WebElement textarea = driver.findElement(By.name("textarea"));
        textarea.sendKeys(Adress1 + " " + Adrees2 + " " + Adress3);
        List<WebElement> radio = driver.findElements(By.name("radio"));
        WebElement secondElementOfRadio = radio.get(1);// [0, 1, 2].click
        secondElementOfRadio.click();
        WebElement select = driver.findElement(By.name("select"));
        Select dropdown = new Select(select);
        List<WebElement> option = dropdown.getOptions();
        for (WebElement element : option) {
            if (element.getText().equals("opt2"))
                dropdown.selectByVisibleText("opt2");
        }
        WebElement checkbox = driver.findElement(By.name("checkbox"));
        checkbox.click();
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        String url = driver.getCurrentUrl();
        String[] arrOfStr = url.split("&");
        for (int i = 0; i < arrOfStr.length; i++) {
            System.out.println(i + " " + arrOfStr[i]);
            String result = " ";
            if (arrOfStr[i].contains(myText)) {
                result = "succes";

            } else if (arrOfStr[i].contains(myPassword)) {
                result = "succes";
            } else if (arrOfStr[i].contains(Adress1)) {
                result = "succes";

            } else if (arrOfStr[i].contains(Adrees2)) {
                result = "succes";
            } else if (arrOfStr[i].contains(Adress3)) {
                result = "succes";
            } else {
                result = "fail";


            }
            System.out.println(result);
        }


    }
}