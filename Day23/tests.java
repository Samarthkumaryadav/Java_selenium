package Testing_package;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

// Author: Samarth Yadav
// Email: samyadav1461316@gmail.com
// Project: Tira Beauty Automation Test

public class Tira_SamarthYadav {
    WebDriver driver;
    Pageclass2_SamarthYadav pg;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        pg = new Pageclass2_SamarthYadav(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.tirabeauty.com/");
    }

    @Test(priority = 1)
    public void multiSearch() throws InterruptedException {
        String[] items = {"Primer", "Lip liner", "Mascara"};
        for (String i : items) {
            pg.search1(i);
            Thread.sleep(3000);
        }
    }

    @Test(priority = 2)
    public void atocart() throws InterruptedException {
        pg.addanddeletetocart();
        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void helpc() throws InterruptedException {
        pg.helpcen("9347823783", "samyadav1461316@gmail.com", "abcdefg", "zmxncnvb");
        Thread.sleep(3000);
    }

    @Test(priority = 4)
    public void brand1() throws InterruptedException {
        pg.brand();
    }

    @Test(priority = 5)
    public void offer1() throws InterruptedException {
        pg.offer();
        Thread.sleep(3000);
    }

    @Test(priority = 6)
    public void desc() throws InterruptedException {
        driver.get("https://www.tirabeauty.com/product/lakme-absolute-skin-natural-mousse-mattreal-foundation-spf-8---04-golden-light-25g-wcdkkcnfr38");
        String desc = pg.getDesc1();
        System.out.println(desc);
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void subscrip() throws InterruptedException {
        pg.subscription("samyadav1461316@gmail.com");
        Thread.sleep(3000);
    }

    @Test(priority = 8)
    public void shades() throws InterruptedException {
        pg.shade();
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void faqsss() throws InterruptedException {
        pg.faqss();
        Thread.sleep(3000);
    }

    @Test(priority = 10)
    public void instagram() throws InterruptedException {
        pg.instagram();
    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
