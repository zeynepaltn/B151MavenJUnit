package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {
    @Test
    public void readExcelTest1() throws IOException {
        //3. satir 1. sutun degerini yazdirin
        // 1)Excel dosyasindan veri okuyabilmemiz icin oncelikle dosya yolunu almamiz lazim
        String dosyaYolu="src/test/java/resources/Capitals (2).xlsx";
        // 2)Capitals dosyasini bizim sistemimize getirmeliyiz.(Dosyayi okuabilmek icin Java ortamina getirmeliyiz, sisteme input etmeliyiz)
        FileInputStream fis=new FileInputStream(dosyaYolu);
        // 3)java ortaminda bir Excel dosyayi olusturmaliyiz, bu yuzden dosyayi workbook'a atamaliyiz
        Workbook workbook= WorkbookFactory.create(fis);

        //simdi 3. satir 1. sutun verisni alacagiz
        String satir3Sutun1=workbook.getSheet("Sheet1").getRow(2).getCell(0).toString(); //Excel dosyasini actigimizda islem yaptigmiz sayfanin sheet1 oldugunu goruyoruz
        System.out.println("satir 3 Sutun 1 = " + satir3Sutun1);
        //3. satir 1. sutunun degerinin "France" oldugunu test edin
        Assert.assertEquals("France",satir3Sutun1);
        //Son satir sayisini bulunuz
        int satirSayisi=workbook.getSheet("Sheet1").getLastRowNum(); // getLastRowNum(),`Bize satir sayisini index olarak getirir
        System.out.println("satir Sayisi = " + satirSayisi);
        //kullanilan satir sayisini bulun
        int kullanilanSatirSayisi=workbook.getSheet("Sheet1").getPhysicalNumberOfRows();//Bu method index olarak vermiyor
        System.out.println("kullanilan Satir Sayisi = " + kullanilanSatirSayisi);

    }

    @Test
    public void readExcelTest2() throws IOException {
        //Capitals dosyasindaki tum verileri yazdiriniz
        Map<String,String> capitalsMap=new HashMap<>();
        String dosyaYolu="src/test/java/resources/Capitals (2).xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        int sonSatirSayisi=workbook.getSheet("Sheet1").getLastRowNum();//for loop son satir sayisinda durmali bu sebeple önce son satir sayisini bulmaliyiz
        for (int i=0; i<=sonSatirSayisi; i++){
            String key=workbook.getSheet("Sheet1").getRow(i).getCell(0).//ilk sutun
            toString();
            String value=workbook.getSheet("Sheet1").getRow(i).getCell(1).//ikinci sutun
            toString();
            //simdi key ve value'yu map'e atayalim
            capitalsMap.put(key,value);
        }
        System.out.println(capitalsMap);


    }
}
