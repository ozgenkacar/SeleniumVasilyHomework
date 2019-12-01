package com.cbt.tests.basicNavigationTest;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTest {
    /*
    1.Create class NavigationTests under tests package.
    2.Automate the provided test case using 3 different browsers.
    3.Create a separate test method for each browser.
         a.If you are using Windows, create test methods for Chrome, Firefox, Edge.
         b.If you are using Windows, create test methods for Chrome, Firefox, Safari.
    4.Each test should close the browser after completion.
    5.Test methods must use the utilities.
    6.Run all three test methods from the main method.
     */
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String title1 = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String title2= driver.getTitle();
        driver.navigate().back();
        String title3=driver.getTitle();
        StringUtility.Equals(title1,title3);
        driver.navigate().forward();
        String title4= driver.getTitle();
        StringUtility.Equals(title2,title4);

        driver.close();
    }


}


