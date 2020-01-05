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

import java.util.concurrent.TimeUnit;

public class CityTestCases {
    //write all the city test cases from Monday project
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

        // to select "Setup", the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(1)")).click();
        // to select "Parameters", the first child of  the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(1) > .children > :nth-child(1)")).click();
        // to select " cities ", the second child of the first child of  the first child of group items
        driver.findElement(By.cssSelector(".group-items > :nth-child(1) > .children > :nth-child(1) > .children > :nth-child(2)")).click();
    }

    @Test
    public void main() {


        // driver.findElement(By.cssSelector("[data-icon='plus']")).click();
        driver.findElement(By.xpath("//*[@class='mat-mini-fab mat-button-base mat-accent']")).click();
        WebElement nameTextbox = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input"));
        String mycity = "mycity";
        nameTextbox.sendKeys(mycity);

        driver.findElement(By.cssSelector("#mat-select-2")).click();

        driver.findElement(By.cssSelector("#mat-option-30")).click();

        WebElement saveIcon = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        saveIcon.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='City successfully created']")));

        } catch (Exception e) {
            Assert.fail("Creation failure", e);
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + mycity + "']")));
        driver.findElement(By.cssSelector("tbody > tr:first-child ms-edit-button")).click();

        WebElement editTextbox = driver.findElement(By.cssSelector("mat-dialog-container [placeholder='GENERAL.FIELD.NAME']  > input"));
        editTextbox.sendKeys("1");

        WebElement editSaveButton = driver.findElement(By.cssSelector("mat-dialog-container [data-icon=\"save\"]"));
        editSaveButton.click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='City successfully updated']")));

        } catch (Exception e) {
            Assert.fail("Update failure", e);
        }


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='" + mycity + "1" + "']")));
        driver.findElement(By.cssSelector("tbody > tr:first-child ms-delete-button")).click();

        driver.findElement(By.cssSelector("mat-dialog-container button[type=\"submit\"]")).click();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='City successfully deleted']")));

        } catch (Exception e) {
            Assert.fail("Delete failure", e);
        }
    }

    @AfterClass
    public void quit() {
        driver.quit();
    }

}


