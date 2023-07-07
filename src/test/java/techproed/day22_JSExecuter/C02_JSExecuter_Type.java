package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Type extends TestBase {
    @Test
    public void typeTest() {
        // https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // reklam
        bekle(2);
        // Arama kutusuna "QA" yazıp aratın
        //********1. YOL***************
        WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].value='QA'",aramaKutusu);
        //sendKeysJS(aramaKutusu,"QA"); hazir method olusturup utills'den aldik


        //********* 2. YOL ***********
        // WebElement aramaKutusu =driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].setAttribute('value','QA')",aramaKutusu);
        sendAttributeJS(aramaKutusu,"QA");//method olsuturup
        aramaKutusu.submit();//enter'a basiyoruz

    }
}
