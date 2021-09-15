import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrolling {

    /*--------------------------------------------------------------------------------------------------
    // Sometimes, the elements you want to interact with are not visible on the page until you scroll. //
    // To scroll down and make the elements visible, we need to use create a JavascriptExecutor,       //
    // then use executeScript() to run whatever Javascript is needed.                                  //
    // Javascript can be tested in the Console tab of the browser dev tools                            //
    //-------------------------------------------------------------------------------------------------*/

    public static void main (String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Create a Javascript executor and pass the driver object to it
        JavascriptExecutor js = (JavascriptExecutor)driver;

        // Scroll down the entire page (x = horizontal, y = vertical)
        js.executeScript("window.scrollBy(0,500)");

        // Scroll down inside a table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

    }
}
