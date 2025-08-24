package SeleniumDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Seleniumdev_Alerts {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Simple Alert
        WebElement simpleAlertButton = driver.findElement(By.id("alertButton"));
        simpleAlertButton.click();
        Alert simpleAlert = driver.switchTo().alert();
        simpleAlert.accept();

        // Timer Alert
        js.executeScript("window.scrollBy(0,400)");
        WebElement timerAlertButton = driver.findElement(By.id("timerAlertButton"));
        timerAlertButton.click();
        Thread.sleep(7000);
        Alert timerAlert = driver.switchTo().alert();
        timerAlert.accept();

        // Confirmation Alert
        js.executeScript("window.scrollBy(0,400)");
        WebElement confirmAlertButton = driver.findElement(By.id("confirmButton"));
        confirmAlertButton.click();
        Alert confirmAlert = driver.switchTo().alert();
        confirmAlert.dismiss();

        // Prompt Alert
        js.executeScript("window.scrollBy(0,400)");
        WebElement promptAlertButton = driver.findElement(By.id("promtButton"));
        promptAlertButton.click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("Samarth Yadav");
        promptAlert.accept();

        driver.quit();
    }
}
