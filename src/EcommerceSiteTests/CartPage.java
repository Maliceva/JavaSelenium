package EcommerceSiteTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CartPage {

    public static void main (String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Products we're adding to the cart
        String[] groceriesNeeded = {"Cucumber","Cauliflower","Beetroot","Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        ProductsPage.addItems(driver, groceriesNeeded);
        ViewCart(driver);
        EnterPromoCode(driver);

        driver.close();
    }

    public static void ViewCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        driver.findElement(By.xpath("//*[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        System.out.println("On cart page: " + driver.getCurrentUrl());
    }

    public static void EnterPromoCode(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        String validPromoCode = "rahulshettyacademy";
        String invalidPromoCode = "thisIsAnInvalidCode";

        //Unhappy Path
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys(invalidPromoCode);
        driver.findElement(By.cssSelector(".promoBtn")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".promo-btn-loader")));
        System.out.println("Message after entering an invalid code: " +  driver.findElement(By.cssSelector(".promoInfo")).getText());

        //Happy Path
        driver.findElement(By.cssSelector("input.promoCode")).clear();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys(validPromoCode);
        driver.findElement(By.cssSelector(".promoBtn")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".promo-btn-loader")));
        System.out.println("Message after entering a valid code: " +  driver.findElement(By.cssSelector(".promoInfo")).getText());
    }

}
