package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {
    @Test
    public void test1() {
        //Amazon a gidelim https://www.amazon.com/
        driver.get("https://amazon.com");
        //Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
        WebElement move = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(move).perform();
        //moveToElement() methodu ile mouse'u istediğimiz webElementin üzerine götürebiliriz
        WebElement element = driver.findElement(By.xpath("//span[text()='Account']"));
        actions.click(element).perform();
        //Acilan sayfanin Title in "Your Account" icerdigini dogrula
        Assert.assertTrue(driver.getTitle().contains("Your Account"));

    }
}
