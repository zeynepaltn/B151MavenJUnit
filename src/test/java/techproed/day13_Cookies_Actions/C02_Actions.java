package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/context_menu sitesine gidin
       driver.get("https://the-internet.herokuapp.com/context_menu");
        // Kutuya sag tıklayın
        WebElement kutu =driver.findElement(By.id("hot-spot"));
        //sag click yapabilmek icin oncelikle actions class'indan bir object olusturmaliyiz
        Actions actions= new Actions(driver);
        actions.contextClick(kutu).perform();//sag click yapma methodu kullandik, perform ile actions objesi ile
                                            //yapacagimiz islemi sonlandirdik
        // Alert’te cikan yazinin“You selected a context menu”oldugunu test edin

        Assert.assertEquals("You selected a context menu",driver.switchTo().alert().getText());
        // Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
