package WindowsAndiframe;


import TestCase_Boilerplate.Boilerplate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.interactions.Actions;

public class AdvanceWindows extends Boilerplate  {
    @Test
    public void Testcase1() throws InterruptedException{
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1&accountId=666400");
        driver.manage().window().maximize();

        String parent=driver.getWindowHandle();

        WebDriverWait  wait=new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.urlToBe("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1&accountId=666400"));
        System.out.println("Test Case passed");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-qa='yedexafobi']")));
//        Thread.sleep(15000);
        List<WebElement> list=driver.findElements(By.xpath("//div[@data-qa='yedexafobi']"));
        Actions action= new Actions(driver);

        action.moveToElement(list.get(1)).click().build().perform();

        Thread.sleep(15000);

        Set<String> handles=driver.getWindowHandles();

        for(String handle: handles){
            String text= driver.getTitle();
            System.out.println(text);
            if(!handle.equals(parent)){
                driver.switchTo().window(handle);
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickmap_option= driver.findElement(By.cssSelector("[data-qa='refoyekife']"));
                if(clickmap_option.isDisplayed()){
                    clickmap_option.click();
                }

            }
        }



    }

    @Test
    public void Testcase2() throws InterruptedException{
        driver.get("https://crio-qkart-frontend-qa.vercel.app/login");
        String parent= driver.getWindowHandle();

        String [] urlArray={"https://www.android.com/intl/en_in/", "https://www.amazon.in/ref=nav_logo",
                "https://www.google.com/", "https://www.netflix.com/in/", "https://www.redbus.in/",
                "https://in.bookmyshow.com/", "https://www.tesla.com/", "https://www.apple.com/",
                "https://www.flipkart.com/", "https://en.wikipedia.org/wiki/Main_Page"};

        JavascriptExecutor jscript= (JavascriptExecutor)driver;

        for(int i=0; i< urlArray.length;i++){
            jscript.executeScript("window.open('" + urlArray[i] + "','_blank');");
        } Thread.sleep(5000);
        Set <String> handles=driver.getWindowHandles();
        for(String handle: handles){
            driver.switchTo().window(handle);
            String text=driver.getTitle();
            System.out.println(text);
        }

        Thread.sleep(5000);

    }
}
