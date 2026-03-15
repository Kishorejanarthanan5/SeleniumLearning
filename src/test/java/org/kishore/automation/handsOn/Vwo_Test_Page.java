package Selenium_Projects;

import Base_Class.CommonToAll;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Vwo_Test_Page extends CommonToAll {

    @Test
    public void test_app(){
        driver = new ChromeDriver();
        openBrowser(driver,"https://app.vwo.com/#/login");
        String currentWindow = driver.getWindowHandle();

        WebElement freeTrial_btn= waitForVisibility(driver, 5,By.xpath("//span[text() = 'Start a FREE TRIAL']"));
        freeTrial_btn.click();

        Set<String> getAllHandles = driver.getWindowHandles();
        for(String childWin : getAllHandles){
            if(!childWin.equals(currentWindow)){
                driver.switchTo().window(childWin);
                break;
            }
        }

        WebElement bussId = waitForVisibility(driver, 3, By.xpath("//input[@data-qa= 'page-su-step1-v1-email']"));
        bussId.sendKeys("sgh396@tempumail.cc");
        WebElement freeTrial_cb = driver.findElement(By.xpath("//input[contains(@data-qa , 'page-free-trial-step1')]"));
        freeTrial_cb.click();
        WebElement freeTrial_box = driver.findElement(By.xpath("//button[contains(text() , 'Create a Free Trial')]"));
        freeTrial_box.click();

        WebElement firstName = waitForVisibility(driver,5, By.xpath("//input[@id= 'page-v1-fname']"));
        firstName.sendKeys("Cherry");
        WebElement lastName = driver.findElement(By.xpath("//input[@id= 'page-v1-lname']"));
        lastName.sendKeys("Garg");
        WebElement phoneNo = driver.findElement(By.xpath("//input[@id= 'page-v1-pnumber']"));
        phoneNo.sendKeys("9999981111");
        WebElement createAcc = driver.findElement(By.xpath("//button[contains(text(), 'Create Account')]"));
        createAcc.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("button[data-step='free-trial-thankyou']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", btn);

        // WebElement skip_button = longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-step='free-trial-thankyou']")));
        // skip_button.click();

        System.out.println("Test exe");
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(70));
        WebElement cont_setup = longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue')]")));
        // WebElement cont_setup = longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Save')]")));
        cont_setup.click();

        WebElement start_free_trial = longWait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-qa = 'cunoxonoxe']//*[local-name() = 'svg'])[2]"))));
        start_free_trial.click();
        WebElement add_domain = longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Add domain')]")));
        add_domain.click();

        Actions actions = new Actions(driver);
        WebElement copy_code =
                longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'view-lines')]")));
        copy_code.click();
        String expected_text = copy_code.getAttribute("textContent"); // gives the full text



        driver.switchTo().newWindow(WindowType.TAB); // switching to another window dynamically

        driver.get("https://www.google.com");
        WebElement dest = driver.findElement(By.xpath("//*[@name = 'q']"));
        dest.click();

        //Now pasting
        actions.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        String paste_text = dest.getAttribute("value");
        Assert.assertEquals(paste_text, expected_text);

        System.out.println("Test exe");
        closeBrowser(driver);

    }
}