// TestNG framework is required to use Assertions. Download this JAR and add it to your project (or use Maven):
// https://mvnrepository.com/artifact/org.testng/testng


import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assertions {

    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        // Expects a false value to be returned by the argument (this checkbox is unchecked by default)
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());

        driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
        // Expects a true value to be returned by the argument
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());

        // Adds one additional adult passenger
        driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
        // Expects the first value (actual) to match the second value (expected)
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "2 Adult");

        driver.close();
    }
}
