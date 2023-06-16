package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    /*
-Authentication kimlik dogrulama yöntemidir
- söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
- Authentication üzerinde sag click yapıp locate alınamaz
- Authentication bir alert degildir
- Authentication yapabilmek icin uygulamanın kullanıcılara,
Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
- https://username:password@URL gibi

 */

    @Test
    public void test1() {
        // Aşağıdaki bilgileri kullanarak authentication yapınız:
        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin
        /*
        Url:https://username:password@URL
        Yukaridaki belirtilen formata uygun kimlik dogrulama yapilacaktir
         */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement actual=driver.findElement(By.xpath("//p"));
        Assert.assertTrue(actual.getText().contains("Congratulations"));
    }
}
