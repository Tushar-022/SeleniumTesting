// package com.example.tests;


// import java.util.List;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.Assert;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class WebpageElementCounter {
//     private WebDriver driver;

//     // Setup method to initialize WebDriver
//     @BeforeClass
//     public void setUp() {
//         WebDriverManager.chromedriver().setup(); // Setup WebDriverManager for ChromeDriver
//         driver = new ChromeDriver(); // Initialize WebDriver for Chrome
//     }

//     // Test method to count elements
//     @Test
//     public void countElements() {
//         driver.get("https://www.screener.in/register/?next=/dash/"); 
        
//         // Count links
//         List<WebElement> links = driver.findElements(By.tagName("a"));
//         System.out.println("Total number of links: " + links.size());

//         // Count buttons
//         List<WebElement> buttons = driver.findElements(By.tagName("button"));
//         System.out.println("Total number of buttons: " + buttons.size());

//         // Count input fields
//         List<WebElement> inputs = driver.findElements(By.tagName("input"));
//         System.out.println("Total number of input fields: " + inputs.size());

//         // Assertions to verify the count is greater than 0 (optional)
//         Assert.assertTrue(links.size() > 0, "Links count should be greater than 0");
//         Assert.assertTrue(buttons.size() > 0, "Buttons count should be greater than 0");
//         Assert.assertTrue(inputs.size() > 0, "Input fields count should be greater than 0");
//     }

//     // Cleanup method to close the browser after test
//     @AfterClass
//     public void tearDown() {
//         driver.quit(); // Close the browser after the test
//     }
// }
