package day9homework.homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    /**
     * Open "http://the-internet.herokuapp.com/login"
     *
     * using XPath:
     *      grab username from first <em> tag and store inside a String
     *      grab password from second <em> tag and store inside a String
     *      fill in username and password inputs with above username and password
     *      find <button> with type="submit" and click it
     *      find and verify text "Welcome to the Secure Area. When you are done click logout below."
     *      find "Log out" button and click it
     *      find and verify text "You logged out of the secure area!"
     * */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        String username= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4/em[1]")).getText();
        String password= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4/em[2]")).getText() ;
        System.out.println(username);
        System.out.println(password);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        String text="Welcome to the Secure Area. When you are done click logout below.";
        WebElement element=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h4"));

        if (text.equals(element.getText().trim())){
            System.out.println("login succes");
            driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();
            String logout="You logged out of the secure area!";
            WebElement element2=driver.findElement(By.xpath("//*[@id=\"flash\"]"));
            String logoutText = element2.getText().replace(element2.findElement(By.xpath("//*[@id=\"flash\"]/a")).getText(), "").trim();
            if (logout.equals(logoutText)){
                System.out.println("logout succes");

            }else
                System.out.println("fail");

        }else
            System.out.println("fail");

        driver.quit();
    }

}
