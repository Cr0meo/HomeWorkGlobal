import MainBasePack.MainBase;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class TestAdmin extends MainBase {

//    WebDriver drv;
    @BeforeEach
    public void openAndLogon(){
        chromeSetUp();
        logonAdmin();
    }


    @Test
    public void FirstTest()  {

         List<WebElement> appsMenu = (new WebDriverWait(drv, 10)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("app")));

        for (int i = 0; i<appsMenu.size(); i++) {
            appsMenu = (drv.findElements(By.className("app")));
        appsMenu.get(i).click();

        List<WebElement> selectedApps = drv.findElements(By.className("doc"));
        for (int n = 0; n< selectedApps.size(); n++){
            selectedApps = drv.findElements(By.className("doc"));
            selectedApps.get(n).click();
            Assertions.assertTrue(drv.findElement(By.className("panel-heading")).isDisplayed(), "Heading NOT found");
        }
        }

    }

    @AfterEach
    public void AfterEach(){
        drv.quit();
    }

 }
