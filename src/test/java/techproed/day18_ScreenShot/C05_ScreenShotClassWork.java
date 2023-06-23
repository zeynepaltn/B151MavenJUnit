package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C05_ScreenShotClassWork extends TestBase {
    @Test
    public void test01() {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(1);

        //sayfanın resmini alalım
        tumSayfaResmi();

        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']")).sendKeys("Java", Keys.ENTER);

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi=driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi); //method kullanarak ss aldik

        //Yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //sayfanın resmini alalım
        tumSayfaResmi();
        //arama bölümde iphone aratalım
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //ve sonuc yazısının resmini alalım
        WebElement amazonSonucYazisi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        webElementResmi(amazonSonucYazisi);
        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        switchToWindow(0);
        tumSayfaResmi();
    }
}
