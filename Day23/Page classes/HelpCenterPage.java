package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelpCenterPage extends BasePage {

    private By helpLink = By.id("helpLink");

    public HelpCenterPage(WebDriver driver) {
        super(driver);
    }

    public void openHelpCenter() {
        driver.findElement(helpLink).click();
    }
}
