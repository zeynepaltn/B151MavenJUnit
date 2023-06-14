package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {
    @Test
    public void iframe() {
        //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
        //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
        WebElement kalinYazi =driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));
        //==>  textBox içindeki yazıyı siliniz.
        //WebElement iframe = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        //driver.switchTo().frame(iframe); // iframe locate edildi, switchTo ile icteki website gecildi.
        driver.switchTo().frame(0);//index ile de iframe e gecebiliriz. Index 0'dan baslar
        /*


         */
        bekle(2);
        WebElement textBox = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear(); // textBox locate edildi ve icindeki silindi.
        //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame icinde yer almaktadir");
        bekle(2);
        //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        bekle(2);
        WebElement elementalselenium=driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalselenium.isDisplayed());


    }
}
