package com.example.tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginAutomationTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Setting up WebDriver...");
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("WebDriver setup complete.");
    }

    @Test
    public void testLogin() {
        System.out.println("Starting testLogin...");
        try {
            // Open target login page
            String url = "https://practicetestautomation.com/practice-test-login/";
            System.out.println("Navigating to URL: " + url);
            driver.get(url);

            // Wait for elements to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            System.out.println("Waiting for elements to load...");

            // Locate and interact with elements
            System.out.println("Locating username field...");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            System.out.println("Username field located.");

            System.out.println("Locating password field...");
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            System.out.println("Password field located.");

            System.out.println("Locating login button...");
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
            System.out.println("Login button located.");

            // Input credentials
            String username = "student"; // Test username
            String password = "Password123"; // Test password
            System.out.println("Entering username: " + username);
            usernameField.sendKeys(username);

            System.out.println("Entering password.");
            passwordField.sendKeys(password);

            // Submit the form
            System.out.println("Clicking login button...");
            loginButton.click();

            // Wait for the URL to change to the success page
            WebDriverWait urlWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            urlWait.until(ExpectedConditions.urlToBe("https://practicetestautomation.com/logged-in-successfully/"));

            // Validate login success
            assertTrue(driver.getCurrentUrl().equals("https://practicetestautomation.com/logged-in-successfully/"),
                    "Login was unsuccessful!");

            System.out.println("Login successful!");

        } catch (Exception e) {
            // Print stack trace for debugging
            System.err.println("An error occurred during the test.");
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tearing down WebDriver...");
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
        System.out.println("WebDriver closed.");
    }
}