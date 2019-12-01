package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestCase_1 {
    /*
    Test case #1 Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Sign Up For Mailing List”
Step 3. Enter any valid name
Step 4. Enter any valid email
Step 5. Click on “Sign Up” button
Expected result: Following message should be displayed: “Thank you for signing up.
 Click the button below to return to the home page.” Home button should be displayed.

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
      WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
      driver.get("http://practice.cybertekschool.com/");

        WebElement link = driver.findElement(By.linkText("Sign Up For Mailing List"));
        UtilWait.wait(3);
        link.click();

        WebElement fullname =driver.findElement(By.name("full_name"));
          fullname.sendKeys("ozgen kacar");
        UtilWait.wait(2);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("oz@email.com");
        UtilWait.wait(2);

        WebElement button = driver.findElement(By.name("wooden_spoon"));
        button.click();

        WebElement message =driver.findElement(By.tagName("h3"));
        String actualmessage =message.getText();
        String expectedmessage = "Thank you for signing up. Click the button below to return to the home page.";
        UtilWait.wait(2);



        WebElement button2 = driver.findElement(By.id("wooden_spoon"));
        button2.click();

        UtilWait.wait(2);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl ="http://practice.cybertekschool.com/";

        if ( expectedmessage.equals(actualmessage) && expectedUrl.equals(actualUrl)) {
            System.out.println("SignUp message is same. Test Pass");

        }else {
            System.out.println("fail");
            System.out.println("actual message : "+ actualmessage);
            System.out.println("expected message : "+ expectedmessage);
            System.out.println("expected url : "+expectedUrl);
            System.out.println("actual url : "+ actualUrl);
        }
        UtilWait.wait(2);
        driver.close();

    }
}
