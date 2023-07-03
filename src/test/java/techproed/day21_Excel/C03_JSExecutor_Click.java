package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
    /*
    Eger bir web sayfasinin HTML kodlari tamamen ya da kismen JavaScript kullanilarak olusturulduysa o sayfayla
    etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir.
    Bu durumda sayfayla etkilesime gecebilmek icin JavaScriptExecuter ara yuzunu kullanmak gerekir.
    JSExecuter arayuzu sayfaya dogrudan erisebilir.
    Ancak mumkunse webdriver'in sundugu standard yontemlerle sayfayla etkilesime gecmek her zaman
     daha iyidir, cunku JavaScript kullanimi sayfanin daha yavas yuklenmesine neden olabilir.
 */
     /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
     */

    @Test
    public void jsExecuterClick() {
        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");
        //Returns kismina tiklayin
        WebElement returns=driver.findElement(By.xpath("//a[@id='nav-orders']"));
        //returns.click();
        /*
    Ilgili webElementin HTML kodu , JavaScript kullanilarak olusturulduysa standart WebDriver komutu olan click()
    yetersiz kalabilir. Boyle durumlarda JavaScriptExecuter kullanilarak sayfa ile etkilesime gecilebilir
 */
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", returns);
        click(returns);//Reusable method yaptik TestBase'de click() ve bununla cagirdik
    }

}
