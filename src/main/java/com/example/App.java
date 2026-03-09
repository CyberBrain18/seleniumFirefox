package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "/snap/bin/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox");

        WebDriver driver = new FirefoxDriver(options);

        try {

            // TAB 1 - SauceDemo
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
            driver.switchTo().newWindow(WindowType.TAB);

            driver.get("https://automationexercise.com/login");

            driver.findElement(By.name("email")).sendKeys("test@example.com");
            driver.findElement(By.name("password")).sendKeys("test123");
            driver.findElement(By.xpath("//button[text()='Login']")).click();

            Thread.sleep(3000);

            if(driver.getPageSource().contains("Logout"))
                System.out.println("AutomationExercise Login Successful");
            else
                System.out.println("AutomationExercise Login Failed");

        } catch(Exception e) {
            e.printStackTrace();
        }

        driver.quit();
        System.out.println("Browser Closed");
    }
}
