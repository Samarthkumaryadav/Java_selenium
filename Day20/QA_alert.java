package SeleniumDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQA_Alerts {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)");

        // Simple Alert
        WebElement samplealert = driver.findElement(By.id("alertButton")); 
        samplealert.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert(); 
        alert.accept();

        // Timer Alert
        WebElement timealert = driver.findElement(By.id("timerAlertButton")); 
        timealert.click();
        Thread.sleep(7000);  // wait for alert to appear
        Alert alert2 = driver.switchTo().alert(); 
        alert2.accept();
        
        // Confirm Alert
        WebElement confirmalert = driver.findElement(By.id("confirmButton")); 
        confirmalert.click();
        Thread.sleep(2000);
        Alert alert3 = driver.switchTo().alert(); 
        alert3.dismiss();   // or .accept()
        
        // Prompt Alert
        WebElement promptalert = driver.findElement(By.id("promtButton"));
        promptalert.click();
        Thread.sleep(2000);
        Alert alert4 = driver.switchTo().alert(); 
        alert4.sendKeys("Samarth Yadav");  // ✅ Your name now
        alert4.accept();
        
        Thread.sleep(3000);
        driver.quit();
    }
}
