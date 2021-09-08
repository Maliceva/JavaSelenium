import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EnabledDisabled {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        /* Bad example: using isEnabled()

        //This returns True even though the field is disabled
        System.out.println("Return Date field before clicking 'Round Trip' radio button: " + driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isEnabled());

        //Click the "Round Trip" radio button to enable the "Return Date" field
        driver.findElement(By.xpath("//*[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();

        //This also returns True
        System.out.println("Return Date field after clicking 'Round Trip' radio button: " + driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isEnabled());
        /*

        /* ------------------------------------------------------------------------------------------------------------------------------------
        // Instead of using the Selenium method isEnabled() in this case, check to see if the HTML attribute is updated when clicking the button
        // In this case, the opacity in the style attribute changes from 1 to 0.5 when the Round Trip radio button is not selected
        //------------------------------------------------------------------------------------------------------------------------------------*/


        if(driver.findElement(By.xpath("//*[@id='Div1']")).getAttribute("style").contains("opacity: 1")) {
            //Pass the test if True is returned (field is enabled)
            Assert.assertTrue(true);
        }
        else {
            //Fail the test if False is returned (field is not enabled)
            Assert.assertTrue(false);
        }
    }
}
