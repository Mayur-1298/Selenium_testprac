package Selenium2.Amazon;

import java.net.MalformedURLException;

public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        Amazon_Testcase tests = new Amazon_Testcase(); // Initialize your test class

        //TODO: call your test case functions one after other here

        tests.Testcase1();
//        tests.testCase02();
//        tests.testCase03();

        //END Tests


        tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
