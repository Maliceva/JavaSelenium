import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Tables {
    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Create a Javascript executor and pass the driver object to it
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Scroll down to see the table element
        js.executeScript("window.scrollBy(0,500)");

        // Sum all numbers in the Amount column of the table
        int sum = 0;
        List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        for (int i = 0; i<amounts.size();i++) {
            // Get each number in the table and convert it to an Integer
            sum = sum + Integer.parseInt(amounts.get(i).getText());
        }

        System.out.println("Sum of all Amounts = " + sum);
        int actualTotal = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1]);

        Assert.assertEquals(sum, actualTotal);
    }
}
