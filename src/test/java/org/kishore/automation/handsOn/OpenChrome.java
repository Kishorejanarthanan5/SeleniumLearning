package org.kishore.automation.handsOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

//import static org.assertj.core.api.Assertions.*;

public class OpenChrome {
    @Test
    public void test_url() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://oxfordadvantage.co.in/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[normalize-space()='Forgot Password?']")).click();
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.linkText(" Forgot Password?")).click();



//        System.out.println("The title is: " + driver.getTitle());
//        Assert.assertEquals(driver.getTitle(), "Facebook");
//        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[1]/div/div/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[2]/form/div/div[1]/div/div[1]/div/div/div[1]/input"));

        //AssertJ Assertions: use only when ur sure all assertions will pass, else if one fails all fails
/*        assertThat(driver.getTitle())
                .isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .isEqualTo("Facebook");*/

        driver.quit();
    }
}