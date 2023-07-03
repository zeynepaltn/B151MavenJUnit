package techproed.day20_WebTables_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    /*
    <table> tagı ile başlar
    <thead> başlıklar için bu tag ile devam eder
        <tr> başlıkların satırı
          <th> table head sütun
            <td> başlıktaki veriler
              <tbody> başlıklar altındaki verileri temsil eder
                 <tr> table row(satır)
                    <td> table data (tablodaki veri)
     */

    @Test
    public void webTablesTest1() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //Table1'i yazdirin
        WebElement table1 =driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("table1 = " + table1.getText());

        System.out.printf("%-10s %-10s %-25s %-10s %-30s %s%n", "Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        System.out.printf("---------- ---------- ------------------------- ---------- ------------------------------ -------%n");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Smith", "John", "jsmith@gmail.com", 50.0, "http://www.jsmith.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Bach", "Frank", "fbach@yahoo.com", 51.0, "http://www.frank.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Doe", "Jason", "jdoe@hotmail.com", 100.0, "http://www.jdoe.com", "edit delete");
        System.out.printf("%-10s %-10s %-25s $%-9.2f %-30s %s%n", "Conway", "Tim", "tconway@earthlink.net", 50.0, "http://www.timconway.com", "edit delete");

    }

    @Test
    public void webTablesTest2() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //3. satir verilerini yazdirin
        List<WebElement> list=driver.findElements(By.xpath("(//table)[1]//tbody//tr[3]//td"));
        list.forEach(t-> System.out.print(t.getText()+ " "));

    }


    @Test
    public void webTablesTest3() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //4. satirdaki butun verileri yazdirin
        List<WebElement> satir4=driver.findElements(By.xpath("(//table)[1]//tbody//tr[4]//td"));
        //List<WebElement> sonSatirVerileri = driver.findElements(By.xpath("//table[1]//tbody//tr[last()]//td")); bu sekilde last kullanarak son satir yazdirabiliriz
        satir4.forEach(t-> System.out.print(t.getText()+"  "));

    }

    @Test
    public void webTablesTest4() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //5. sutun basligini yazdirin
        WebElement satirBaslik5=driver.findElement(By.xpath("(//table)[1]//thead//tr[1]//th[5]"));
        System.out.println(" 5. satirBasligi= " + satirBaslik5.getText());
        //5. sutunun tamamini yazdirin
        List<WebElement>  sutun5=driver.findElements(By.xpath("(//table)[1]//tbody//tr//td[5]"));
        sutun5.forEach(t-> System.out.print(t.getText()+" "));

    }


    @Test
    public void webTablesTest5() {
        //  https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        //iki parametreli bir java methodu olusturalim
        //parametre 1 satir numarasini, parametre 2 sutun numarasini ifade etsin
        //printData(2,3)===> 2. satir, 3. sutundaki veriyi yazdirin
        printData(2,3);
        printData(2,5);
       // printData(1,7);
        // 7 sutun yok table'da bu yuzden NoSuchElement Exception verecek, path'e ulasamadigi icin

    }

    public void printData(int satir, int sutun) {
        WebElement satirSutun=driver.findElement(By.xpath("//table[1]//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(satirSutun.getText());
    }
}//class
