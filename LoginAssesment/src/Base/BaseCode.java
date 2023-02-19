package Base;

import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.util.Properties;

public class BaseCode {
    public static WebDriver driver;

    static Properties prop =new Properties();

    public static String getProperties(String key) throws Exception {
        String filePath=System.getProperty("user.dir")+"/src/resources/config.properties";
        FileInputStream input = new FileInputStream(filePath);
        prop.load(input);

        String value =prop.get(key).toString();

        if(StringUtils.isNullOrEmpty(value)){
            throw new Exception("Values not specified");
        }
        return value;
    }

}


