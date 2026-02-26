package org.kishore.automation.handsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KatalonLogin {

    @Test
    public void CuraLogin() throws InterruptedException {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement Button_MakeAppointment = driver.findElement(By.id("btn-make-appointment"));
        Button_MakeAppointment.click();

        WebElement Username = driver.findElement(By.id("txt-username"));
        Username.sendKeys("John Doe");

        WebElement Password = driver.findElement(By.id("txt-password"));
        Password.sendKeys("ThisIsNotAPassword");

        WebElement LoginButton = driver.findElement(By.id("btn-login"));
        LoginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        String Title_MakeAppointment = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals(Title_MakeAppointment, "Make Appointment");

        driver.quit();

    }
}
