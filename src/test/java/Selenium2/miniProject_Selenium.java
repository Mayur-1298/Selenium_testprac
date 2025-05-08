package Selenium2;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class miniProject_Selenium {

    @Description("Verify with invalid email, pass, error message is shown on screen")
    @Test

    public void TestCase1() throws Exception{
        EdgeOptions edgeoption=new EdgeOptions();
        edgeoption.addArguments("--start-maximized");
        WebDriver driver=new EdgeDriver(edgeoption);
        driver.get("https://app.vwo.com/");

        WebElement loginBox=driver.findElement(By.id("login-username"));
        WebElement passBox=driver.findElement(By.name("password"));
        WebElement button=driver.findElement(By.id("js-login-btn"));
        loginBox.sendKeys("admin@admin.com");
        passBox.sendKeys("admin");
        Thread.sleep(3000);
        button.click();
        Thread.sleep(3000);
        WebElement invalidError= driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(invalidError.getText(),"Your email, password, IP address or location did not match");

        driver.quit();


    }
    //By Locators
    @Description("Verify make appointment page loads after a successfull login")
    @Test
    public void TestCase2() throws Exception{
        EdgeOptions edgeoption=new EdgeOptions();
        edgeoption.addArguments("--start-maximized");
        WebDriver driver=new EdgeDriver(edgeoption);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppbtn= driver.findElement(By.id("btn-make-appointment"));
        makeAppbtn.click();
        Thread.sleep(1500);
        WebElement loginBox=driver.findElement(By.name("username"));
        loginBox.sendKeys("John Doe");
        WebElement passwordBox=driver.findElement(By.id("txt-password"));
        passwordBox.sendKeys("ThisIsNotAPassword");
        WebElement loginBtn=driver.findElement(By.id("btn-login"));
        loginBtn.click();
        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        driver.quit();


    }

    //By Xpath locators
    @Description("Verify make appointment page loads after a successfull login with Xpath")
    @Test
    public void TestCase3() throws Exception{
        EdgeOptions edgeoption=new EdgeOptions();
        edgeoption.addArguments("--start-maximized");
        WebDriver driver=new EdgeDriver(edgeoption);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppbtn= driver.findElement(By.xpath("//a[@id=\"btn-make-appointment\"]"));
        makeAppbtn.click();
        Thread.sleep(1500);
        WebElement loginBox=driver.findElement(By.xpath("//input[@id='txt-username']"));
        loginBox.sendKeys("John Doe");
        WebElement passwordBox=driver.findElement(By.xpath("//input[@id='txt-password']"));
        passwordBox.sendKeys("ThisIsNotAPassword");
        WebElement loginBtn=driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginBtn.click();

        Thread.sleep(3000);
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        driver.quit();


    }
}
