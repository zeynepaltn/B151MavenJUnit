package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WEresmi extends TestBase {
    /*
    Bir web element'in resmini almak icin once web element'i locate edip bir webelement'e assign
    ederiz ve bu webelement'i direk getScreenShotAs() ile belirttigimiz dosyaya kaydederiz.
     */
    @Test
    public void test01() throws IOException {
        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        bekle(2);
        //iphone aratalim
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        //cikan sonuc yazisinin resmini alalim
        WebElement sonucYazisi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/ElementResmi/WEscreenShot"+tarih+".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE), new File(dosyaYolu));

    }
}
