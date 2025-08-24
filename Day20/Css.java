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
    	JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,400)");

      
        WebElement fname = driver.findElement(By.cssSelector("input[id='firstName']"));
        fname.sendKeys("Nasir");

        WebElement lname = driver.findElement(By.cssSelector("input[id='lastName']"));
        lname.sendKeys("Guduru");

        WebElement email = driver.findElement(By.cssSelector("input[id='userEmail']"));
        email.sendKeys("nasir@gmail.com");

       driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
     
        WebElement mobileno = driver.findElement(By.cssSelector("input[id='userNumber']"));
        mobileno.sendKeys("9618214212");

        // Date of Birth
        driver.findElement(By.cssSelector("input[id='dateOfBirthInput']")).click();
        driver.findElement(By.cssSelector("select.react-datepicker__year-select > option[value='2025']")).click();
        driver.findElement(By.cssSelector("select.react-datepicker__month-select > option[value='8']")).click();
        driver.findElement(By.cssSelector("div[aria-label='Choose Thursday, September 25th, 2025']")).click();

        // Subjects
        String[] subjects = {"Math", "Physics", "Economics", "English"};
        WebElement sub = driver.findElement(By.cssSelector("input[id='subjectsInput']"));
        for (String subject : subjects) {
            sub.sendKeys(subject);
            sub.sendKeys(Keys.ENTER);
        }

        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']")).click();
    	jse.executeScript("window.scrollBy(0,400)");
 
        WebElement img = driver.findElement(By.cssSelector("input[id='uploadPicture']"));
        img.sendKeys("/Users/sai/Desktop/Wallpapers/DBZ.jpg");

        WebElement state = driver.findElement(By.cssSelector("input[id='react-select-3-input']"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        WebElement city = driver.findElement(By.cssSelector("input[id='react-select-4-input']"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("button[id='submit']")).click();
	    Thread.sleep(2000);
      
    }
}
