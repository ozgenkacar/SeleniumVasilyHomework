package com.cbt.tests.basicNavigationTest;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TestCase_2 {
    public static void main(String[] args) {
        /*
        Test case #2 Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Verify that number of listed examples is equals to 48.
Hint: use findElemnts() and size() methods
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");

        List <WebElement> listlink = driver.findElements(By.className("list-group-item"));
        int actualnum = listlink.size();

      if (actualnum==48) {
          System.out.println("test passed");
      }else {
          System.out.println("test failed");
      }

      driver.close();
    }
}
