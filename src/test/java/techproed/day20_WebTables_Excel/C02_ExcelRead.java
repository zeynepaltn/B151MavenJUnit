package techproed.day20_WebTables_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {


    @Test
    public void excelReadTest1() throws IOException {

        // excel dosyasından veri okuyabilmemiz icin;
        // 1- dosya yolunu alırız
        String dosyaYolu = "src/test/java/resources/Capitals (2).xlsx"; //sag tik-copy path-ontent root

        // 2- Capitals dosyasını bizim sistemimize getirmeliyiz. Dosyayı okuyabilmek icin akışa almalıyız.
        FileInputStream fis = new FileInputStream(dosyaYolu);


        // 3- dosyayı workbook'a atamalıyız. Java ortamında bir excel dosyası olusturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);


        // 4- sayfayı(sheet) secmeliyiz
        Sheet sheet = workbook.getSheet("Sheet1");


        // satırı(row) secmeliyiz
        Row row = sheet.getRow(0);  // 1.satır, index 0 dan baslar.




        // hücreyi(cell) secmeliyiz
        Cell cell = row.getCell(0);  // 1.sütun, index 0 dan baslar.

    }

    @Test
    public void readExcelTest2() throws IOException {
        //KISA YONTEM
        //1. satir 1. sutundaki bilgiyi yazdiriniz
        String dosyaYolu="src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);
        String satir1Sutun1=workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        //excel'de index 0'dan baslar, toString() dememiz lazim en son cell'i string'e atayabilmek icin
        System.out.println(satir1Sutun1);

    }

    @Test
    public void readExcelTest3() throws IOException {
        //1. satir 2. sutundaki bilgiyi yazdiralim
        String dosyaYolu="src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook=WorkbookFactory.create(fis);
        String satir1Sutun2=workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println(satir1Sutun2);

    }
}