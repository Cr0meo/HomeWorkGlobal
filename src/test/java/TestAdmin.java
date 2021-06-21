import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TestAdmin extends MainBase{

    WebDriver drv;
    @BeforeEach
    public  void chromeSetUp()  {
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("start-maximized");
        drv = new ChromeDriver(opts);
        drv.get("http://158.101.173.161/admin/");
        drv.findElement(By.cssSelector(".form-control[name=username]")).sendKeys("testadmin");
        drv.findElement(By.cssSelector(".form-control[name=password]")).sendKeys("R8MRDAYT_test");
        drv.findElement(By.cssSelector("[type=submit]")).click();
    }

    @Test
    public void FirstTest()  {

         List<WebElement> appsMenu = (new WebDriverWait(drv, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("app")));

        for (int i = 0; i<appsMenu.size(); i++) {
            appsMenu = (new WebDriverWait(drv, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("app")));
        appsMenu.get(i).click();

        List<WebElement> selectedApps = drv.findElements(By.className("doc"));
        for (int n = 0; n< selectedApps.size(); n++){
            selectedApps = drv.findElements(By.className("doc"));
            selectedApps.get(n).click();
            Assertions.assertTrue(drv.findElement(By.className("panel-heading")).isDisplayed());
        }
        }

    }

//    @AfterEach
//    public void AfterEach(){
//        drv.quit();
//    }

 }
