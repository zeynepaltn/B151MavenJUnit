package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_TumSayfaResmi extends TestBase {
    @Test
    public void Test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım
        tumSayfaResmi();
    }
}
