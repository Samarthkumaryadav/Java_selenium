package SeleniumDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Page_validation {
    public static void main(String[] args) {
        System.out.println("This is Page Validation Script");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Selenium website
            String url = "https://www.selenium.dev/";
            driver.get(url);
            driver.manage().window().maximize();

            // Validate URL
            String expectedURL = "https://www.selenium.dev/";
            String actualURL = driver.getCurrentUrl();
            System.out.println("Expected URL : " + expectedURL);
            System.out.println("Actual URL   : " + actualURL);

            if (expectedURL.equals(actualURL)) {
                System.out.println("✅ URL Validation Successful");
            } else {
                System.out.println("❌ URL Validation Failed");
            }

            // Validate Page Title
            String expectedTitle = "Selenium";
            String actualTitle = driver.getTitle();
            System.out.println("Expected Title : " + expectedTitle);
            System.out.println("Actual Title   : " + actualTitle);

            if (actualTitle.contains(expectedTitle)) {
                System.out.println("✅ Title Validation Successful");
            } else {
                System.out.println("❌ Title Validation Failed");
            }

            System.out.println("Page Successfully Opened & Validated");
        } catch (Exception e) {
            System.out.println("⚠️ Unable to open or validate URL: " + e.getMessage());
        } finally {
            driver.close();
        }
    }
}
