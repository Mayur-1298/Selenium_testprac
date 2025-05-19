package TestCase_Boilerplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Boilerplate {
    public WebDriver driver;
    @BeforeTest
    public void openBrowser(){
         driver=new ChromeDriver();
    }

    @AfterTest
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
