package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C02_TumSayfaResmi extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="src/test/java/techproed/TumSayfaResmi/screenShot"+tarih+".jpeg";
        TakesScreenshot ts= (TakesScreenshot) driver;
        Files.write(Paths.get(dosyaYolu),ts.getScreenshotAs(OutputType.BYTES));

    }
}
