package SeleniumDemo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DemoQA {
    public static void main(String[] args) throws InterruptedException, IOException {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the demo practice form site
        driver.get("https://demoqa.com/automation-practice-form");
        Thread.sleep(2000);

        // Scroll down so form is visible
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400)");

        // Fill personal details
        driver.findElement(By.id("firstName")).sendKeys("Samarth");
        driver.findElement(By.id("lastName")).sendKeys("Yadav");
        driver.findElement(By.id("userEmail")).sendKeys("samyadav1461316@gmail.com");

        // Select gender
        driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();

        // Enter mobile number
        driver.findElement(By.id("userNumber")).sendKeys("6268958328");

        // Handle date of birth
        driver.findElement(By.id("dateOfBirthInput")).click();
        Select yearSelect = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        yearSelect.selectByVisibleText("2025");

        Select monthSelect = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        monthSelect.selectByVisibleText("July");

        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--013']")).click();

        // Subjects
        String[] subjects = {"Math", "Physics", "English"};
        WebElement subjectInput = driver.findElement(By.id("subjectsInput"));
        for (String s : subjects) {
            subjectInput.sendKeys(s);
            subjectInput.sendKeys(Keys.ENTER);
        }

        // Select hobbies
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-3']")).click();

        // Scroll down for picture upload
        js.executeScript("window.scrollBy(0, 400)");

        // Upload file (use correct file path in your PC)
        WebElement upload = driver.findElement(By.id("uploadPicture"));
        upload.sendKeys("/Users/sai/Desktop/Wallpapers/DBZ.jpg");

        // Select state and city
        WebElement stateInput = driver.findElement(By.id("react-select-3-input"));
        stateInput.sendKeys("NCR");
        stateInput.sendKeys(Keys.ENTER);

        WebElement cityInput = driver.findElement(By.id("react-select-4-input"));
        cityInput.sendKeys("Delhi");
        cityInput.sendKeys(Keys.ENTER);

        // Submit the form
        driver.findElement(By.id("submit")).click();

        // Take screenshot
        Thread.sleep(2000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("demoQA_screenshot.png");
        Files.copy(screenshot.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

        System.out.println("✅ Screenshot saved as 'demoQA_screenshot.png' in your project folder.");

        driver.quit();
    }
}
