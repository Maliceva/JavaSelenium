import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basics {

    public static void main(String[] args) {
        //Create driver object for Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Navigate to URL
        driver.get("https://www.google.com");

        //Get page title and return it
        System.out.println("Page title: " + driver.getTitle());

        //Enter text in the search field
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium java");

        //Hit the Enter key to submit
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);

        //Return number of results
        String results = driver.findElement(By.id("result-stats")).getText();
        System.out.println(results);

        // Find a search result by text and click the link
        driver.findElement(By.xpath(("//*[contains(text(), 'The Selenium Browser Automation Project')]"))).click();

        // Validate that we are on the expected page
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.selenium.dev/documentation/en/", currentUrl);

        //Close browser
        driver.close();


    }
}
