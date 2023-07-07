package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_GetValue extends TestBase {
    @Test
    public void test1() {
        //  https://www.carettahotel.com/ sayfasına gidiniz
        driver.get("https://www.carettahotel.com");
        bekle(1);
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        //check-in date kismini JS ile locate edin
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement date= (WebElement) js.executeScript("return document.getElementById('checkin_date')");

        //Css locator ile nasil yapariz? Simdi ona bakalim
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //WebElement date= (WebElement) js.executeScript("return document.querySelector(\"input[id='checkin_date']\")");

        /*
        Eger bir web sayfasinda webelementler olusturulurken JS kullanilmissa, normal olarak
        locate almakta zorlanabiliriz. Bu gibi durumlarda JSExecutor kullanarak webelementi locate edebiliriz
         */
        //Check=In date kismina 5/25/2023 tarihini yazin
        date.clear();
        date.sendKeys("5/25/2023");
        //Check-In Date kisminin degerini yazdirin
        String valueAttribute= (String) js.executeScript("return document.getElementById('checkin_date').value");
        System.out.println(valueAttribute);

    }
}
