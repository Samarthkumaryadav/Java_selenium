package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage extends BasePage {

    private By offersLink = By.id("offersLink");

    public OffersPage(WebDriver driver) {
        super(driver);
    }

    public void viewOffers() {
        driver.findElement(offersLink).click();
    }
}
