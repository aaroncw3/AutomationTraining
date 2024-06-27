package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {
        // Configura la ruta del controlador del navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aaron\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = getOptions();

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://formy-project.herokuapp.com/form");

        WebElement firstName=driver.findElement (By.id("first-name") ) ;
        firstName. sendKeys ("Aaron") ;
        WebElement lastName=driver. findElement (By . xpath("//* [@id='last-name']"));
        lastName. sendKeys ("Martinez");
        WebElement jobTitle=driver.findElement (By . xpath ("//*[@id='job-title']"));
        jobTitle. sendKeys ("Consultant") ;
        WebElement radio1=driver.findElement (By.id("radio-button-1"));
        radio1.click();
        WebElement radio2=driver.findElement (By.id("radio-button-2")) ;
        radio2.click();
        WebElement radio3=driver.findElement (By. id("radio-button-3") );
        radio3.click() ;
        WebElement check1=driver.findElement (By.id("checkbox-1")) ;
        check1.click() ;
        WebElement check2=driver.findElement (By.id("checkbox-2") ) ;
        check2 .click();
        WebElement check3=driver.findElement (By.id("checkbox-3")) ;
        check3.click();
        Thread. sleep (1000);
        Select select=new Select (driver.findElement (By.id ("select-menu") ) ) ;
        select.selectByValue ("4");

        WebElement date=driver.findElement (By.id("datepicker"));
        date.sendKeys ("06/26/2010");
        date.sendKeys(Keys.ENTER);
        Thread. sleep (4000);
        WebElement button1=driver.findElement (By.xpath("/html/body/div/form/div/div[8]/a"));
        button1.click() ;
        Thread. sleep (1000);
        driver.quit();
    }

    private static ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        return options;
    }

}
