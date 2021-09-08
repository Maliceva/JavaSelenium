import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendars {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //Click the calendar field to open the calendar
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();

        //Select the current date
        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();
        System.out.println("Selected current date: " + driver.findElement(By.xpath("//*[@id='view_fulldate_id_1']")).getText());

        //Select a future date (TBD)

    }
}
