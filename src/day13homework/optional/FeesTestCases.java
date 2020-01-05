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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FeesTestCases {
    private WebDriver driver;
    private WebDriverWait wait;

    @Parameters({"username", "password"})
    @BeforeClass
    public void setup(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "/Users/sumeyracivelek/Selenium/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//*[@class='cc-btn cc-dismiss']")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Setup')]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Parameters')]")).click();

        driver.findElement(By.xpath("//span[contains(text(),'Fees')]")).click();
        //click on plus button
    }
    @Test
    public void main () {

        driver.findElement(By.xpath("//*[@class='mat-mini-fab mat-button-base mat-accent']")).click();

        //Type the name of the city

        List<WebElement> name = driver.findElements(By.xpath("//*[@class='mat-form-field-infix']//child::input"));
        String smsn = "smsn";
        name.get(3).sendKeys("smsn");

        List<WebElement> code = driver.findElements(By.xpath("//*[@class='mat-form-field-infix']//child::input"));
        code.get(4).sendKeys("alacam");

        List<WebElement> integrationcode = driver.findElements(By.xpath("//*[@class='mat-form-field-infix']//child::input"));
        integrationcode.get(5).sendKeys("smyr");

        List<WebElement> prioty = driver.findElements(By.xpath("//*[@class='mat-form-field-infix']//child::input"));
        prioty.get(6).sendKeys("16");

        WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        saveIcon.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Fee Type successfully created']")));

        } catch (Exception e) {
            Assert.fail( "Creation failure", e );


        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("[aria-label='Fee Type successfully created']")));
        driver.findElement(By.className("mat-paginator-navigation-next")).click();

        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("tbody > tr "), 6));

        } catch (Exception e) {
            Assert.fail( "Update failure", e );
        }

        driver.findElement(By.cssSelector("tbody > tr:last-child ms-edit-button")).click();

        WebElement editTextbox = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input"));
        editTextbox.sendKeys("1");

        WebElement editcode = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.CODE']  > input"));
        editcode.sendKeys("2");

        WebElement integrationcodeedit = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.INTEGRATION_CODE']  > input"));
        integrationcodeedit.sendKeys("3");

        WebElement priorityedit = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.PRIORITY']  > input"));
        priorityedit.sendKeys("19");

        WebElement saveIcon2 = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        saveIcon2.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Fee Type successfully updated']")));

        } catch (Exception e) {
            Assert.fail( "Update failure", e );

        }
        driver.findElement( By.cssSelector( "tbody > tr:last-child ms-delete-button" ) ).click();



        driver.findElement( By.cssSelector( "mat-dialog-container button[type=\"submit\"]" ) ).click();


        try {
            wait.until( ExpectedConditions.visibilityOfElementLocated( By.cssSelector( "[aria-label='Fee Type successfully deleted']" ) ) );

        } catch( Exception e) {
            Assert.fail( "Delete failure", e );
        }

    }
    @AfterClass
    public void quit(){
        driver.quit();
    }


}
