package org.kishore.automation.Task;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Task0302 {
    @Description("Login, Find the first Terminated Employee and click on the Delete")
    @Test
    public void test_OHRM() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://awesomeqa.com/hr/web/index.php/auth/login");

        Thread.sleep(2000);
        WebElement input_username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement input_password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement button = driver.findElement(By.xpath("//button"));

        input_username.sendKeys("admin");
        input_password.sendKeys("Hacker@4321");
        button.click();

        Thread.sleep(5000);

        WebElement deleteBtn = driver.findElement(By.xpath("(//div[text()='Terminated'])[1]/ancestor::div[contains(@class,'oxd-table-row')] //button[.//i[contains(@class,'bi-trash')]]"));
        deleteBtn.click();

        Thread.sleep(5000);
        driver.quit();
    }
}
