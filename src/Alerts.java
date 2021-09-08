import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

    // By default, Selenium cannot handle Javascript alerts
    // We need to switch to the alert in order to interact with it

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Generate an alert with a message and OK button
        String name = "Cassandra";
        driver.findElement(By.cssSelector("[id='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();

        //Switch context from your driver browser to the alert first
        //getText() method lets you grab the text inside the alert
        System.out.println("Alert text: " + driver.switchTo().alert().getText());

        //accept() method clicks on OK to dismiss the alert
        driver.switchTo().alert().accept();

        //Generate an alert with a message, OK and Cancel button
        driver.findElement(By.cssSelector("[id='name']")).sendKeys(name);
        driver.findElement(By.cssSelector("[id='confirmbtn']")).click();

        //dismiss() clicks the cancel button in the alert
        System.out.println("Alert text: " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        driver.close();
    }
}
