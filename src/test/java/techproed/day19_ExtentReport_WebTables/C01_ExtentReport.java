package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
    EXTENTREPORT;
    1) ExtentReport(avenstack) kullanabilmek icin mvnrepository adresinden 4.0.9 versiyon numarali
    dependency'i pom.xml dosyamiza ekleriz.
    2) Class seviyesinde obje olustururuz;
        i) ExtentReports extentReports; //-->Raporlamayi baslatmak icin kullanilan class
        ii) ExtentHtmlReporter extentHtmlReporter;//-->Raporu HTMl formatinda duzenler
        iii) ExtentTest extentTest;//-->Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururz
     */
    ExtentReports extentReports;
    ExtentHtmlReporter extentHtmlReporter;
    ExtentTest extentTest;
    @Test
    public void test01() {
        extentReports=new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu="testOutput/extentReports/extentReport"+tarih+".html";
        extentHtmlReporter=new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//--> Html formatinda raporlamayi baslatacak

         /*
    Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
    testle ilgili bilgileri rapora ekleyebiliriz
     */

        //Raporda gozukmesini istedigim bilgiler icin ornekler
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Zeynep");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest=extentReports.createTest("Extent Test", "Test Raporu");

        //amazon sayfasina gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasina gidildi");
        //basligin amazon icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Sayfa basliginin Amazon icerdigi test edildi");
        //arama kutusunda iphone aratalim
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");
        //sonuc yazisini konsola yazdiralim
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("sonucYazisi = " + sonucYazisi.getText());
        extentTest.pass("Sonuc Yazisi konsola yazdirildi");
        extentTest.pass("Sayfa kapatildi");

         /*
            extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
        testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
        ekleyebiliriz.
            Ve son olarak actions daki perform methodu gibi extentReport objesi ile flush() methodu kullanarak
        raporu sonlandırırız
         */

        extentReports.flush();//bu methodu en son yapmazsak rapor olusmaz



    }

}


























