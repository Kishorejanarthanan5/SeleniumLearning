package org.kishore.automation.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task0304 {

    @Test
    public void vwologinpage()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-username")));
        email.sendKeys("admin@admin.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-password")));
        password.sendKeys("admin");

        WebElement signinbtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#js-login-btn")));
        signinbtn.click();

        WebElement errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#js-notification-box-msg")));
        String actualText = errormsg.getText();

        String expectedText = "Your email, password, IP address or location did not match";
        Assert.assertEquals(actualText, expectedText);

        driver.quit();


    }
}
