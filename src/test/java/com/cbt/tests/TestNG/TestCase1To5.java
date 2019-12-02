package com.cbt.tests.TestNG;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1To5 {
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
/*
Test case #4
Step 1. Go to https://practice-cybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter only one alphabetic character into last name input box.
Step 4. Verify that warning message is displayed: “The last name must be more than 2 and less than 64 characters long”
 */

@Test(description = "The last name must be more than 2 and less than 64 characters long")
    public void Test4(){
    driver.findElement(By.cssSelector("[name='lastname']")).sendKeys("a");
    String expectedMessage="The last name must be more than 2 and less than 64 characters long";
    String ActualMessage =driver.findElement(By.cssSelector("[data-bv-result='INVALID']")).getText();
    Assert.assertEquals(ActualMessage,expectedMessage);
}

/*
Test case #5
 Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
 Step 2. Click on “Registration Form”
 Step 3. Enter any valid first name.
 Step 4. Enter any valid last name.
 Step 5. Enter any valid user name.
 Step 6. Enter any valid password.
 Step 7. Enter any valid phone number.
 Step 8. Select gender.
 Step 9. Enter any valid date of birth.
 Step 10. Select any department.
 Step 11. Enter any job title.
 Step 12. Select java as a programming language.
 Step 13. Click Sign up.
 Step 14. Verify that following success message is displayed: “You've successfully completed registration!”

 */
@Test
public void Test5(){
    driver.findElement(By.name("firstname")).sendKeys("ozgen");
  UtilWait.wait(1);

    driver.findElement(By.name("lastname")).sendKeys("kacar");
    UtilWait.wait(1);

    driver.findElement(By.name("username")).sendKeys("ozkacar");
    UtilWait.wait(1);

    driver.findElement(By.name("email")).sendKeys("ozikacar@email.com");
    UtilWait.wait(1);

    driver.findElement(By.name("password")).sendKeys("23234589");
    UtilWait.wait(1);

    driver.findElement(By.name("phone")).sendKeys("571-123-4567");
    UtilWait.wait(1);;

    driver.findElement(By.cssSelector("*[value='female']")).click();
    UtilWait.wait(1);

    driver.findElement(By.cssSelector("*[placeholder ='MM/DD/YYYY']")).sendKeys("01/11/1990");
    UtilWait.wait(1);

    WebElement department = driver.findElement(By.name("department"));
    Select option = new Select(department);
    //List<WebElement> options = option.getOptions();
    option.selectByValue("TRO");
    UtilWait.wait(1);

    WebElement jobTitle = driver.findElement(By.name("job_title"));
    Select select = new Select(jobTitle);
   // List<WebElement> jobs = select.getOptions();
    select.selectByVisibleText("SDET");
    UtilWait.wait(1);

    driver.findElement(By.id("inlineCheckbox2")).click();
    UtilWait.wait(1);

    driver.findElement(By.cssSelector("button[type='submit']")).click();
    UtilWait.wait(1);

    String expectedMessage="You've successfully completed registration!";
    String actualMessage= driver.findElement(By.xpath("//p")).getText();
    Assert.assertEquals(actualMessage,expectedMessage);

}


}
