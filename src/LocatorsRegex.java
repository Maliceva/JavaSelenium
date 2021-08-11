import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsRegex {

    public static void main (String[] args) {
         /*
        //tagName[@contains(@attribute, 'value')] - XPath syntax
        tagName[Attribute*='value'] - CSS syntax
        */

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        // Find element by xpath using Regex
        driver.findElement(By.xpath("//input[contains(@name,'search')]")).sendKeys("Found this by contains @name");
        driver.findElement(By.xpath("//*[contains(text(),'Read Wikipedia in your language')]"));

        // Find element by CSS using Regex
        driver.findElement(By.cssSelector("input[name*='search']"));

        // Identify a child attribute from a parent
        driver.get("https://www.google.com/");

        //Start at the great-grandparent xpath then traverse down through the child tags to the search field
        driver.findElement(By.xpath("//div[@class='RNNXgb']/div/div[2]/input")).sendKeys("Found this through parents");

        driver.close();
    }
}
