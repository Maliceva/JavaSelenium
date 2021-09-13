import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* -----------------------------------------------------------------------------------------------------------------------------//
// Implicit Wait = Wait time is declared globally - "wait a maximum of x seconds until throwing an element not found exception" //
//  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);                                                             //
//    + Only have to declare it one time                                                                                        //
//    + Doesn't have to wait for the entire duration before finding the element                                                 //
//    + Makes code look cleaner (not declaring waits over and over)                                                             //
//    - Can hide performance issues                                                                                             //
//                                                                                                                              //
// Explicit Wait = Wait time is declared for an individual element                                                              //
//  WebDriverWait wait = new WebDriverWait(driver, 5);                                                                          //
//  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".whateverElement")));                              //
//    + Best used when specific elements take longer to load than others                                                        //
//    + Can catch performance issues                                                                                            //
//    - Can make code look messy                                                                                                //
//                                                                                                                              //
// Thread.sleep = Halts execution of the entire script for a specific number of milliseconds (1000ms = 1s                       //
//    - Not efficient (always waits the entire duration before script continues)                                                //
//    - Not smart (doesn't target a specific element)                                                                           //
//                                                                                                                              //
// Fluent Wait = Listens for a specific web element on a specified interval (10 seconds, polling 2 sec)                         //
//  Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))                          //
//    .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);                                              //
//     - Must build custom wait functions when using fluent wait                                                                //
//     - Similar to explicit wait, but explicit wait is more commonly used                                                      //
//     - Code can look messy and require lots of imports                                                                        //
// -----------------------------------------------------------------------------------------------------------------------------*/

public class Waits {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        implicitWait(driver);
        explicitWait(driver);
        fluentWait(driver);

        //Thread.sleep example - wait 3 seconds
        Thread.sleep(3000);
        System.out.println("I just waited 3 seconds using Thread.sleep");

        driver.close();
    }

    public static void implicitWait(WebDriver driver) {
        //Implicit wait example (wait a maximum of 10 seconds before any element is not found)
        driver.get("https://www.itgeared.com/demo/1506-ajax-loading.html");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
        System.out.println("Results text after implicit wait: " + driver.findElement(By.cssSelector("#results")).getText());
    }

    public static void explicitWait(WebDriver driver) {
        //Explicit wait for a specific element (wait a maximum of 10 seconds before this specific element is not found)
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.navigate().refresh();
        driver.findElement(By.linkText("Click to load get data via Ajax!")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#results")));
        System.out.println("Results text after explicit wait: " + driver.findElement(By.cssSelector("#results")).getText());
    }

    public static void fluentWait(WebDriver driver) {
        //Fluent wait example
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("#start button")).click();

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
        System.out.println("Results text after fluent wait: " + driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
    }
}
