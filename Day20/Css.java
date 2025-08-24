package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)");

        // Personal Details
        WebElement fname = driver.findElement(By.cssSelector("input[id='firstName']"));
        fname.sendKeys("Samarth");

        WebElement lname = driver.findElement(By.cssSelector("input[id='lastName']"));
        lname.sendKeys("Yadav");

        WebElement email = driver.findElement(By.cssSelector("input[id='userEmail']"));
        email.sendKeys("samyadav1461316@gmail.com");

        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();

        WebElement mobileno = driver.findElement(By.cssSelector("input[id='userNumber']"));
        mobileno.sendKeys("6268958328");

        // Date of Birth
        driver.findElement(By.cssSelector("input[id='dateOfBirthInput']")).click();
        driver.findElement(By.cssSelector("select.react-datepicker__year-select > option[value='2001']")).click();
        driver.findElement(By.cssSelector("select.react-datepicker__month-select > option[value='7']")).click(); // August (0-based index)
        driver.findElement(By.cssSelector("div[aria-label='Choose Tuesday, August 21st, 2001']")).click();

        // Subjects
        String[] subjects = {"Computer Science", "Maths", "English"};
        WebElement sub = driver.findElement(By.cssSelector("input[id='subjectsInput']"));
        for (String subject : subjects) {
            sub.sendKeys(subject);
            sub.sendKeys(Keys.ENTER);
        }

        // Hobbies
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();

        jse.executeScript("window.scrollBy(0,400)");

        // Upload Picture (change path according to your system)
        WebElement img = driver.findElement(By.cssSelector("input[id='uploadPicture']"));
        img.sendKeys("C:/Users/Samarth/Desktop/photo.jpg");

        // State & City
        WebElement state = driver.findElement(By.cssSelector("input[id='react-select-3-input']"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.cssSelector("input[id='react-select-4-input']"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        // Submit Form
        driver.findElement(By.cssSelector("button[id='submit']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
