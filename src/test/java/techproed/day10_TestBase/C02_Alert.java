package techproed.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {

//Bir metod olusturun: acceptAlert
    @Test
    public void acceptAlert() throws InterruptedException {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //1. butona tiklayin
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);

        //uyarıdaki OK butonuna tıklayın
        driver.switchTo().//gecmek/degistirmek. driver'i alert'e degistiriyoruz
                alert().//alert'e gecirdik
                accept();//ok/tamam butonuna basar
        //ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actualResult=driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']")).getText();
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);

    }
    //Bir metod olusturun: dismissAlert
    @Test
    public void dismissAlert() throws InterruptedException {
       // 2. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
       // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
       // ve result mesajının "successfuly" icermedigini test edin.
        String actualRslt=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
        String expectedRslt="successfully";
        Assert.assertFalse(actualRslt.contains(expectedRslt));

    }
// Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() {
        //3. butona tıklayın,
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        //uyarıdaki mesajı konsolda yazdırın,
        System.out.println(driver.switchTo().alert().getText());//gettext(), uyaridaki mesaji bize string olarak getirir
        //uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("zeynep");
        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        //ve result mesajında isminizin görüntülendiğini doğrulayın.
        String result=driver.findElement(By.xpath("//p[text()='You entered: zeynep']")).getText();
        String isim="zeynep";
        Assert.assertTrue(result.contains(isim));

    }
}
