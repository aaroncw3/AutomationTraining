import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumFinalProject {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aaron\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        login("standard_user", "secret_sauce");
        addToCart ();
        checkoutPage ("Aaron ", "Martinez", "01234");
    }

   @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void login(String username, String password) {
        driver.get("https://www.saucedemo.com/v1/");
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();


        WebElement nextDashboard =driver.findElement(By.xpath("//*[@id='inventory_filter_container']/div"));
        assertTrue(nextDashboard.isDisplayed(), "Login was successful");
    }


    public void addToCart () throws InterruptedException {

        WebElement button1 = driver.findElement(By.xpath("//* [@id=\"inventory_container\"]/div/div[1]/div[3]/button"));
        button1.click();

        WebElement button2 = driver.findElement(By.xpath("//* [@id=\"inventory_container\"]/div/div [2]/div[3 ]/button"));
        button2.click();

        WebElement button3 = driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div/div[3]/div[3]/button"));
        button3.click();

        Thread.sleep(2000);

        WebElement cartButton =driver.findElement(By.id("shopping_cart_container"));
        cartButton.click();

        WebElement nextDashboard = driver.findElement(By.id("contents_wrapper"));
        //message = nextDashboard.getText();
        assertTrue(nextDashboard.isDisplayed(), "passed to checkout");
    }

    public void checkoutPage (String name, String lastname, String zip) throws InterruptedException {
        String message;
        Thread.sleep (2000);
        WebElement remove1=driver.findElement (By .xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button"));
        remove1.click();
        Thread.sleep (2000);
        WebElement checkout=driver . findElement (By . xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]"));
        checkout.click();
        WebElement nextDashboard=driver.findElement (By.xpath("//* [@id=\"contents_wrapper\"]/div[2]"));
        WebElement firstName=driver.findElement (By. id("first-name"));
        firstName. sendKeys (name) ;
        WebElement lastName=driver.findElement (By.id("last-name") );
        lastName.sendKeys (lastname);
        WebElement pcode=driver.findElement(By. id("postal-code") );
        pcode. sendKeys (zip);
        Thread.sleep(2000);
        WebElement continueButton=driver.findElement(By.xpath("//* [@id=\"checkout_info_container\"]/div/form/div[ 2 ]/input"));
        continueButton.click();
        Thread.sleep (3000);
        WebElement FinishButton=driver.findElement (By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]"));
        FinishButton.click();
        WebElement confirmationMessage=driver.findElement (By.xpath("//*[@id=\"checkout_complete_container\"]/h2"));
        Thread.sleep (3000);
        message= confirmationMessage.getText();
        assertEquals ("THANK YOU FOR YOUR ORDER", message);

}
}
