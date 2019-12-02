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

import java.util.List;

public class testCase1 {
   private WebDriver driver;

   @BeforeMethod
  public void setup(){
      driver= BrowserFactory.getDriver("chrome");
      driver.manage().window().maximize();
      driver.get("http://practice.cybertekschool.com/");
       UtilWait.wait(2);
       driver.findElement(By.linkText("Registration Form")).click();
       UtilWait.wait(1);
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
   driver.findElement(By.cssSelector("[placeholder='MM/DD/YYYY']")).sendKeys("wrong_dob");
   UtilWait.wait(2);
   String expectedMessage = "The date of birth is not valid";
   String actualMesage=driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();

   Assert.assertEquals(actualMesage,expectedMessage);

}
/*
Test case #2
Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Verify that following options for programming languages are displayed: c++, java, JavaScript
 */
@Test(description = "Verify that following options for programming languages are displayed: c++, java, JavaScript")
    public void test2(){
  List<WebElement> options =driver.findElements(By.className("form-check-input"));
    int  index =1;
  for (WebElement each: options){
    // Assert.assertTrue(each.isDisplayed());

      if(each.isDisplayed()){
          System.out.println(driver.findElement(By.cssSelector("[for='inlineCheckbox"+index+"']")).getText()+" programing language is displayed");
      }else{
          System.out.println("programing language is not displayed");
      }
      index++;
  }
}

/*
Test case #3 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into first name input box.
Step 4. Verify that warning message is displayed: “first name must be more than 2 and less than 64 characters long”
 */
@Test(description = "Verify that warning message is displayed: 'first name must be more than 2 and less than 64 characters long'")
    public void test3(){
    driver.findElement(By.cssSelector("[placeholder='first name']")).sendKeys("a");
    UtilWait.wait(3);
    String expectedMessage = "first name must be more than 2 and less than 64 characters long";
    String actualMessage =driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();
    UtilWait.wait(3);
    Assert.assertEquals(actualMessage,expectedMessage);
}
}
