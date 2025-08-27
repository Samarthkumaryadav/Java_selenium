package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartIcon = By.id("cartIcon");
    private By checkoutBtn = By.id("checkoutBtn");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void checkout() {
        driver.findElement(checkoutBtn).click();
    }
}
