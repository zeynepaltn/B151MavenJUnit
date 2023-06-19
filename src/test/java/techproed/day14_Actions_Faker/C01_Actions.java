package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        //sayfanın üstüne doğru gidelim
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına doğru scroll yapalim
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.END);
        bekle(2);
        //sayfanın en üstüne doğru scroll yapalim
        actions.sendKeys(Keys.HOME).build().perform();
        //build()--> action'lari birlestirmek icin kullanilan method.Birden fazla olusturdugumuz action
        //objesini birbirine baglar.
        //release()-->methodu mouse'u birakir

    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın  altına doğru gidelim
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,1500).perform();
        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();


    }
}
