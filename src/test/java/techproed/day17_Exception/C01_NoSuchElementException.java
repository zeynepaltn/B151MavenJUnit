package techproed.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementException() {
        /*
        NoSuchElementException: Sayfa'da bulunmayan bir element'e erisim saglanmaya calisildiginda
        bu hatayi aliriz.(Locate alirken  hatali alinmis olabilir)
         */
        //techproeducation sayfasina gidin
        driver.get("https:www.techproeducation.com");
        bekle(2);
        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(1);
        //searchbox'a java yazip aratalim
        driver.findElement(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")).sendKeys("Java"+ Keys.ENTER);//HATALI KOD
        //burada path'e yanlis bir sey eklersek eger webelement'e ulasamayacagimiz icin exception alacagiz

    }
}
/*
at org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:87)
	at org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:231)
	at techproed.day17_Exception.C02_TimeOutException.TimeOutException(C02_TimeOutException.java:27)
 */
