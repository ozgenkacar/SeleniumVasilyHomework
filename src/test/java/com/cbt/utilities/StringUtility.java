package com.cbt.utilities;


public class StringUtility {
   public static void Equals(String expected, String actual) {
       if(expected.equals(actual)) {
           System.out.println("test passed");
       } else {
           System.out.println("test failed");
       }

   }

    public static void Equals(String title1, String title2 , String title3) {
        if(title1.equals(title2) && title1.equals(title3)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

    }
}
