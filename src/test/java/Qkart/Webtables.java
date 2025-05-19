package Qkart;

import TestCase_Boilerplate.Boilerplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Webtables extends Boilerplate {

    @Test
    public void checkWebtables(){
        driver.get("https://crio-qkart-qa.vercel.app/");
        //driver.manage().window().maximize();
        boolean status=false;
        WebElement searchBox= driver.findElement(By.name("search"));
        searchBox.sendKeys("shoes");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> searchResults=driver.findElements(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container MuiGrid-spacing')]//p[contains(@class,'MuiTypography-root MuiTypography-body1 css-yg')] "));

        for(WebElement result:searchResults) {
            String outpt = result.getText();
            if (outpt.toLowerCase().contains("shoes")) {
                WebElement sizeChart = driver.findElement(By.xpath("//button[text()='Size chart']"));
                status=sizeChart.isEnabled();
                sizeChart.click();
                break;
            }
        }if(status) {
            List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
            List<WebElement> cols = driver.findElements(By.xpath("//table/thead/tr/th"));

            int webRow = rows.size();
            int webColumn = cols.size();
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            for (int i = 0; i < webRow; i++) {
                for (int j = 0; j < webColumn; j++) {
                    int row = i + 1, col = j + 1;
                    WebElement body = driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[" + col + "]"));
                    System.out.println(body.getText());
                }
            }
        }

    }
}
