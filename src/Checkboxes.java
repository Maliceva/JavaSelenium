import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Checkboxes {

    public static void main (String[] args)  {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //Locate the checkbox element and get its current state
        System.out.println("IsSelected state before clicking Student checkbox: " + driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());
        //Click the Student checkbox
        driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).click();
        //Get the state of the checkbox after clicking
        System.out.println("IsSelected state after clicking Student checkbox: " + driver.findElement(By.cssSelector("input[id*='StudentDiscount']")).isSelected());

        //Find all checkboxes on the page by a common locator
        int checkboxesCount = driver.findElements(By.cssSelector("input[type='checkbox']")).size();
        System.out.println("Found " + checkboxesCount + " checkboxes on the page");

        driver.close();
    }
}
