package Utilities;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {
        FileReader fr= new FileReader("/Users/ppshetty/IdeaProjects/LoginAssesment/src/resources/config.properties");
        Properties pr =new Properties();
        pr.load(fr);

        System.out.println(pr.getProperty("testurl"));
    }
}
