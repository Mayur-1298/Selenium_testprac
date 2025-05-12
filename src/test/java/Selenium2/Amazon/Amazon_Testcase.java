package Selenium2.Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Amazon_Testcase {
    WebDriver driver;
    @Test
    public void Testcase1(){
        driver= new ChromeDriver();

        driver.get("https://www.amazon.in/");


        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.clear();
        searchBox.sendKeys("laptop");
        searchBox.submit();
        WebElement sea = driver.findElement(By.id("nav-search-submit-button"));
       // List<WebElement> sea = driver.findElements(By.id("//div[contains(@data-asin,'B0')]"));

        sea.click();
        try {
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        WebElement productTitle = driver.findElement(By.xpath("//div[@data-cy='title-recipe']/a/h2/span[1]"));
        String text = productTitle.getText();
        if(text.toLowerCase().contains("laptop")){
            System.out.println("testCase02 Passed");
        }else{
            System.out.println("Testcase02 failed");
        }
        System.out.println("end Test case: testCase02");


    }


    public void endTest() {

        driver.close();
    }
}


