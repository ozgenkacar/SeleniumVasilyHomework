package com.cbt.tests.basicNavigationTest;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_3 {
    /*
    Test case #3 Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Multiple Buttons”
Step 3. Click on “Button 1”
Verify that result message is displayed: “Clicked on button one!”

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/");
        UtilWait.wait(2);
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        link.click();

        UtilWait.wait(2);
        WebElement button = driver.findElement(By.cssSelector("button[onclick='button1()']"));
        button.click();

        UtilWait.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        String resultMessage =result.getText();

        String expectedmessage ="Clicked on button one!";
        if(expectedmessage.equals(resultMessage)){
            System.out.println("test passed");
        } else {
            System.out.println("test fail");
            System.out.println("expectedmessage is : "+ expectedmessage);
            System.out.println("result message is : "+ resultMessage);
        }

        driver.close();
    }
}
