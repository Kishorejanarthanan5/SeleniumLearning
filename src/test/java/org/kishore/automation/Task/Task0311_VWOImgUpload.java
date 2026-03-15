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

public class Task0311_VWOImgUpload {
    @Test
    public void imageUpload() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open wwo.com profile page
        driver.get("https://app.vwo.com/#/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-username']")));
        userName.sendKeys("cxh04@tempumail.cc");
        WebElement passWord = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-password']")));
        passWord.sendKeys("DSDSDS#08");
        WebElement signIn_Btn = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        signIn_Btn.click();

        WebElement click_UserProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Open user menu']")));
        click_UserProfile.click();
        WebElement click_ViewProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='View Profile']")));
        click_ViewProfile.click();

        // Upload the image from System
        WebElement upload_Profile = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='file']")));
        upload_Profile.sendKeys("D:\\Pictures\\Kishore\\2025\\IMG20251002064325.jpg");

        WebElement upload_Btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Upload')]")));
        upload_Btn.click();

        WebElement preview = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Profile Picture Preview']")));

        // wait until image src loads
        String src = preview.getAttribute("src");
        Assert.assertTrue(src.contains("profile-picture"));
    }
}
