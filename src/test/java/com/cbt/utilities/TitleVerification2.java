package com.cbt.utilities;

import com.cbt.utilities.utils.UtilWait;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://luluandgeorgia.com/",
                "https://wayfair.com/", "https://walmart.com/" , "https://westelm.com/");

        for(int i=0;i<urls.size();i++) {

            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get("https://google.com");
            driver.navigate().to(urls.get(i));
            UtilWait.wait(3);

            String title = driver.getTitle();
            title =title.replace(" ","");
            title=title.toLowerCase();
            String urlName= (urls.get(i)).substring(8, (urls.get(i)).indexOf("."));
            urlName=urlName.toLowerCase();
            System.out.println(urlName+" "+title);
            if (title.contains(urlName)) {
                System.out.println(urls.get(i) + " pass");
            } else {
                System.out.println(urls.get(i)+" failed");
            }
            UtilWait.wait(3);
            driver.close();
        }

    }

    }

