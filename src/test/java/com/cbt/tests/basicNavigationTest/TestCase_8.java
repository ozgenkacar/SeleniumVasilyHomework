package com.cbt.tests.basicNavigationTest;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_8 {
    /*
    Test case #8
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “5711234354” into phone number input box.
Step 4. Verify that warning message is displayed: “Phone format is not correct”
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


            WebElement phoneNumber = driver.findElement(By.name("phone"));
            phoneNumber.sendKeys("5711234354");
            UtilWait.wait(3);

            String actualmessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[6]//small[@data-bv-validator='regexp']")).getText();

            String expectedMessage = "Phone format is not correct";

            UtilWait.wait(3);
            if ( actualmessage.equals(expectedMessage)) {
                System.out.println("Pass");
            } else {
                System.out.println("Failed");
                System.out.println("Actual message is : " + actualmessage );
                System.out.println("Expected message is : " + expectedMessage);

            }
            driver.close();
        }
    }

