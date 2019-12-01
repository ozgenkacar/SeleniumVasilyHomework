package com.cbt.tests.TestNG;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testCase1 {
   private WebDriver driver;

   @BeforeMethod
  public void setup(){
      driver= BrowserFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.get("http://practice.cybertekschool.com/");
       UtilWait.wait(2);
   }

   @AfterMethod
   public void teardown(){
      driver.close();
   }

    /*
    Test case #1
    Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    Step 2. Click on “Registration Form”
    Step 3. Enter “wrong_dob” into date of birth input box.
    Step 4. Verify that warning message is displayed: “The date of birth is not valid”
     */
@Test(description = "Verify that warning message is displayed:'The date of birth is not valid' ")
   public void test1(){
   driver.findElement(By.linkText("Registration Form")).click();
   UtilWait.wait(2);
   driver.findElement(By.cssSelector("[placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");
   UtilWait.wait(2);
   String expectedMessage = "The date of birth is not valid";
   String actualMesage=driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();

   Assert.assertEquals(actualMesage,expectedMessage);

}



}
