//package com.example;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WindowType;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;

//public class App {

//    public static void main(String[] args) {

//        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

//        FirefoxOptions options = new FirefoxOptions();
//        options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox");

//        WebDriver driver = new FirefoxDriver(options);

//        try {

            // TAB 1 - SauceDemo
//            driver.get("https://www.saucedemo.com");

//            driver.findElement(By.id("user-name")).sendKeys("standard_user");
//            driver.findElement(By.id("password")).sendKeys("secret_sauce");
//            driver.findElement(By.id("login-button")).click();

          //  Thread.sleep(3000);

        //    if(driver.getCurrentUrl().contains("inventory"))
      //          System.out.println("SauceDemo Login Successful");
    //        else
  //              System.out.println("SauceDemo Login Failed");


            // TAB 2 - Practice Test Automation
//            driver.switchTo().newWindow(WindowType.TAB);

//            driver.get("https://practicetestautomation.com/practice-test-login/");

//            driver.findElement(By.id("username")).sendKeys("student");
//            driver.findElement(By.id("password")).sendKeys("Password123");
//            driver.findElement(By.id("submit")).click();

//            Thread.sleep(3000);

//            if(driver.getPageSource().contains("Logged In Successfully"))
      //          System.out.println("PracticeTestAutomation Login Successful");
    //        else
  //              System.out.println("PracticeTestAutomation Login Failed");


            // TAB 3 - Automation Exercise
//            driver.switchTo().newWindow(WindowType.TAB);

//            driver.get("https://automationexercise.com/login");

//            driver.findElement(By.name("email")).sendKeys("test@example.com");
//            driver.findElement(By.name("password")).sendKeys("test123");
//            driver.findElement(By.xpath("//button[text()='Login']")).click();

  //          Thread.sleep(3000);

//            if(driver.getPageSource().contains("Logout"))
          //      System.out.println("AutomationExercise Login Successful");
        //    else
      //          System.out.println("AutomationExercise Login Failed");

    //    } catch(Exception e) {
  //          e.printStackTrace();
//        }

//        driver.quit();
        
//      System.out.println("Browser Closed");
//    }
//}

package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Multi-Tab Firefox Automation Script
 * Purpose: Automate logins across multiple testing sites in a single headless session.
 */
public class App {

    public static void main(String[] args) {

        // Set path to GeckoDriver (Snap location as per your environment)
        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        
        // Setting the binary path for Firefox Snap installation
        options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox");

        // --- HEADLESS CONFIGURATION ---
        // Necessary for running on the Ubuntu VM via Jenkins
        options.addArguments("-headless"); 
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new FirefoxDriver(options);

        try {
            // TAB 1 - SauceDemo
            System.out.println("Opening Tab 1: SauceDemo...");
            driver.get("https://www.saucedemo.com");

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            Thread.sleep(3000);

            if(driver.getCurrentUrl().contains("inventory"))
                System.out.println("SauceDemo Login Successful");
            else
                System.out.println("SauceDemo Login Failed");


            // TAB 2 - Practice Test Automation
            System.out.println("Opening Tab 2: Practice Test Automation...");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");

            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            Thread.sleep(3000);

            if(driver.getPageSource().contains("Logged In Successfully"))
                System.out.println("PracticeTestAutomation Login Successful");
            else
                System.out.println("PracticeTestAutomation Login Failed");


            // TAB 3 - Automation Exercise
            System.out.println("Opening Tab 3: Automation Exercise...");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://automationexercise.com/login");

            // Use correct field identifiers for this site
            driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys("test@example.com");
            driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys("test123");
            driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

            Thread.sleep(3000);

            if(driver.getPageSource().contains("Logout"))
                System.out.println("AutomationExercise Login Successful");
            else
                System.out.println("AutomationExercise Login Failed");

        } catch(Exception e) {
            System.err.println("An error occurred during multi-tab execution:");
            e.printStackTrace();
        } finally {
            // Ensure the Firefox process is killed to release VM resources
            if (driver != null) {
                driver.quit();
                System.out.println("Firefox closed.");
            }
        }
    }
}
