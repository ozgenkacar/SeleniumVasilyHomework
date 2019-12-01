package com.cbt.tests.basicNavigationTest;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_7 {
    /*
    Test case #7
Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “testers@email” into email input box.
Step 4. Verify that warning message is displayed: “email address is not a valid
Email format is not correct”

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


        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("testers@email");
        UtilWait.wait(3);

   String actualmessage1 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[4]//small[@data-bv-validator='emailAddress']")).getText();
   String actualmessage2 = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[4]//small[@data-bv-validator='regexp']")).getText();

   String expectedMessage1 = "email address is not a valid ";
   String expectedMessage2 ="Email format is not correct";
        UtilWait.wait(3);
        if ( (actualmessage1.equals(expectedMessage1)) && (actualmessage2.equals(expectedMessage2))){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
            System.out.println("Actual message is : " + actualmessage1+" "+actualmessage2);
            System.out.println("Expected1 message is : " + expectedMessage1+" "+expectedMessage2 );
        }
        driver.close();
    }
}
