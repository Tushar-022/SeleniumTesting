// package com.example.tests;

// import java.util.List;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.ui.Select;
// import org.testng.Assert;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;

// import io.github.bonigarcia.wdm.WebDriverManager;

// public class Prac {

//     private WebDriver driver;

//     @BeforeClass
//     public void setup() {
//         // Setup ChromeDriver using WebDriverManager
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//     }

//     @Test
//     public void testDropdownItemsCount() {
//         // Navigate to the practice page
//         driver.get("https://the-internet.herokuapp.com/dropdown"); // Correct practice URL with dropdown

//         // Locate the dropdown element by ID
//         WebElement dropdownElement = driver.findElement(By.id("dropdown")); // Correct ID for the dropdown

//         // Use Select class to interact with the dropdown
//         Select dropdown = new Select(dropdownElement);

//         // Get all options in the dropdown
//         List<WebElement> options = dropdown.getOptions();

//         // Print all options for debugging
//         System.out.println("Dropdown Options:");
//         for (WebElement option : options) {
//             System.out.println(option.getText());
//         }

//         // Print the number of items
//         System.out.println("Number of items in the dropdown: " + options.size());

//         // Assert the count (expected count = 3)
//         int expectedCount = 3; // Includes "Please select an option"
//         Assert.assertEquals(options.size(), expectedCount, "Dropdown items count mismatch!");
//     }

//     @AfterClass
//     public void teardown() {
//         // Close the browser
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }