package test;


import Base.BaseCode;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class SignIn  {
    WebDriver driver;
    WebDriverWait myWait;
    TakesScreenshot ss;


    Page obj1=new Page();


    //launching the website
    @BeforeSuite
    public void setUp() throws Exception {

        String browser = BaseCode.getProperties("browser");
        String url = BaseCode.getProperties("testurl");

        if (browser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("Webdriver.chrome.driver", "/Users/ppshetty/Downloads/chromedriver_mac64/chromedriver");
            driver = new ChromeDriver();
            driver.get(url);
        }
    }

    //closing the website after the test
    @AfterSuite
    public void closure(){
        driver.quit();
    }


    //User login using username and password
    @Test(dataProvider = "loginCred",dataProviderClass = Page.class,priority = 1)
    public void signIn(String usr, String pwd)  throws IOException {



        myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.username())));

        WebElement user =driver.findElement(By.xpath(obj1.username()));
        user.sendKeys(usr);
        WebElement pass = driver.findElement(By.xpath(obj1.password()));
        pass.sendKeys(pwd);

        driver.findElement(By.xpath(obj1.login_button())).click();

        ss=(TakesScreenshot)driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        File trg= new File("/Users/ppshetty/Desktop/Screenshots/signin.png");
        FileHandler.copy(src,trg);
    }


    //adding the items to the cart
    @Test(priority = 2)
    public void addCart() throws IOException {

        myWait=new WebDriverWait(driver, Duration.ofSeconds(20));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.item_1())));
        driver.findElement(By.xpath(obj1.item_1())).click();

        driver.findElement(By.xpath(obj1.item_2())).click();

        driver.findElement(By.xpath(obj1.item_3())).click();

        driver.findElement(By.xpath(obj1.cart())).click();

        ss=(TakesScreenshot)driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        File trg= new File("/Users/ppshetty/Desktop/Screenshots/addcarts.png");
        FileHandler.copy(src,trg);

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        driver.findElement(By.xpath(obj1.checkout())).click();

    }

    //redirecting to the checkout page
    @Test(priority = 3)
    public void checkout() throws  IOException {
        myWait=new WebDriverWait(driver, Duration.ofSeconds(20));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.firstname())));

        driver.findElement(By.xpath(obj1.firstname())).sendKeys("Pratham");
        driver.findElement(By.xpath(obj1.lastname())).sendKeys("Shetty");
        driver.findElement(By.xpath(obj1.pincode())).sendKeys("575003");

        ss=(TakesScreenshot)driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        File trg= new File("/Users/ppshetty/Desktop/Screenshots/checkout.png");
        FileHandler.copy(src,trg);

        driver.findElement(By.xpath(obj1.continue_button())).click();
    }

    //Finish process and back to home
    @Test(priority = 4)
    public void overView() throws IOException {

        myWait=new WebDriverWait(driver, Duration.ofSeconds(20));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.total_item())));

        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        WebElement total =driver.findElement(By.xpath(obj1.total_item()));
        System.out.println(total.getText());
        driver.findElement(By.xpath(obj1.finish())).click();
        js.executeScript("window.scrollTo(0,document.body.scrollTop)");

        ss=(TakesScreenshot)driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        File trg= new File("/Users/ppshetty/Desktop/Screenshots/finalpage.png");
        FileHandler.copy(src,trg);

        driver.findElement(By.xpath(obj1.back())).click();

    }


}
