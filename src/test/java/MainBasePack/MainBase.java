package MainBasePack;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class MainBase {
    public WebDriver drv;
    public WebDriverWait wait;

    String BASE_URL = "";
    String LOGON_NAME = "";
    String LOGON_PASS = "";
    public String  ADMIN_EDIT_Countries = "";

    public  void chromeSetUp()  {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("start-maximized");
        drv = new ChromeDriver(opts);

    }
    public boolean isElementPresent(By element) {
        return drv.findElements(element).size() > 0;
    }
    public void openSite(){
        drv.get(BASE_URL);
    }
    public void logonAdmin() {
        WebDriverWait wait = new WebDriverWait(drv, 10);
        drv.get(BASE_URL + "/admin");
        if (isElementPresent(By.cssSelector(".form-control[name=username]"))) {
            drv.findElement(By.cssSelector(".form-control[name=username]")).sendKeys(LOGON_NAME);
            drv.findElement(By.cssSelector(".form-control[name=password]")).sendKeys(LOGON_PASS);
            drv.findElement(By.cssSelector("[type=submit]")).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.id("box-apps-menu")));
    }

    public ExpectedCondition<String> anyWindowOtherThan(Set<String> windows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver input) {
                Set<String> handles = drv.getWindowHandles();
                handles.removeAll( windows);
                return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
    }


