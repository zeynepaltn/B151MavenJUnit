package techproed.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase{
    /*
    NullPointerException:
    degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde
    NullPointerException hatasi aliriz.
    */
    WebDriver driver;
    Faker faker;
    Actions actions;
    Integer sayi;
    String isim;

    @Test
    public void NullPointerExceptionTest1() {
        //driver=new ChromeDriver(); atamasini yapmadigimiz icin nullpointer excp hatasi aldik
        driver.get("https://amazon.com");
    }

    @Test
    public void NullPointerExceptionTest2() {
        //faker=new faker() atamasini yapmadigimiz icin nullpointexc hatasi aldik
        System.out.println(faker.name().firstName());
    }

    @Test
    public void NullPointerExceptionTest3() {
        //actions=new Actions() atamasi yapmadigimiz icin NPE alacagiz
        actions.doubleClick().perform();
    }

    @Test
    public void NullPointerExceptionTest4() {
        //Obje olusturuldu ama deger atamasi yapilmadigi icin NPE aldik
        System.out.println(sayi + 5);
    }

    @Test
    public void NullPointerExceptionTest5() {
        //isim="Zeynep" degiskenine bu sekilde atama yapilmadigi icin NPE aldik
        System.out.println(isim.charAt(0));
    }
}
