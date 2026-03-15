package org.kishore.automation.Task;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Task0311_VWOSignUp {

    @Test
    public void SignUpPage() {
        WebDriver driver = new ChromeDriver();
        String parentWindow = driver.getWindowHandle();

        //Open wwo.com page
        driver.get("https://app.vwo.com/#/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        WebElement startFreeTrailButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Start a FREE TRIAL']")));
        startFreeTrailButton.click();

        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Page SignUp
        WebElement businessEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-qa='page-su-step1-v1-email']")));
        businessEmail.sendKeys("iop109@tempumail.cc");
        WebElement policy_CheckBox = driver.findElement(By.xpath("//input[@id='page-free-trial-step1-cu-gdpr-consent-checkbox']"));
        policy_CheckBox.click();
        WebElement freeTrialAcc_Btn = driver.findElement((By.xpath("//button[contains(text(),'Create a Free Trial Account')]")));
        freeTrialAcc_Btn.click();

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id= 'page-v1-fname']")));
        firstName.sendKeys("Kishore");
        WebElement lastName = driver.findElement(By.xpath("//input[@id= 'page-v1-lname']"));
        lastName.sendKeys("Janarth");
        WebElement phoneNo = driver.findElement(By.xpath("//input[@id= 'page-v1-pnumber']"));
        phoneNo.sendKeys("7995566213");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler"))).click();
        WebElement createAcc_Btn = driver.findElement(By.xpath("//button[contains(.,'Create Account')]"));
        createAcc_Btn.click();

        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(90));
        WebElement skipTrail_Btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-step='free-trial-thankyou']")));
        skipTrail_Btn.click();

        System.out.println("SignUp Completed Successfully");

        // Page SetUp
        WebElement setUp_SaveBtn = longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-qa='boxasuraza']")));
        setUp_SaveBtn.click();
        WebElement freeTrail_InsightsBtn = longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(.,'Start free trial')])[2]")));
        freeTrail_InsightsBtn.click();
        WebElement addDomain_Btn = longWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add domain')]")));
        addDomain_Btn.click();

        // Copay and verify the Text
        By copyBtn = By.xpath("//button[@vwo-title='Copy' and @data-qa='xugejexijo']");
        wait.until(ExpectedConditions.elementToBeClickable(copyBtn)).click();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));

        Actions actions = new Actions(driver);
        actions.click(searchBox)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();

        String pastedText = searchBox.getAttribute("value");
        Assert.assertTrue(pastedText.length() > 0);
    }
}
