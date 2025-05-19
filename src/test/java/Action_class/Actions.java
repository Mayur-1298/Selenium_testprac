package Action_class;

import TestCase_Boilerplate.Boilerplate;
import org.testng.annotations.Test;

public class Actions extends Boilerplate {

    @Test
    public void Action_classs(){


        String URL="https://google.com";
        driver.get(URL);
        driver.manage().window().maximize();
        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Hi");

    }
}
