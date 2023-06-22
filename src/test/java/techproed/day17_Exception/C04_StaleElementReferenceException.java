package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_StaleElementReferenceException extends TestBase {
    /*
    StaleElementReferenceException: Bir Web sayfasindaki bir web element'in gecerliliginin
    kayboldugu durumlarda olusur. Yani bir web element'i locate ettikten sonra sayfa da refresh,
    forward, back kullaniyorsak yeniden o elemente ulasmak istedigimizde StaleElementReferenceException
    hatasini aliriz. Bunu handle edebilmek icin web element'e yeniden ayni locate'i atamaliyiz.
    (Web element'in locate'ini hatirlatma diyebiliriz)
     */

    @Test
    public void StaleElementReferenceExceptionTest1() {
        //techpro sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //sayfayi yenileyelim
        driver.navigate().refresh();//dan sonra locate kodlar bayatlar ve tekrar tanitmamiz lazim
        //Lms login butonuna tiklayalim
        driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]")).click();


    }

    @Test
    public void StaleElementReferenceExceptionTest2() {
        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        // LMS LOGIN butonunun locate'ını alalım
        WebElement login=driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]"));
        login.click();
        // sayfayı yenileyelim
        driver.navigate().refresh();//sayfayi yeniledgimiz icin bir sonraki kod'da excp alacagiz
        // LMS LOGIN butonuna tıklayalım
        login.click();
        /*
        Lms login locate eskidi, bayatladi. Sonrasinda bayatlayan web element'i click yaptigimiz icin stale
        element reference exception hatasi aldik. Bu exception'i handle edebilmek icin, refresh yaptiktan sonra
        ayni locate'i bir web element'e atamamiz gerekiyor.
         */
    }

    @Test
    public void StaleElementReferenceExceptionTest3() {
        // techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        // LMS LOGIN butonunun locate'ını alalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        // sayfayı yenileyelim
        driver.navigate().refresh();

        // LMS LOGIN butonuna tıklayalım
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();


        /*
        Lms login locate eskidi, bayatladi. Sonrasinda bayatlayan web element'i click yaptigimiz icin stale
        element reference exception hatasi aldik. Bu exception'i handle edebilmek icin, refresh yaptiktan sonra
        ayni locate'i bir web element'e atamamiz gerekiyor.
         */
    }


}
