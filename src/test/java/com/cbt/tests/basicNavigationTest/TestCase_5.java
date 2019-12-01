package com.cbt.tests.basicNavigationTest;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_5 {
    /*
    Test case #5 Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into last name input box.
Step 4. Verify that warning message is displayed: “The last name can only consist of alphabetical letters and dash”

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

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("123");
        UtilWait.wait(3);
  //  String actualmessage = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/form/div[2]/div//small[@data-bv-validator='regexp']")).getText();
String actualmessage = driver.findElement((By.xpath("//small[@style='display: block;']"))).getText();
        String expectedMessage = "The last name can only consist of alphabetical letters and dash";
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