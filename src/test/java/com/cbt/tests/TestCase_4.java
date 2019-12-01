package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.utils.UtilWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase_4 {
    /*
    Test case #4 Step 1. Go to https://practicecybertekschool.herokuapp.com
Step 2. Click on “Registration Form”
Step 3. Enter “123” into ﬁrst name input box.
Step 4. Verify that warning message is displayed: “ﬁrst name can only consist of alphabetical letters”

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

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("123");
        UtilWait.wait(3);
        String actualmessage = driver.findElement(By.xpath("//small[@data-bv-validator='regexp']")).getText();

        String expectedMessage ="first name can only consist of alphabetical letters";
        UtilWait.wait(3);
        if(actualmessage.equals(expectedMessage)){
            System.out.println("Pass");
            System.out.println("Actual message is : "+actualmessage);
            System.out.println("Expected message is : "+ expectedMessage);
        }else{
            System.out.println("Failed");
            System.out.println("Actual message is : "+actualmessage);
            System.out.println("Expected message is : "+ expectedMessage);

        }
driver.close();

    }
}
