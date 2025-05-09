package Selenium2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class miniProject2_Selenium {
    //Using explicit wait
    @Description("Verify make appointment page loads after a successfull login")
    @Test
    public void TestCase1(){

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com/#/login");

        WebElement Inputbox= driver.findElement(By.xpath("//input[@id=\"login-username\"]"));
        Inputbox.sendKeys("xyz.com");
        WebElement passwordBox= driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passwordBox.sendKeys("xyz.com");
        WebElement signIn=driver.findElement(By.xpath("//button[@id=\"js-login-btn\"]"));
        signIn.click();


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa=\"rixawilomi\"]")));

        WebElement error_message=driver.findElement(By.xpath("//div[@data-qa=\"rixawilomi\"]"));
        Assert.assertEquals(error_message.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
