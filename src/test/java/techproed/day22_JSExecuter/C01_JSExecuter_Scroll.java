package techproed.day22_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter_Scroll extends TestBase {
    JavascriptExecutor js;


    @Test
    public void jsExecuterScrollTest() {

        //  https://techproeducation.com sayfasına gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click(); // reklam
        bekle(2);
        // "We Offer" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement weOffer = driver.findElement(By.xpath("//span[text()='we offer']"));
        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",weOffer);
        scroll(weOffer);
        bekle(2);
        // Aynı sayfada "Enroll Free" elementi görünür olacak sekilde scroll et (sayfayı kaydır)
        WebElement enrollFree=driver.findElement(By.xpath(" //span[text()='Enroll Free Course']"));
        //js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
        scroll(enrollFree);
        bekle(2);
        // Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        WebElement whyUS=driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        //js= (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);",whyUS);
        scroll(whyUS);
        bekle(2);
        // Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et (sayfayı kaydır)
        scroll(enrollFree);
        bekle(2);
        // Sayfayi en üste scroll et (sayfayı kaydır)
        //js= (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); //0'i origin gibi dusun
        scrollHome();
        bekle(2);
        // Sayfayı en alta scroll et (sayfayı kaydır)
        //js= (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        scrollEnd();

    }
}