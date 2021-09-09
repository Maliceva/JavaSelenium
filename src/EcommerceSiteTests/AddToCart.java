package EcommerceSiteTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

/* ---------------------------------------------------------------------------------------------------
// Test Case: Add specific products to your shopping cart                                           //
// All products on the page have the same "Add to Cart" button with no unique identifier            //
// To find a specific product, we need to add all product names to an array and loop through them   //
// When the loop reaches the product name "Cucumber" and "Cauliflower", click Add to Cart           //
// -------------------------------------------------------------------------------------------------*/

public class AddToCart {
    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Products we expect to be in the cart at the end of the test
        String[] groceriesNeeded = {"Cucumber","Cauliflower","Beetroot","Carrot"};

        int j = 0;

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        Thread.sleep(3000);

        // Find all the product names on the page and save them as a list
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));


        for (int i=0;i<products.size();i++) {

           // productName must be formatted in order to remove " - 1 Kg" in order to match the groceriesNeeded text
           String[] productName = products.get(i).getText().split("-");
           String formattedProductName = productName[0].trim();

           // Check whether the name you extracted is in the groceriesNeeded list
           // Convert array into an arraylist to search more easily
           List groceryList = Arrays.asList(groceriesNeeded);

            if (groceryList.contains(formattedProductName)) {
                j++;
                //Click "Add to Cart" button for each product in the expected list
                driver.findElements(By.xpath("//*[@class='product-action']")).get(i).click();
                System.out.println("Added " + formattedProductName + " to Cart.");

                if(j==groceriesNeeded.length) {
                    break;
                }
            }
        }

        driver.close();
    }
}
