package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void excelWriteTest1() throws IOException {
        //Bir "Nufus sutunu olusturun"
        //Baskent nufuslarini excel dosyasina yaziniz
        String dosyaYolu="src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sheet1").getRow(0).createCell(2).//yeni hucre olusturuyoruz bunu icin bu method'u kullandik
                setCellValue("NUFUS");//hucrenin icine yazacagimiz deger icin kullanilan method
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("1200");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1300");
        FileOutputStream fos=new FileOutputStream(dosyaYolu);//datalari bizim class'imizdan capitals dosyasina gonderecegiz
                                                        //bunun icin FOS objesi olusturduk
        workbook.write(fos);//woorkbook'daki datalari fos'a yazdirdik


    }
}
