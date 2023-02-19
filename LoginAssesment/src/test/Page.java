package test;


import org.testng.annotations.DataProvider;


public class Page {

    //WebDriver driver;


    @DataProvider(name = "loginCred")
    public Object[][] getData() {
        Object[][] data = {{"standard_user","secret_sauce"}};
        return data;
    }

    @DataProvider(name = "loginCredLocked")
    public Object[][] getDataLock() {
        Object[][] data = {{"locked_out_user","secret_sauce"}};
        return data;
    }

    public String username(){
        return  "//input[@id='user-name']";
    }

    public String password(){
        return  "//input[@id='password']";
    }

    public String login_button(){
        return  "//input[@id='login-button']";
    }

    public String item_1(){
        return  "//button[@id='add-to-cart-sauce-labs-bike-light']";
    }

    public String item_2(){
        return  "//button[@id='add-to-cart-sauce-labs-fleece-jacket']";
    }

    public String item_3(){
        return  "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']";
    }

    public String cart(){
        return  "//a[@class='shopping_cart_link']";
    }

    public String checkout(){
        return  "//button[@id='checkout']";
    }

    public String firstname(){
        return  "//input[@id='first-name']";
    }

    public String lastname(){
        return  "//input[@id='last-name']";
    }

    public String pincode(){
        return  "//input[@id='postal-code']";
    }

    public String continue_button(){
        return  "//input[@id='continue']";
    }

    public String total_item(){
        return  "//div[@class='summary_total_label']";
    }

    public String finish(){
        return  "//button[@id='finish']";
    }

    public String back(){
        return  "//button[@id='back-to-products']";
    }

    public String error_message(){
        return "//h3[contains(text(),'Epic sadface: Sorry, this user has been locked out')]";
    }

}



