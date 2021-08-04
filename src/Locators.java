import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Locators {

    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");

        // Find Element by ID
        driver.findElement(By.id("searchInput")).sendKeys("Found by ID");
        driver.findElement(By.id("searchInput")).clear();

        // Find Element by Xpath
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys("Xpath");
        driver.findElement(By.xpath("//*[@name='search']")).sendKeys(Keys.RETURN);

        // Find Element by Link Text
        driver.findElement(By.linkText("World Wide Web Consortium")).click();
        driver.navigate().back();

        //Find Element by Class Name
        System.out.println(driver.findElement(By.className("firstHeading")).getText());
        driver.navigate().back();

        //Find Element by Name
        driver.findElement(By.name("search")).sendKeys("Found by Name");
        driver.findElement(By.name("search")).clear();

        // Find specific element when multiple are returned
        driver.findElement(By.xpath("//*[@class='other-project'][1]")).click();
        driver.navigate().back();

        // Find Element by CSS Selector
        driver.findElement(By.cssSelector("#searchInput")).sendKeys("Found by CSS Selector");
        driver.findElement(By.cssSelector("#searchInput")).clear();

        // Find Elements in a List
        List<WebElement> elements = driver.findElements(By.xpath("//select[@id='searchLanguage']"));

        for (int i=0; i<elements.size(); i++) {
            System.out.println("Element text: " + elements.get(i).getText());
        }

        driver.close();
    }
}
