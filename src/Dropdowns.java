import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

    public static void main (String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        // ----------------------------------------------- //
        // Static Dropdowns - consistent results regardless of user action //

        //Handling static dropdown list with select tag
        WebElement staticDropdownCurrency = driver.findElement(By.xpath("//*[@id='ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown = new Select(staticDropdownCurrency);

        //Get the 3rd option in the dropdown list (USD)
        dropdown.selectByIndex(3);
        System.out.println("Selected by index: " + dropdown.getFirstSelectedOption().getText());

        //Get a specific option based on displayed text
        dropdown.selectByVisibleText("AED");
        System.out.println("Selected by visible text: " + dropdown.getFirstSelectedOption().getText());

        //Get a specific option based on the value attribute in the HTML
        dropdown.selectByValue("INR");
        System.out.println("Selected by value: " + dropdown.getFirstSelectedOption().getText());

        //Click the Passengers dropdown to expand the section
        driver.findElement(By.xpath("//*[@id='divpaxinfo']")).click();
        Thread.sleep(2000L);
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        //Add four adult passengers by clicking the + icon 4 times
        int i=0;
        while(i<3){
            driver.findElement(By.xpath("//*[@id='hrefIncAdt']")).click();
            i++;
            System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        }

        //Close the passengers section
        driver.findElement(By.xpath("//*[@id='btnclosepaxoption']")).click();

        // ----------------------------------------------- //
        // Dynamic Dropdowns - loaded based on user action //

        //Open the "From" dynamic drop down
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
        //Select Adampur (AIP) as the "From" location
        driver.findElement(By.xpath("(//a[@value='AIP'])[1]")).click();
        Thread.sleep(2000);
        //Select Chennai (MAA) as the Destination (To)
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();


    }
}
