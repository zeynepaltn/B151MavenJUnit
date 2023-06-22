package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_File_Upload extends TestBase {
    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec=driver.findElement(By.xpath("//input[@id='file-upload']"));

        ///Users/isaaltun       /Desktop/text.txt dosyasini yukleyecegim
        String farkliKisim=System.getProperty("user.home");
        String ayniKisim="/Desktop/text.txt";
        String dosyaYolu=farkliKisim+ayniKisim;
        dosyaSec.sendKeys(dosyaYolu);

        // 'Upload' butonuna basın
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        bekle(2);
        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement yazi=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(yazi.isDisplayed());

    }
}
