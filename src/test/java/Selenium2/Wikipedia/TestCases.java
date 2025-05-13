package Selenium2.Wikipedia;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

//Selenium Imports
import java.util.logging.Level;
import javax.management.RuntimeErrorException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

///
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestCases {




        RemoteWebDriver driver;

        public TestCases() throws MalformedURLException {
            System.out.println("Constructor: TestCases");

            final ChromeOptions options = new ChromeOptions();
            RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), options);


            // Set browser to maximize and wait
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

        public void endTest() {
            System.out.println("\n"+"End Test: TestCases");
            driver.close();
            driver.quit();

        }

        public void testCase01() {
            System.out.println("\n"+"Start Test case: testCase01");
            driver.get("https://www.wikipedia.org");
            if(driver.getCurrentUrl().contains("wikipedia")){
                System.out.println("PASSED: testCase01");
            }else{System.out.println("Failed: testCase01");}
            System.out.println("end Test case: testCase01");

        }

        public void testCase02(){
            System.out.println("\n"+"Start Test case: testCase02");
            driver.get("https://www.wikipedia.org");
            WebElement wiki_title=driver.findElement(By.xpath("//div[@class='central-textlogo']/h1/span"));
            String title= wiki_title.getText();
            if(title.toLowerCase().contains("wikipedia")){
                System.out.println("PASSED: testCase02");
            }else{System.out.println("Failed: testCase02");}

            System.out.println("end Test case: testCase02");


        }

        public void testCase03(){
            System.out.println("\n"+"Start Test case: testCase03");
            driver.get("https://www.wikipedia.org");
            WebElement searchbox=driver.findElement(By.xpath("//input[@id='searchInput']"));
            searchbox.sendKeys("apple");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            List <WebElement> list=driver.findElements(By.xpath("//div[@class='search-input']/div/div/a"));
            for(WebElement result:list){
                if(result.getText().toLowerCase().contains("apple inc")){
                    WebElement result_path=result;
                    result_path.click();
                    break;
                }
            }
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            WebElement founder=driver.findElement(By.xpath("//a[@title='Steve Jobs']"));
            if(founder.getText().toLowerCase().contains("steve jobs")){
                System.out.println("PASSED: testCase03");
            }else{System.out.println("Failed: testCase03");}
            System.out.println("end Test case: testCase03");
        }

        public void testCase04(){
            System.out.println("\n"+"Start Test case: testCase04");
            driver.get("https://www.wikipedia.org");
            WebElement searchbox=driver.findElement(By.xpath("//input[@id='searchInput']"));
            searchbox.sendKeys("microsoft");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            List <WebElement> list=driver.findElements(By.xpath("//div[@class='search-input']/div/div/a"));
            for(WebElement result:list){
                if(result.getText().toLowerCase().contains("microsoft")){
                    WebElement result_path=result;
                    result_path.click();
                    break;
                }
            }
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            try {
                WebElement founder = driver.findElement(By.xpath("//a[text()='Bill Gates']"));
                if (founder.isEnabled()) {
                    founder.click();
                    if(driver.getCurrentUrl().toLowerCase().contains("bill_gates")) {
                        System.out.println("PASSED: testCase04");
                    } else {
                        System.out.println("FAILED: testCase04 - Incorrect URL");
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("FAILED: testCase04 - Bill Gates link not found");
            }
            System.out.println("end Test case: testCase04");

        }
    }

