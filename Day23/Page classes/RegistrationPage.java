package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    private By registerLink = By.id("registerLink");
    private By name = By.id("name");
    private By email = By.id("email");
    private By registerBtn = By.id("registerBtn");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistration() {
        driver.findElement(registerLink).click();
    }

    public void register(String userName, String userEmail) {
        driver.findElement(name).sendKeys(userName);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(registerBtn).click();
    }
}
