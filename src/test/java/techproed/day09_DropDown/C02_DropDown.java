package techproed.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    WebDriver driver;
    /*
    -getFirstSelectedOption()==> dropdown'daki en son sectigimiz option'u bize dondurur
    -getOptions()==>dropdown'daki tum option'lari bize dondurur
     */

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement ddmStates=driver.findElement(By.xpath("//select[@id='state']"));
        Select select=new Select(ddmStates);
        //select.selectByVisibleText("Arizona");
        select.selectByValue("AZ");

        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
        WebElement firstSelected=select.getFirstSelectedOption();
        String sonSecilenOpsiyon=firstSelected.getText();
        Assert.assertEquals("Arizona",sonSecilenOpsiyon);

        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
        //1. YOL
        List<WebElement> tumOptions=select.getOptions();
        //for (WebElement each:tumOptions) {
          //  System.out.println(each.getText());}
        tumOptions.
                stream().
                forEach(t-> System.out.println(t.getText()));


        //2. YOL
        /*
        List<WebElement> tumOptionlar=driver.findElements(By.xpath("//select[@id='state']//option"));
        tumOptionlar.stream().forEach(t-> System.out.println(t.getText()));

         */



    }
}
