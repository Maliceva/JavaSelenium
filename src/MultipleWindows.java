import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        // Click a link to open a new browser tab
        driver.findElement(By.cssSelector(".blinkingText")).click();

        // The driver is still on the parent page, so you have to tell Selenium to switch over to the new page

        // 1. Get IDs of all the windows opened by your automation script [parentid,childid]
        Set<String> windows = driver.getWindowHandles();

        // 2. Extract the IDs from the data structure in step 1
        Iterator<String> windowIDs = windows.iterator();
        String parentId = windowIDs.next(); // 0th index
        String childId = windowIDs.next(); // 1st index

        // 3. Switch to the ID of the child window
        driver.switchTo().window(childId);

        // Grab some text from the child window
        System.out.println("Extracted text from the new child window: " + driver.findElement(By.cssSelector(".im-para.red")).getText());

        // Parse out only the email address from the string
        String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        System.out.println("Extracted email: " + email);

        // Switch back to the parent window and paste the extracted email
        driver.switchTo().window(parentId);
        driver.findElement(By.id("username")).sendKeys(email);
        System.out.println("Pasted " + email + " into the username field of the parent window");

        driver.close();
    }
}
