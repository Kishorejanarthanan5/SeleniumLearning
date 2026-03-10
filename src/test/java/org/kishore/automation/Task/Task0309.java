package org.kishore.automation.Task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task0309 {

    @Test
    public void BookingDotCom(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Booking.com search page
        driver.get("https://www.booking.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement close_modal = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@aria-label='Dismiss sign-in info.']//*[local-name()='svg']")
                )
        );
        close_modal.click();
        // Select Flights Menu
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='flights']"))).click();
        // Click destination
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Going to']"))).click();
        // Enter city
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@data-ui-name='input_text_autocomplete']")
                )
        );

        Actions actions = new Actions(driver);
        actions.click(input).sendKeys("DELHI")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//span[text()='Search']]"))).click();

        // Check Flights page loaded Successfully
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Trending']")));
        Assert.assertTrue(driver.getCurrentUrl().contains("fly-anywhere"));

        driver.quit();


    }
}
