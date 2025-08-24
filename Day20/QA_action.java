package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQA_Actions {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
        
        // Creating Actions instance
        Actions act = new Actions(driver);

        // Identifying source (draggable) and target (droppable)
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        
        // Performing drag and drop
        act.dragAndDrop(source, target).perform();

        Thread.sleep(3000); // Just to visually verify before closing
        driver.quit();
    }
}

