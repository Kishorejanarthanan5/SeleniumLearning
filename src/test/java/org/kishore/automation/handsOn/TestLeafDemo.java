package org.kishore.automation.handsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestLeafDemo {
    @Test
    public void FormFill(){
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://leafground.com/input.xhtml");

        WebElement AboutYourSelf = driver.findElement(By.id("j_idt88:j_idt101"));
        AboutYourSelf.sendKeys("Enter the text");

        WebElement ClearText = driver.findElement(By.id("j_idt88:j_idt95"));
        ClearText.clear();



        //driver.quit();

    }
}
