import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Calendars {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        //Click the calendar field to open the calendar
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date1']")).click();

        //Select the current date (most calendars have a specific tag for this element)
        driver.findElement(By.cssSelector(".ui-datepicker-days-cell-over.ui-datepicker-today")).click();
        System.out.println("Selected current date: " + driver.findElement(By.xpath("//*[@id='view_fulldate_id_1']")).getText());

        //Select a specific date (April 14)
        String dayExpected = "14";
        String monthExpected = "April";

        driver.get("https://www.path2usa.com/travel-companions");

        // Open the calendar
        driver.findElement(By.id("travel_date")).click();

        // Selecting the month //

        //Find a common object across all months and search for the text you need
        while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch'] ")).getText().contains(monthExpected)) {
            //If the month does not match, click the >> arrow to change the month
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        //Selecting the day //

        // Find a common object across all dates (class='day') and put elements in a list
        List <WebElement> dates = driver.findElements(By.className("day"));
        int dateCount = dates.size();

        //Loop through the dates until you find the one you need
        for (int i=0;i<dateCount;i++) {
            String dateText = dates.get(i).getText();
            if (dateText.equalsIgnoreCase(dayExpected)){
                dates.get(i).click();
                break;
            }
        }

        driver.close();
    }
}
