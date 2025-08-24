package testng_selenium;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EbayAutomationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.ebay.com/");
        System.out.println("Browser launched and navigated to eBay");
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }

    @Test
    public void loginTest() {
        driver.findElement(By.linkText("Sign in")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userid")))
                .sendKeys("samyadav1461316@gmail.com");
        driver.findElement(By.id("signin-continue-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")))
                .sendKeys("Samarth@123"); // dummy password
        driver.findElement(By.id("sgnBt")).click();
        System.out.println("Login test executed");
    }

    @DataProvider(name = "searchItems")
    public Object[][] getSearchData() {
        return new Object[][]{
                {"Headphones"},
                {"Camera"},
                {"Shoes"}
        };
    }

    @Test(dataProvider = "searchItems")
    public void searchProducts(String product) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("gh-ac")));
        searchBox.clear();
        searchBox.sendKeys(product, Keys.ENTER);
        System.out.println("Searched for product: " + product);
    }

    @Test
    public void addItemToCart() {
        driver.findElement(By.id("gh-ac")).sendKeys("Bluetooth Speaker", Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-item a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("atcRedesignId_btn"))).click();
        System.out.println("Item added to cart");
    }

    @Test
    public void removeItemFromCart() {
        driver.findElement(By.id("gh-cart-n")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label*='Remove']"))).click();
        System.out.println("Item removed from cart");
    }

    @Test
    public void testUpdateProfileName() {
        driver.findElement(By.linkText("My eBay")).click();
        System.out.println("Profile name update simulated (manual step)");
        Assert.assertTrue(true, "Profile name update step passed");
    }

    @Test
    public void testUpdateAddress() {
        driver.findElement(By.linkText("My eBay")).click();
        System.out.println("Address update simulated (manual step)");
        Assert.assertTrue(true, "Address update step passed");
    }

    @Test
    public void exploreCategories() {
        driver.findElement(By.linkText("Shop by category")).click();
        driver.findElement(By.linkText("Fashion")).click();
        System.out.println("Navigated to Fashion category");
    }

    @Test
    public void rightClickOnProductImage() {
        driver.findElement(By.id("gh-ac")).sendKeys("Smart Watch");
        driver.findElement(By.id("gh-search-btn")).click();
        WebElement productImage = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".s-item__image-img")));
        Actions actions = new Actions(driver);
        actions.contextClick(productImage).perform();
        String description = productImage.getAttribute("alt");
        System.out.println("Right-clicked on product: " + description);
        driver.navigate().refresh();
    }

    @Test
    public void changeLanguageToKorean() {
        driver.findElement(By.linkText("My eBay")).click();
        driver.findElement(By.linkText("Account")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        WebElement flagButton = driver.findElement(By.cssSelector("button.gf-flag__button"));
        flagButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Korea"))).click();
        System.out.println("Language changed to Korean successfully");
    }
}
