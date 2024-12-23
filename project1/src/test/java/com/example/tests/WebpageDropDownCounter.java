package com.example.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebpageDropDownCounter {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
           
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            String testUrl = "https://practice.expandtesting.com/dropdown"; // Replace with the desired URL
            driver.get(testUrl);

            
           List<WebElement> dropdowns = driver.findElements(By.id("elementsPerPageSelect"));
           int dropdownCount = dropdowns.size();

            
            System.out.println("=== Webpage Dropdown Count ===");
            System.out.println("Total number of dropdowns: " + dropdownCount);

            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
