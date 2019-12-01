package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_6 {
    /*
  Test case #6
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “user” into username input box.
Step 4. Verify that warning message is displayed: “The username must be more than 6 and less than 30 characters long”

     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/");
        UtilWait.wait(2);

        WebElement link = driver.findElement(By.linkText("Registration Form"));
        link.click();
        UtilWait.wait(2);


        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("user");
        UtilWait.wait(3);

    // String actualmessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[3]/div//small[@data-bv-validator='stringLength']")).getText();
        String actualmessage = driver.findElement((By.xpath("//small[@style='display: block;']"))).getText();
        String expectedMessage = "The username must be more than 6 and less than 30 characters long";
        UtilWait.wait(3);
        if (actualmessage.equals(expectedMessage)) {
            System.out.println("Pass");
        } else {
            System.out.println("Failed");
            System.out.println("Actual message is : " + actualmessage);
            System.out.println("Expected message is : " + expectedMessage);

        }
        driver.close();
    }
}
