package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
SCREENSHOT
        Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
   driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
   getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
   oranın yolunu belirtiriz.
 */

public class C01_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //Ve ekran görüntüsünü alalım

       // 1) Ilk olarak SS aldigimizda nereye kayd etmek istiyorsak oranin yolunu belirleyelim
        //sag tiklayip copy path'den content root ile aldik
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot.gif"; //scrrenShot.png bizim dosyaya kendimiz verdigimiz isim
        // 2) TakesScreenShot ara yuzunden obje olusturuuz
        TakesScreenshot ts= (TakesScreenshot) driver;
        // 3)FileUtils class'indan copyFile methodu ile TakesScreenShot objemizi kullanarak
        //getScreenShotAs methodu ile dosya yolunu belirtecegiz.
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }

    @Test
    public void test2() throws IOException {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("techproed/ScreenShot/screenShot.png"));

    }

    @Test
    public void test3() throws IOException {
        /*
        Kaydettigimiz ekran resmini her seferinde ayni dosya uzerine yazmamasi icin dosya isminden sonra
        String bir degiskene tarih formati atayabiliriz.
         */
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //SimpleDateFormat kullanarak yeni bir tarih formati olusturup yeni bir String'e assign ederiz.
        //Ve bunu dosya isimindn once belirtiriz.
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }

    @Test
    public void test4() throws IOException {
        driver.get("https://www.amazon.com");
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));



    }
}
