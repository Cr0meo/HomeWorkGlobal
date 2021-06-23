import MainBasePack.MainBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

public class Cart_Tests extends MainBase {
    @BeforeEach
    public void openUrl() {
        chromeSetUp();
        openSite();
    }
    public void addPopularItemToCart (String itemName){
        String item = "#box-popular-products "+"[data-name='"+itemName+"']";
        WebElement productNew = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(item)));
        productNew.click();
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("add_cart_product")));
        addButton.click();
    }
    @Test
    public void addToCart() throws InterruptedException {
        WebElement acceptCookies = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("accept_cookies")));
        acceptCookies.click();
        addPopularItemToCart("Green Duck");
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".badge.quantity"), "1"));
        openSite();
        addPopularItemToCart("Purple Duck");
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".badge.quantity"), "2"));
        openSite();
        addPopularItemToCart("Red Duck");
        wait.until(ExpectedConditions.textToBe(By.cssSelector(".badge.quantity"), "3"));
        openSite();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cart"))).click();
        List<WebElement> cartList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("remove_cart_item")));
        for (int i = 0; i< cartList.size(); i++) {
            WebElement cartSummary = drv.findElement(By.id("box-checkout-summary"));
           drv.findElement(By.name("remove_cart_item")).click();
            wait.until(ExpectedConditions.stalenessOf(cartSummary));
           Assertions.assertTrue(drv.findElement(By.xpath("//*['There are no items in your cart.']")).isDisplayed(), "There are some items in cart");
        }


    }


        @AfterEach
        public void AfterEach () {
            drv.quit();
        }
    }



