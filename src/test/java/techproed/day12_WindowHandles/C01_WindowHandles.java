package techproed.day12_WindowHandles;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
    //  ilk sayfasının Handle degerini alın yazdırın
        String sayfaHandle1=driver.getWindowHandle();
        System.out.println("sayfaHandle1 = " + sayfaHandle1);
        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement yazi=driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window",yazi.getText());
    //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String title1=driver.getTitle();
        Assert.assertEquals(title1,"The Internet");
    //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windowHandleSeti=driver.getWindowHandles();
        //System.out.println(windowHandleSeti);
        String sayfaHandle2="";
        for (String each:windowHandleSeti) {
            if(!each.equals(sayfaHandle1)){
                sayfaHandle2=each;
            }

        }
        driver.switchTo().window(sayfaHandle2);

    //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        String title2=driver.getTitle();
        Assert.assertEquals("New Window", title2);

    //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfaHandle1);
        Assert.assertEquals("The Internet", title1);
    //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfaHandle2);
    //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfaHandle1);
    }
}
