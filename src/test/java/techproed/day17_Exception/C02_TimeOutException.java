package techproed.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void TimeOutException() {
        /*
        TimeOutException: Sayfa'da aradigimiz element'i wait ile belirttigimiz
        max surede bulamadigi durumda bu exception'i aliriz
         */
        //techproed sayfasina gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //reklami kapatiniz
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //searchbox gorunur oluncaya kadar bekleyiniz
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='YANLISelementor-search-form-9f26725']")));//hatali kod
       /*
       TimeOutException alabilmek icin visibilityOfElementLocated methodunu kullanarak yanlıs bir locate aldık.

       webelement'i beklerken o webelementin locate'ını bulamadıgı icin max. belirttigimiz süre kadar bekledi ve
       TimeOutException hatasını verdi.
        */
    }

    @Test
    public void TimeOutExceptionTest2() {
        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasina gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        // Hello World! yazısının görünürlügünü test ediniz
        WebElement helloWorldYAzi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));//saniyeyi 5 in altina dusurursek de timeout excp aliriz
        wait.until(ExpectedConditions.visibilityOf(helloWorldYAzi));//bunu yazmazsam timeoutexcp aliyorum, cunku yazi gorunur olmuyor
        Assert.assertTrue(helloWorldYAzi.isDisplayed());



    }
}
/*
    at org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:87)
	at org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:231)
	at techproed.day17_Exception.C02_TimeOutException.TimeOutException(C02_TimeOutException.java:27)
 */