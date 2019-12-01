package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        driver.get("https://google.com");
        driver.navigate().to(urls.get(0));
        String title1 = driver.getTitle();
        String actualurl1 =driver.getCurrentUrl();

        driver.navigate().back();
        driver.navigate().to(urls.get(1));
        String title2 = driver.getTitle();
        String actalurl2=driver.getCurrentUrl();

        driver.navigate().back();
        driver.navigate().to(urls.get(2));
        String title3 = driver.getTitle();
        String actualurl3=driver.getCurrentUrl();
        driver.navigate().back();
     StringUtility.Equals(title1,title2,title3);
  if (actualurl1.startsWith("http://practice.cybertekschool.com/") &&
          actalurl2.startsWith("http://practice.cybertekschool.com/") &&
              actualurl3.startsWith("http://practice.cybertekschool.com/")) {
      System.out.println("passed");
  }else {
      System.out.println("failed");
  }
driver.close();
    }
}
