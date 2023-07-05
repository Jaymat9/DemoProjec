package Steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;


public class BlazeStepdefs {

    public WebDriver driver;
    public String url ="https://www.demoblaze.com/";
    @Given("User Launches {string}")
    public void userLaunches(String arg0) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);

        driver.get(url);
        driver.manage().window().maximize();

    }

    @When("User creates new account by clicking on Signs Up menu")
    public void userCreatesNewAccountByClickingOnSignsUpMenu() throws InterruptedException {

        driver.findElement(By.id("signin2")).
                click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='sign-username']")).
                sendKeys("Judith12v");

        driver.findElement(By.xpath("//*[@id='sign-password']")).
                sendKeys("pass1234");
        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[@onclick='register()']"))
                .click();

        Thread.sleep(3000);
        driver.switchTo().alert().accept();


     System.out.println("----------------User Signed Up ---------------");

    }

    @Then("User can navigate item and add products to the shopping cart")
    public void userCanNavigateItemAndAddProductsToTheShoppingCart() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("login2")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='loginusername']"))
                .sendKeys("Judith12z");
        driver.findElement(By.xpath("//*[@id='loginpassword']")).
                sendKeys("pass1234");
        driver.findElement(By.xpath("//*[@onclick='logIn()']"))
                .click();
        System.out.println("----------------User Logged In ---------------");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='next2']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'ASUS Full HD')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        System.out.println("----------------Product Added to Cart ---------------");

        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[contains(text(),'Nexus 6')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Add to cart')]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

        System.out.println("----------------Product Added to Cart ---------------");

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Cart')]")).click();

    }

    @And("User can Place order and finilize payment")
    public void userCanPlaceOrderAndFinilizePayment() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();


        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Judith");
        driver.findElement(By.xpath("//input[@id='country']")).sendKeys("South Africa");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Centurion");
        driver.findElement(By.xpath("//input[@id='card']")).sendKeys("2132123123");
        driver.findElement(By.xpath("//input[@id='month']")).sendKeys("april");
        driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2029");

        Thread.sleep(4000);

        driver.findElement(By.xpath("//button[@onclick='purchaseOrder()']")).click();
        System.out.println("----------------Prayment Successful ---------------");


        driver.close();
       /* Thread.sleep(3000);
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
        driver.findElement(By.id("logout2")).click();
        System.out.println("----------------Logout ---------------");

        */



    }

    @After
    public void Logout(){
        driver.close();
        System.out.println("----------------Logout ---------------");
    }
}
