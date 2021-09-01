import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectors {
    public static void main (String[] args) {

        /* Notes:
        CSS Selector == tagname[attribute='value']

        - CSS is 10x faster than XPATH
        - Class under the class can only be identified by CSS
        - CSS has shortcuts: #id and .className
         */

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.cssSelector("input[id='searchInput']")).sendKeys("CSS");
        driver.findElement(By.cssSelector("#searchInput")).sendKeys(Keys.ENTER); //targets the same element as above, just written differently

        System.out.println(driver.getTitle());

        driver.close();

    }
}
