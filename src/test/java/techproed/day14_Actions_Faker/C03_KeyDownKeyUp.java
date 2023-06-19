package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasina gidiniz
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();
        //Shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim
        WebElement aramaKutusu=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//-->arama kutusunda shift tusuna bastik
                sendKeys("selenium").
                keyUp(Keys.SHIFT).//shift tusunu serbest biraktik
                sendKeys("Java",Keys.ENTER).perform();

    }
    /*
    keyDown(aramaKutusu, Keys.SHIFT) arama kutusunda shifte bastik--sendKeys("selenium") selenium yazdik
    --keyUp(Keys.SHIFT) shift biraktik--sendKeys("java", Keys.ENTER) java yazdik, arattik
    --perform(); ile actions i sonlandirdik
    NOT: shift tusu basili tutuldugunda yaziyi büyük harflerle yazar

    Google'da arama yaparken eğer kelimenin önüne -(tire işareti )
    koyarsak o kelime hariç anlamında deyip onu arama anlamına geliyor.
    Java ile igili pek bilgi çıkmayabilir google da.
 */

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();
        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);
      /*
        Mouse islemleri icin actions class' ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin
        actions class' ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni buyuk yazdirabilir,
        hatta birden fazla klavye tuslarina bastirabiliriz.Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek
        sonrasinda yazdirmak istedigimiz metni kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi, tekrar Keys.SHIFT
        kullanarak shift tusunu serbest birakmis olduk

        */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();
        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu= driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);
        // Sayfayı bekleyin
        bekle(2);
        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        //StaleElementReferenceException daha once locate'ini aldigimiz weblementin locate'i sayfa
       // yenilendigi icin degismis ve onceden aldigimiz locate ile isleme devam edince bu exeption'i aldik.

        driver.findElement(By.xpath("//*[@class='gLFyf']")).//sayfa yenilendigi icin tekrar locate aldik
                sendKeys(Keys.COMMAND,"a");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.COMMAND,"x");
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.COMMAND,"v",Keys.ENTER);
    }
}
