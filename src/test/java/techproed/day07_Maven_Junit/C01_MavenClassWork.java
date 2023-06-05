package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        // Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        Thread.sleep(2000);
        // Login alanina  "username" yazdirin
       WebElement login= driver.findElement(By.xpath("//input[@id='user_login']"));
       login.sendKeys("username");
        Thread.sleep(2000);
        // Password alanine "password" yazdirin
        WebElement login2=driver.findElement(By.xpath("//input[@id='user_password']"));
        login2.sendKeys("password");
        Thread.sleep(2000);
        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        Thread.sleep(2000);
        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();
        Thread.sleep(2000);
        // Online Banking bölümüne tıklamalın
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        Thread.sleep(2000);
        // Pay Bills yazan kısıma tıklayın
        driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();
        Thread.sleep(2000);
        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("100");
        Thread.sleep(2000);
        // Date kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10" + Keys.ENTER);
        Thread.sleep(2000);
        // Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        Thread.sleep(2000);
        // "The payment was successfully submitted." mesajinin ciktigini test edin
       WebElement mesaj= driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
       if(mesaj.isDisplayed()){
           System.out.println("Test PASSED");
       }else {
           System.out.println("False");
       }
        Thread.sleep(2000);
        // Sayfayi kapatın
        driver.close();
    }
}
