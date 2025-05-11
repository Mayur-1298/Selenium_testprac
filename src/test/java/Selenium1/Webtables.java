package Selenium1;

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
public class Webtables {

    @Test
    public void checkWebtables(){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://awesomeqa.com/webtable.html");

        int row=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int coloumn=driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr/th")).size();
        //table[@id="customers"]/tbody/tr[1]/th[2]


        for(int i=2;i<=row;i++) {
            for (int j = 1; j <= coloumn; j++) {
                String firstName = "//table[@id=\"customers\"]/tbody/tr[";
                String midName = "]/td[";
                String lastName = "]";

                String Complete_xpath = firstName + i + midName + j + lastName;
                //System.out.println(Complete_xpath);
                String element_text=driver.findElement(By.xpath(Complete_xpath)).getText();

                //System.out.println(ele.getText());
                if(element_text.contains("Helen Bennett")) {
                    String required = Complete_xpath + "/preceding-sibling::td";
                    String result = driver.findElement(By.xpath(required)).getText();
                    System.out.println(result);
                }


            }
        }
        driver.quit();
    }
}
