package com.cbt.tests.TestNG;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6To12 {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();



    }

    public void teardown(){
        driver.close();
    }

    /*
    Test case #6
    Step 1. Go to "https://www.tempmailaddress.com/"
    Step 2. Copy and save email as a string.
    Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
    Step 4. And click on “Sign Up For Mailing List".
    Step 5. Enter any valid name.
    Step 6. Enter email from the Step 2.
    Step 7. Click Sign Up
    Step 8. Verify that following message is displayed: “Thank you for signing up. Click the button below to return to the home page.”
    Step 9. Navigate back to the “https://www.tempmailaddress.com/”

    Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
    Step 11. Click on that email to open it.
    Step 12. Verify that email is from: “do-not-reply@practice.cybertekschool.com”
    Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”

     */
    @Test
    public void test6(){
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.className("animace")).getText();


        driver.get("http://practice.cybertekschool.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.cssSelector("[name='full_name']")).sendKeys("ozgen");
        UtilWait.wait(1);
        driver.findElement(By.name("email")).sendKeys(email);
        UtilWait.wait(1);
        driver.findElement(By.name("wooden_spoon")).click();

        String expectedMessage ="Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage= driver.findElement(By.name("signup_message")).getText();
        Assert.assertEquals(actualMessage,expectedMessage);


        driver.navigate().to("https://www.tempmailaddress.com/");
        WebElement receivedEmail = driver.findElement(By.xpath("//td[(text()='do-not-reply@practice.cybertekschool.com')]"));
        Assert.assertTrue(receivedEmail.isDisplayed(), "do-not-reply@practice.cybertekschool.com");
        UtilWait.wait(10);
        receivedEmail.click();

        WebElement fromVerify = driver.findElement(By.id("odesilatel"));
        Assert.assertTrue(fromVerify.isDisplayed(), "do-not-reply@practice.cybertekschool.com");
        WebElement subjectVerify = driver.findElement(By.id("predmet"));
        Assert.assertTrue(subjectVerify.isDisplayed(), "Thanks for subscribing to practice.cybertekschool.com!");



    }
}
