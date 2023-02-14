import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {

    WebDriver driver;

    public void launchBrowser(){
        System.setProperty("Webdriver.chrome.driver","/Users/ppshetty/Downloads/chromedriver_mac64/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com");
    }

    public void signIn() throws InterruptedException {
        Thread.sleep(2000);
        WebElement user =driver.findElement(By.xpath("//input[@id='user-name']"));
        user.sendKeys("standard_user");
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();

    }

    public void addCart() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

    }

    public void checkout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("Pratham");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Shetty");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("575003");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();




    }

    public void overView() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        WebElement total =driver.findElement(By.xpath("//div[@class='summary_total_label']"));
        System.out.println(total.getText());
        driver.findElement(By.xpath("//button[@id='finish']")).click();
        js.executeScript("window.scrollTo(0,document.body.scrollTop)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
        Thread.sleep(2000);
    }


    public void lockedOutUser() throws InterruptedException {
        driver.navigate().to("https://www.saucedemo.com");
        Thread.sleep(2000);
        WebElement user =driver.findElement(By.xpath("//input[@id='user-name']"));
        user.sendKeys("locked_out_user");
        Thread.sleep(2000);
        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).submit();
        Thread.sleep(2000);
        WebElement error = driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]"));
        System.out.println(error.getText());
        driver.close();

    }




    public static void main(String[] args) throws InterruptedException {
        Main obj1 = new Main();
        obj1.launchBrowser();
        obj1.signIn();
        obj1.addCart();
        obj1.checkout();
        obj1.overView();
        obj1.lockedOutUser();
    }
}