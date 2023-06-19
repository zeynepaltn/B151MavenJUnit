package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_DragDrop extends TestBase {
    @Test
    public void test01() {
        //Given user is on https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        //Drag and Drop elementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0); //sadece bir tane iframe vardi o yuzden index kullandik
        /*
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        Birkac iframe olsaydi bu sekilde locate alip switch yapabilirdik
         */

        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
       /*
    Eğer bir hareketli webelementi tutup başka bir webelementin üzerine bırakmak istersek
    sürüklemek istediğimiz webelementin locate'ini alıp üzerine bırakacağımız webelementin
    lcoate'ini de alarak dragAndDrop(kaynak, hedef) methodu ile işlemi gerçekleştirebiliriz.
 */
    }

    @Test
    public void test02() {
        //Given user is on https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        //Drag and Drop elementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).//-->Bu method ile webelement'e mouse ile basili tuttuk
                moveToElement(drop).//-->Bu method ile basili tuttugumuz webelement'i diger webelement'in uzerine goturduk
                release().perform();//-->Bu method ile basili tuttugumuz webelement'i serbest biraktik
    }

    @Test
    public void test03() {
        //Given user is on https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");
        //And user moves the target element(Drag me to my target) in to  destination(Drop here
        //Drag and Drop elementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
        driver.switchTo().frame(0);
        WebElement drag=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop= driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//Belirtmis oldugumuz koordinatlara webelement'i tasir
                release().perform();


    }
}
