import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleFrames {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        // Get all iframes on the page
        System.out.println("Frames on the page: " + driver.findElements(By.tagName("iframe")).size());

        // The "draggable" element is inside an iframe, so Selenium can't see it by default
        // We need to switch to the frame where the element lives before interacting with it
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        driver.findElement(By.id("draggable")).click();

        Actions actions = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // Source = first parameter, destination = second parameter
        actions.dragAndDrop(draggable, droppable).build().perform();
        System.out.println("Dragged target to destination after switching to a frame");

        // Return back to the main page from the frame
        driver.switchTo().defaultContent();
        System.out.println("Left the iframe");

        // Nested frames example - get the text from the middle frame on the page
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));

        System.out.println("Middle frame text: " + driver.findElement(By.id("content")).getText());
        
        driver.close();
    }
}
