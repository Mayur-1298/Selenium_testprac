package Selenium1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void Test_verifyLogin(){

        ChromeDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com");
        System.out.println(driver.getTitle());
        driver.quit();

        . }
}
