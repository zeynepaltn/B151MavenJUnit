package techproed.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {
    //pencereler arasi gecis yapabilmek icin o pencerenin handle degeri lazim
    @Test
    public void windowHandle() {
        //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //techpro penceresinin handle degerini bulalim
        String techproWindowHandle= driver.getWindowHandle();
        System.out.println("techproWindowHandle = " + techproWindowHandle);
        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle=driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(actualTitle,expectedTitle);
        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
        bekle(1);
        driver.switchTo().newWindow(WindowType.WINDOW);//Yeni bir pencereye driver'i tasir
        driver.get("https://www.youtube.com");
        String youTubeWindowHandle=driver.getWindowHandle();
        System.out.println("youTubeWindowHandle = " + youTubeWindowHandle);

        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        bekle(1);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();
        System.out.println("linkedinWindowHandle = " + linkedinWindowHandle);
        //  techproeducation sayfasına geçiniz
        bekle(1);
        driver.switchTo().window(techproWindowHandle);
        //  youtube sayfasına geçiniz
        bekle(1);
        driver.switchTo().window(youTubeWindowHandle);
        //  linkedIn sayfasına geçiniz:
        bekle(1);
        driver.switchTo().window(linkedinWindowHandle);


    }
}
