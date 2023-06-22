package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test01() {
        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        ///Users/isaaltun/Downloads/b10 all test cases, code.docx
        //Her test ettigimizde ayni file'i indirecegi icin cok fazla copy olacak
        // bu yuzden otomasyon ile once obje olusturup eger dosya already exist ise siliyoruz
        File silinecekDosya=new File("/Users/isaaltun/Downloads/b10 all test cases, code.docx");
        silinecekDosya.delete();

        //"b10 all test cases" dosyasını indirin
        WebElement indirilecekDosya=driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
        indirilecekDosya.click();
        bekle(5);
        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        Assert.assertTrue(Files.exists(Paths.get("/Users/isaaltun/Downloads/b10 all test cases, code.docx")));
        //simdi yukaridaki kodu daha dinamik hala getirelim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="/Downloads/b10 all test cases, code.docx";
        String dosyaYolu=farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        ///Users/isaaltun/Downloads/b10 all test cases, code.docx
    }
}
