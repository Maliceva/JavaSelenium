import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExamples {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        /*---------------------------------------------------//
        // Mouseover an element                              //
        // move the cursor to an element but not clicking it //
        //---------------------------------------------------*/

        // 1. Declare Actions object
        Actions actions = new Actions(driver);

        // 2. Define what action to occur, then build and perform the action
        WebElement accountHover = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(accountHover).build().perform();

        /*---------------------------------------------------------------//
        // Actions can be used to create complicated user interactions   //
        // Move to a field, click it, hold the Shift key, and enter text //
        //---------------------------------------------------------------*/

        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("this text should be in all caps").build().perform();

        driver.findElement(By.id("twotabsearchtextbox")).clear();

        /*-------------------------------------------------//
        // Selecting text in an element using double click //
        //-------------------------------------------------*/

        actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().sendKeys("This text should be highlighted").doubleClick().perform();

        /*-------------------------------------------------//
        // Right click an element to display a submenu     //
        //-------------------------------------------------*/

        actions.moveToElement(accountHover).contextClick().build().perform();

        /*-----------------------------//
        // Drag and drop an element    //
        //-----------------------------*/

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        // Source = first parameter, destination = second parameter
        actions.dragAndDrop(draggable, droppable).build().perform();

        driver.close();
    }
}