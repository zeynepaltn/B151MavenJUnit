package techproed.day13_Cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin

        driver.get("https://amazon.com");

        //2-tum cookie'leri listeleyin

        /*
    Cookie'leri listelemek istersek
            driver.manage().getCookies() methodu ile bir Set ya da ArrayList'e atarak listeyebiliriz
 */
        Set<Cookie> cookieSet =  driver.manage().getCookies();

        int sayac = 1 ;

        for (Cookie w:cookieSet) {
            System.out.println(sayac + ". cookie : " +w);
            System.out.println(sayac + ". cookieName : " +w.getName());//--->Sadece Cookilerin isimlerini alabiliriz

            System.out.println(sayac + ". cookieValue : " +w.getValue());//--->Sadece Cookilerin Valuelerini alabiliriz

            sayac++;

        }

        //ArrayList<Cookie> cookies = new ArrayList<>(driver.manage().getCookies());



        //Lamda ile Cookieleri yazdirdik yaptik
        // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);




        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("cookieSetlerin Sayisi = " + cookieSet.size());

        Assert.assertTrue(cookieSet.size()>5);



        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        ////getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gercek degerini
        // actualCookieValue degiskenine assign ettik
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        String expectedCookieValue ="USD";

        Assert.assertEquals(expectedCookieValue,actualCookieValue);


        // 5-ismi "en sevdigim cookie" ve
        // degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin

        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");

        driver.manage().addCookie(cookie);



        //6-eklediginiz cookie'nin sayfaya eklendigini test edin

        cookieSet = driver.manage().getCookies();

        for (Cookie each:cookieSet) {

            System.out.println(each);

        }
        //2. yol
        Assert.assertTrue(driver.manage().getCookieNamed("en sevdigim cookie").getValue().equals("cikolatali"));
        System.out.println(cookieSet.size());
       // System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());


        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        int silinmedenOnceSize = cookieSet.size();
        driver.manage().deleteCookieNamed("skin");//ismi skin olan cookie'yi sildik
        cookieSet = driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz
        int silindiktenSonraSize = cookieSet.size();
        Assert.assertEquals(1,(silinmedenOnceSize-silindiktenSonraSize));

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//tum cookie'leri sildik
        cookieSet=driver.manage().getCookies();//cookieSet'i guncelledik
        Assert.assertTrue(cookieSet.isEmpty());//set'in icinin bos oldugunu isEmpty() ile test ettik
    }
}