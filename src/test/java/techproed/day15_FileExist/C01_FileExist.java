package techproed.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

//OPTION+COMMAND+C ile path kopyalayabilirsin
    @Test
    public void fileExist() {
        //isletim sistemi adi ogrenme
        System.out.println(System.getProperty("os.name"));

        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosya yolunu(path) verir.


        System.out.println(System.getProperty("user.home"));
        // herkesin bilgisayarında farklı olan kısmı verir.



        // SORU:
        // Desktop(masaustu)'da bir text dosyası olusturun



        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin

        /*
        dosyanın,bilgisayarımda destop'da olup olmadıgını
        Java ile test edecegim.
        cunku selenium, web sayfalarını test eder.
        Selenium, benim bilgisayarımdaki desktop'a mudahele edemez
         */

        //    "C:\Users\BURAK\Desktop\text.txt"
        Assert.assertTrue(Files.exists(Paths.get("/Users/isaaltun/Desktop/Batch151")));
        // daha dinamik hala getirelim
        ///Users/isaaltun/Desktop/text.txt

    }
}
    /*  Bir server'da farkli isletimsistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman,
        daha dinamik olmasi acisindan System.getProperty("os.name") bu sekilde isletim sistemini alir
        her isletim sisteminin kullanici yolu farkli olacagindan  System.getProperty("user.home")
        ile bilgisayarimizdaki kullanici yolunu alip bu sekilde String  bir degiskene farkli yol ismi ileSystem.getProperty("user.home")
        atayarak her seferinde farkli yollari almayla ugrasmamis oluruz. Dosya diyelimki masaustunde ve her isletim
        sisteminde bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assign ederiz.

     */

