package day13homework.optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class hwnationality {
    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"username", "password"})
    @BeforeClass
    public void setup(String username, String password){
        System.setProperty( "webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver" );
        driver = new ChromeDriver();
        driver.get( "https://test-basqar.mersys.io" );
        driver.manage().window().maximize();
        driver.findElement( By.cssSelector( "[formcontrolname=\"username\"]" ) ).sendKeys( username );
        driver.findElement( By.cssSelector( "[formcontrolname=\"password\"]" ) ).sendKeys( password );
        driver.findElement( By.cssSelector( "button[aria-label=\"LOGIN\"]" ) ).click();

        wait = new WebDriverWait( driver, 5 );
        driver.manage().timeouts().implicitlyWait( 3, TimeUnit.SECONDS );

        driver.findElement( By.cssSelector( "fuse-navigation .group-items > .nav-item:nth-child(1)" ) ).click();
        driver.findElement( By.cssSelector( "fuse-navigation .group-items > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1)" ) ).click();
        driver.findElement( By.cssSelector( "fuse-navigation .group-items > .nav-item:nth-child(1) > .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(4)" ) ).click();

    }

    @Test
    public void main() {

        String nationality = generateRandomNameOfLength(7, 10);
        driver.findElement( By.cssSelector( "ms-add-button[tooltip=\"NATIONALITIES.TITLE.ADD\"]" ) ).click();
        driver.findElement( By.cssSelector( "mat-dialog-container ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) ).sendKeys( nationality );
        driver.findElement( By.cssSelector( "mat-dialog-actions button.save-button" ) ).click();

        try {
            wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector("div[aria-label=\"Nationality successfully created\"]") ) );
        } catch (Exception e){
            Assert.fail( "Creation failure", e );
        }

        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath("//td[contains(@class,'name') and text()='"+nationality+"']") ) );

        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-edit-button" ) ).click();
        String updatedNationality = nationality + "1";
        driver.findElement( By.cssSelector( "mat-dialog-container ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) ).clear();
        driver.findElement( By.cssSelector( "mat-dialog-container ms-text-field[placeholder=\"GENERAL.FIELD.NAME\"] > input" ) ).sendKeys( updatedNationality );
        driver.findElement( By.cssSelector( "mat-dialog-actions button.save-button" ) ).click();
        try {
            wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector("div[aria-label=\"Nationality successfully updated\"]") ) );
        } catch (Exception e){
            Assert.fail( "Update failure", e );
        }

        wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath("//td[contains(@class,'name') and text()='"+updatedNationality+"']") ) );

        driver.findElement( By.cssSelector( "tbody > tr:first-child ms-delete-button" ) ).click();
        driver.findElement( By.cssSelector( "mat-dialog-actions button.mat-accent" ) ).click();

        try {
            wait.until( ExpectedConditions.presenceOfElementLocated( By.cssSelector("div[aria-label=\"Nationality successfully deleted\"]") ) );
        } catch (Exception e){
            Assert.fail( "Delete failure", e );
        }
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }

    public static String generateRandomNameOfLength(int from, int to) {
        String candidateCapitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String candidateChars = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < from + random.nextInt( to ); i++) {
            if(i == 0) {
                sb.append( candidateCapitalChars.charAt( random.nextInt( candidateCapitalChars
                        .length() ) ) );
            } else {
                sb.append( candidateChars.charAt( random.nextInt( candidateChars
                        .length() ) ) );
            }
        }
        return sb.toString();
    }
}

