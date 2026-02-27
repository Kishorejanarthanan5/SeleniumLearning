package org.kishore.automation.ttabank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ttabank {

    @Test
    public void Signup() throws InterruptedException {

    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://tta-bank-digital-973242068062.us-west1.run.app/");


        //SignUp

        driver.findElement(By.xpath("//button[normalize-space()='Sign Up']")).click();

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Kishore");

        WebElement eMail = driver.findElement(By.xpath("//input[@type='email']"));
        eMail.sendKeys("Kishore@gmail.in");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("PassCode");

        WebElement signupBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        signupBtn.click();

        Thread.sleep(5000);

        //Transfer Funds
        WebElement fundTransBtn = driver.findElement(By.xpath("//button[normalize-space()='Transfer Funds']"));
        fundTransBtn.click();

        WebElement amountEnter = driver.findElement(By.xpath("//input[@type='number']"));
        amountEnter.sendKeys("5000");

        WebElement transContBtn = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
        transContBtn.click();
        Thread.sleep(5000);
        WebElement transConfirmBtn = driver.findElement(By.xpath("//button[normalize-space()='Confirm Transfer']"));
        transConfirmBtn.click();

        Thread.sleep(5000);

        //Dashboard
        WebElement dashBoardBtn =driver.findElement(By.xpath("//button[.//text()='Dashboard']"));
        dashBoardBtn.click();

        String updatedBalanceText = driver.findElement(By.xpath("//h3[contains(text(),'$')]")).getText();

        Assert.assertEquals(updatedBalanceText, "$45,000.00");

        Thread.sleep(5000);

        //driver.quit();

    }
}
