import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WebDriverScope {

    /*------------------------------------------------------------------------------------------------
    // By default, the scope of the WebDriver is the entire webpage.                                //
    // You can limit the scope of the WebDriver by declaring a section of the page as a WebElement, //
    // then use that WebElement in a driver.findElements call to only search that part of the page.  //
    //----------------------------------------------------------------------------------------------*/

    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Get a count of how many links are on the page
        System.out.println("There are " + driver.findElements(By.tagName("a")).size() + " links on this page.");

        // Get a count of links present in the footer section
        WebElement footerSection = driver.findElement(By.cssSelector("#gf-BIG"));
        System.out.println("There are " + footerSection.findElements(By.tagName("a")).size() + " links in the footer section of the page.");

        // Get a count of links in the first column of the footer section
        WebElement footerColumn1 = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println("There are " + footerColumn1.findElements(By.tagName("a")).size() + " links in the first column of the footer section.");

        // Click on each link in the column without going back (open each link in a new tab), then verify the title of each page
        for (int i=1;i<footerColumn1.findElements(By.tagName("a")).size();i++) {
            // Ctrl+Click opens a link in a new browser tab. We can simulate this using the Keys class:
            String openLinkInNewTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            footerColumn1.findElements(By.tagName("a")).get(i).sendKeys(openLinkInNewTab);
        }

        Set<String> tabs = driver.getWindowHandles();
        Iterator<String> tabIds = tabs.iterator();

        // If there is a new index present in tabIds, switch to it and get the title
        while (tabIds.hasNext()){
            driver.switchTo().window(tabIds.next());
            System.out.println("Verified link title: " + driver.getTitle());
        }

        driver.close();
    }
}
