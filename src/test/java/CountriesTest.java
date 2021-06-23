import MainBasePack.MainBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class CountriesTest extends MainBase {
    @BeforeEach
    public void openUrl() {
        chromeSetUp();
        logonAdmin();
    }

    @Test
    public void countriesTest(){
        WebDriverWait wait = new WebDriverWait(drv, 10);
        drv.get(ADMIN_EDIT_Countries);
        String originWindow = drv.getWindowHandle();
        Set<String> existWindows = drv.getWindowHandles();
        List<WebElement> linksList = drv.findElements(By.cssSelector(".fa.fa-external-link"));
        for (WebElement elem : linksList) {
            elem.click();
            String newWindow = wait.until(anyWindowOtherThan(existWindows));
            drv.switchTo().window(newWindow).close();
            drv.switchTo().window(originWindow);
            
        }
            }

    @AfterEach
    public void AfterEach () {
        drv.quit();
    }
}
