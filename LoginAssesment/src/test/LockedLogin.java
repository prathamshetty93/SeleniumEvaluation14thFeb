package test;

import Base.BaseCode;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LockedLogin {

    WebDriver driver;
    WebDriverWait myWait;

    TakesScreenshot ss;

    Page obj1=new Page();



    //Launching the website
    @Test(priority = 1)
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


    //Display error message for locked_out_user login
    @Test(dataProvider = "loginCredLocked",dataProviderClass = Page.class,priority = 2)
    public void lockedOutUser(String usr, String pwd) throws  IOException {
        myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj1.username())));

        WebElement user =driver.findElement(By.xpath(obj1.username()));
        user.sendKeys(usr);

        WebElement pass = driver.findElement(By.xpath(obj1.password()));
        pass.sendKeys(pwd);

        driver.findElement(By.xpath(obj1.login_button())).submit();

        ss=(TakesScreenshot)driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        File trg= new File("/Users/ppshetty/Desktop/Screenshots/errorpage.png");
        FileHandler.copy(src,trg);

        WebElement error = driver.findElement(By.xpath(obj1.error_message()));
        System.out.println(error.getText());

        driver.close();
    }


}
