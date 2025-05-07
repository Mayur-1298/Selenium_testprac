package Selenium1;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Test2 {

    @Description("Open the URL and verify the title")
    @Test

    public void test_Selenium(){
        WebDriver driver=new EdgeDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        Assert.assertEquals(driver.getCurrentUrl(),"https://vwo.com/");
        assertThat(driver.getCurrentUrl()).isNotBlank().isNotNull().isEqualTo("https://vwo.com/");
        driver.quit();

    }
}
