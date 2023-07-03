package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest=extentReports.createTest("ExtendReport","Test Raporu");
        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");
        //sayfanin resmini aliniz
        tumSayfaResmi();
        extentTest.info("Sayfanin resmi alindi");
        //arama kutusuna iphone yazdirin
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");
        extentTest.pass("Sayfa kapatildi");
        //flush methodu after'a util class'a koyduk
    }
}
